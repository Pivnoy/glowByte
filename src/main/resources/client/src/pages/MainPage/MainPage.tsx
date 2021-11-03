import React, { useCallback, useEffect, useState } from "react";
import { cn } from '@bem-react/classname';
import { Interviews } from "../../components/Interviews";
import { Header } from "../../components/Header";
import { Search } from '../../components/Search';
import { Profile } from "../../components/Profile";
import { Container } from "../../components/Container";
import { Text } from '../../components/Text'; 
import { useAppDispatch, useAppSelector } from "../../hooks/hooks";
import axios from 'axios';
import { Button } from "@mui/material";
import { setStatistics } from "../../components/Profile/profileSlice";
import { Card } from "../../components/Card";
import { baseUrl } from "../../utils/url";

import './MainPage.scss';

const cnMainPage = cn('MainPage');
const MainPageCn = cnMainPage();
const MainPageHeaderCn = cnMainPage('Header');
const MainPageUserDataCn = cnMainPage('UserData');
const MainPageStatisticsCn = cnMainPage('Statistics');
const MainPageStatisticsRowCn = cnMainPage('Statistics-Row');

export const MainPage:React.FC = () => {
    const [date, setDate] = useState('');
    const dispatch = useAppDispatch();
    const { interviews } = useAppSelector(state => state.interviews);
    const { statistics } = useAppSelector(state => state.profile);
    const { 
        base,
        loan,
        income,
        guarantor,
        pledge 
    } = useAppSelector(state => state.profile);

    useEffect(() => {
        axios(`${baseUrl}statistics`)
            .then(response => dispatch(setStatistics(response.data)));
    }, [])

    const withProfile = useCallback(() => {
        return base || loan || income || guarantor || pledge;
    }, [base, loan, income, guarantor, pledge]);

    const withInterviews = useCallback(() => {
        return interviews.length > 0
    }, [interviews]);

    const renderMainPage = useCallback(() => {
        if (withProfile() || withInterviews()) {
            return (
                <Container flexDirection="row" className={MainPageUserDataCn}>
                    {withProfile() && <Profile />}
                    {withInterviews() && <Interviews />}
                </Container>
            )
        } else {
            if (statistics) {
                return (
                    <Container className={MainPageStatisticsCn}>
                        <Container className={MainPageStatisticsRowCn} flexDirection="row">
                            <Card>
                                <Text xl>Число клиентов</Text>
                                <Text xl>{statistics?.clientNumber}</Text>
                            </Card>
                            <Card>
                                <Text xl>Общая сумма задолженности клиентов</Text>
                                <Text xl>{statistics?.creditSum}</Text>
                            </Card>
                        </Container>
                        <Container className={MainPageStatisticsRowCn} flexDirection="row">
                            <Card>
                                <Text xl>Процент наличия поручителей</Text>
                                <Text xl>
                                    {statistics?.guarantorPercent && Math.round(statistics?.guarantorPercent * 100) / 100}
                                </Text>
                            </Card>
                            <Card>
                                <Text xl>Средний доход клиентов</Text>
                                <Text xl>
                                    {statistics?.middleIncome && Math.round(statistics?.middleIncome * 100) / 100}
                                </Text>
                                
                            </Card>
                        </Container>
                    </Container>
                )
            }
            return (
                // <>
                //     <Text xl>Все сломалось!</Text>
                //     <Text m>Боже, почини бэк...</Text>
                // </>
                null
            );
        }
    }, [statistics, withProfile, withInterviews])

    return (
        <Container className={MainPageCn}>
            <Header>
                <Search />
                <Text m>{date}</Text>
            </Header>
            {renderMainPage()}
        </Container>
    )
}