import React, { useCallback, useState } from "react";
import { cn } from '@bem-react/classname';
import type { guarantorKeys, pledgeKeys, ProfileBase as ProfileType } from './types';
import { Button } from '@mui/material';
import { TaskAlt } from '@mui/icons-material';
import { Error } from '@mui/icons-material';
import { Container } from "../Container";
import { Text } from '../Text';
import { Card } from "../Card";
import { Pair } from "../Card/Pair";
import { useAppSelector } from "../../hooks/hooks";
import type { ProfileBase } from '../Profile/types';
import { baseKeys, loanKeys, incomeKeys, DECISIONS } from "./types";

import './Profile.scss'

const cnProfile = cn('Profile');
const profileDataCn = cnProfile('Data');
const profileCardcn = cnProfile('Card');
const profileDecisionCn = cnProfile('Decision');
const profileDecisionButtonsCn = cnProfile('Decision-Buttons');

const profileCn = cnProfile();

interface IProfileProps {
}
// 5001

// function bullshitingBuilder<T> (keys: string[], jopa: T, profileKey: ProfileState) {

// }

export const Profile: React.FC<IProfileProps> = () => {
    const { 
        base,
        loan,
        income,
        guarantor,
        pledge,
        decision
    } = useAppSelector(state => state.profile);


    const renderPerson = useCallback(() => {
        console.log(`base ${base}`);
        const keys = ['фио', 'id', 'дата рождения', 'инн'];
        const jopa: baseKeys[] = ['custFio', 'custId', 'custBirth', 'custInn'];
        return (
                <>
                    {base && (
                    <Card className={profileCardcn}>
                        {keys.map((key, i) => (
                            <Pair 
                                name={key}
                                value={String(base[jopa[i]])}
                            />
                        ))}
                    </Card>)}
                </>
        )
    }, [base])

    const renderLoan = useCallback(() => {
        const keys: string [] = ['ID заявки', 'Дата подачи', 'Размер долга', 'Срок кредитования', 'Цель кредитования'];
        const jopa: loanKeys[] = ['appId', 'appDate', 'credAmount', 'credTerm', 'credObject'];
        
        return (
            <>
                {loan && (
                <Card className={profileCardcn}>
                    {keys.map((key, i) => (
                        <Pair
                            name={key}
                            value={String(loan[jopa[i]])} 
                        />
                    ))}
                </Card>)}
            </>
        )
    }, [loan])

    const renderIncome = useCallback(() => {
        const keys = ['Ежемесячный дохода заявителя', 'Ежемесячного дохода семьи заявителя', 'Количество кредитов', 'Сумма кредитов'];
        const jopa: incomeKeys[] = ['custMonthIncome', 'custFamilyMonthIncome', 'creditCounts', 'creditSum'];
        return (
            <>
                {income && (
                <Card className={profileCardcn}>
                    {keys.map((key, i) => (
                        <Pair 
                            name={key}
                            value={String(income[jopa[i]])}
                        />
                    ))}
                </Card>)}
            </>
    )
    }, [income])

    const renderGuarantor = useCallback(() => {
        const keys = ['ФИО поручителя', 'Телефон поручителя', 'Дата рождения поручителя'];
        const jopa: guarantorKeys[] = ['guarantorFio', 'guarantorPhone', 'guarantorBirth'];
        return (
            <>
                {guarantor && (
                <Card className={profileCardcn}>
                    {keys.map((key, i) => (
                        <Pair 
                            name={key}
                            value={String(guarantor[jopa[i]])}
                        />
                    ))}
                </Card>)}
            </>
    )
    }, [guarantor])

    const renderPledge = useCallback(() => {
        const keys = ['Размер залога', 'Тип залога'];
        const jopa: pledgeKeys[] = ['pledgeAmount', 'pledgeType'];
        return (
            <>
                {pledge && (
                <Card className={profileCardcn}>
                    {keys.map((key, i) => (
                        <Pair 
                            name={key}
                            value={String(pledge[jopa[i]])}
                        />
                    ))}
                </Card>)}
            </>
    )
    }, [pledge])

    const renderButtons = useCallback(() => {
        switch(decision) {
            case "APPROVED":
                return (
                    <Button startIcon={<TaskAlt />} variant="contained" color="success">Выдать кредит</Button>
                )
                break;
            case "NOTHING":
                return (
                    <Container className={profileDecisionButtonsCn} flexDirection="row">
                        <Button startIcon={<TaskAlt />} variant="contained" color="success">Выдать кредит</Button>
                        <Button startIcon={<Error />} variant="contained" color="error">Отказать</Button>
                    </Container>
                )
            case "DENIED":
                return (
                    <Button startIcon={<Error />} variant="contained" color="error">Отказать</Button>
                )

            default:
                return null;
        }
    }, [decision])

    const renderDecision = useCallback(() => {
        if (decision) {
            return (
                <Container className={profileDecisionCn}>
                    <Card>
                        {decision === 'NOTHING' ? <Text l>Система сомневается</Text> : null}
                        <Text l>{DECISIONS[decision]}</Text>
                        {renderButtons()}
                    </Card>
                </Container>
            )
        }
        return null;
        
    }, [decision])

    return (
        <Container flexDirection="row" className={profileCn}>
            <Container className={profileDataCn}>
                {renderPerson()}
                {renderIncome()}
                {renderLoan()}
                {renderGuarantor()}
                {renderPledge()}
            </Container>
            {renderDecision()}
        </Container>
    )
}