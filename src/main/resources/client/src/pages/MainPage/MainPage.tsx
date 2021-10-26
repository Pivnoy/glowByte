import React, { useCallback, useEffect, useState } from "react";
import { cn } from '@bem-react/classname';
import { Interviews } from "../../components/Interviews";
import { Header } from "../../components/Header";
import { Search } from '../../components/Search';
import { Profile } from "../../components/Profile";
import { Container } from "../../components/Container";
import { Text } from '../../components/Text'; 
import { useAppSelector } from "../../hooks/hooks";

import './MainPage.scss';

const cnMainPage = cn('MainPage');
const MainPageCn = cnMainPage();
const MainPageHeaderCn = cnMainPage('Header');
const MainPageUserDataCn = cnMainPage('UserData');

export const MainPage:React.FC = () => {
    const [date, setDate] = useState('');
    const { interviews } = useAppSelector(state => state.interviews);
    const { 
        base,
        loan,
        income,
        guarantor,
        pledge 
    } = useAppSelector(state => state.profile);

    // useEffect(() => {
    //     setInterval(() => {
    //         const date = new Date();
    //         setDate(date.toLocaleString())
    //     }, 1000)
    // }, [])

    const withProfile = useCallback(() => {
        return base || loan || income || guarantor || pledge;
    }, [base, loan, income, guarantor, pledge]);

    return (
        <Container className={MainPageCn}>
            <Header>
                <Search />
                <Text m>{date}</Text>
            </Header>
            <Container flexDirection="row" className={MainPageUserDataCn}>
                {withProfile() && <Profile />}
                {interviews.length > 0 && <Interviews />}
            </Container>
        </Container>
    )
}