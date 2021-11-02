import React, { useCallback, useState } from "react";
import { cn } from "@bem-react/classname";
import { IClassNameProps } from "@bem-react/core";
import { Button } from '@mui/material';
import { Search as SearchIcon } from '@mui/icons-material';
import { CleanHands } from '@mui/icons-material';
import { baseUrl } from "../../utils/url";
import { baseUrlFull } from "../../utils/url";
import { setInterviews } from '../Interviews/interviewsSlice';
import axios from "axios";
import { useAppDispatch } from "../../hooks/hooks";
import { setBase, setLoan, setIncome, setGuarantor, setPledge } from "../Profile/profileSlice";

import './Search.scss';

const cnSearch = cn('Search');
const searchCn = cnSearch();
const searchInputCn = cnSearch('Input');
const searchButtonCn = cnSearch('Button');

export const Search: React.FC = () => {
    const dispatch = useAppDispatch();
    const [name, setName] = useState('');

    const onInputChange = (e: any) => {
        setName(e.target.value)
    }

    const onFindClick = useCallback(() => {
        console.log('huy');
        
        const sendFIORequest = (endPoint: string) => {
            return axios(`${baseUrlFull}${endPoint}`, { params: { 'fio': name }});
        }
        sendFIORequest('base')
            .then(response => dispatch(setBase(response.data)));


        sendFIORequest('loan')
            .then(response => {
                const loanObj = response.data;
                loanObj.appDate = `${loanObj.appDate.split('T')[0]} : ${loanObj.appDate.split('T')[1].split('.')[0]}`
                dispatch(setLoan(loanObj));
            });

        sendFIORequest('income')
            .then(response => dispatch(setIncome(response.data)));

        sendFIORequest('guarantor')
            .then(response => dispatch(setGuarantor(response.data)));

        // sendFIORequest('pledge')
        //     .then(response => dispatch(setPledge(response.data)));


        axios(`${baseUrlFull}interview`)
            .then(response => dispatch(setInterviews(response.data)));
    }, [name])

    const reset = () => {
        dispatch(setInterviews([]));
        dispatch(setBase(null));
        dispatch(setLoan(null));
        dispatch(setIncome(null));
        dispatch(setGuarantor(null));
    }

    return (
        <div className={searchCn}>
            <input onChange={onInputChange} className={searchInputCn} type="text" placeholder="Лопатин Иван Иванович"/>
            <button onClick={() => console.log('huy')}>АНАЛЬНЫЙ БЕГЕМОТ</button>
            <Button onClick={onFindClick} className={searchButtonCn} startIcon={<SearchIcon />} />
            <Button onClick={reset} className={searchButtonCn} startIcon={<CleanHands />}>Сбросить</Button>
        </div>
    )
}