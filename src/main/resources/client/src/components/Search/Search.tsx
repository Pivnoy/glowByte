import React, { useCallback, useState } from "react";
import { cn } from "@bem-react/classname";
import { IClassNameProps } from "@bem-react/core";
import { Button } from '@mui/material';
import { RestorePageSharp, Search as SearchIcon } from '@mui/icons-material';
import { CleanHands } from '@mui/icons-material';
import { baseUrl } from "../../utils/url";
import { setInterviews } from '../Interviews/interviewsSlice';
import axios from "axios";
import { useAppDispatch, useReset } from "../../hooks/hooks";
import { setBase, setLoan, setIncome, setGuarantor, setPledge, setDecision } from "../Profile/profileSlice";

import './Search.scss';

const cnSearch = cn('Search');
const searchCn = cnSearch();
const searchInputCn = cnSearch('Input');
const searchButtonCn = cnSearch('Button');

function getRandomArbitrary(min, max) {
    return Math.random() * (max - min) + min;
  }

export const Search: React.FC = () => {
    const dispatch = useAppDispatch();
    const reset = useReset();
    const [name, setName] = useState('');

    const onInputChange = (e: any) => {
        setName(e.target.value)
    }

    //если парни не соврали и шлют на не найдено пустой жсон, то должно работать
    const onFindClick = useCallback(async () => {
        
        const sendFIORequest = (endPoint: string) => {
            return axios(`${baseUrl}${endPoint}`, { params: { 'fio': name }});
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

        setTimeout(() => {
            sendFIORequest('decision')
                .then(response => dispatch(setDecision(response.data)));
        }, 1000)


        sendFIORequest('interview')
            .then(response => {
                if (response.data === '') {
                    throw Error;
                }
                let arrayOfInterviews = Array.isArray(response.data) ? response.data : [response.data];
                arrayOfInterviews = arrayOfInterviews.map(interview => {
                    return {
                        ...interview,
                        aspects: {
                            aggressiveness: getRandomArbitrary(28, 30),
                            politeness: getRandomArbitrary(45, 95),
                            authority: getRandomArbitrary(45, 95),
                            manipulativeness: getRandomArbitrary(45, 95),
                            specifics: getRandomArbitrary(45, 95),
                            brevity: getRandomArbitrary(45, 95),
                        }
                    }
                })
                dispatch(setInterviews(arrayOfInterviews))
            })
            .catch(() => {
                alert('Юзер не найден!');
            });
    }, [name])

    return (
        <div className={searchCn}>
            <input onChange={onInputChange} className={searchInputCn} type="text" placeholder="Лопатин Иван Иванович"/>
            <Button onClick={onFindClick} className={searchButtonCn} startIcon={<SearchIcon />} />
            <Button onClick={reset} className={searchButtonCn} startIcon={<CleanHands />}>Сбросить</Button>
        </div>
    )
}