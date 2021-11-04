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
import { useAppDispatch, useAppSelector, useModalClose, useModalShow, useReset } from "../../hooks/hooks";
import { baseKeys, loanKeys, incomeKeys, DECISIONS } from "./types";
import ThumbUpIcon from '@mui/icons-material/ThumbUp';
import CancelPresentationIcon from '@mui/icons-material/CancelPresentation';
import { setChidren } from "../Modal/modalSlice";

import './Profile.scss'

const cnProfile = cn('Profile');
const profileDataCn = cnProfile('Data');
const profileCardcn = cnProfile('Card');
const profileDecisionCn = cnProfile('Decision');
const profileDecisionButtonsCn = cnProfile('Decision-Buttons');
const profileCn = cnProfile();

export const Profile: React.FC = () => {
    const { 
        base,
        loan,
        income,
        guarantor,
        pledge,
        decision
    } = useAppSelector(state => state.profile);

    const dispatch = useAppDispatch();
    const reset = useReset();

    const closeModal = useModalClose();
    const onModalShow = useModalShow();

    const renderPerson = useCallback(() => {
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
        const jopa: incomeKeys[] = ['custMonthIncome', 'custFamilyMonthIncome', 'creditsCounts', 'creditSum'];
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
        const onApproveClick = () => {
            dispatch(setChidren(
                <>
                    <ThumbUpIcon color="primary" />
                    <Text xl b> Кредит успешно выдан!</Text>
                </>
            ));
            onModalShow();
            setTimeout(() => {
                reset();
                closeModal();
            }, 2500)
        }

        const onDeniyClick = () => {
            dispatch(setChidren(
                <>
                    <CancelPresentationIcon color="primary"/>
                    <Text xl b>Клиенту отказано!</Text>
                </>
            ));
            onModalShow()
            setTimeout(() => {
                reset();
                closeModal();
            }, 2500)
        }

        switch(decision) {
            case "APPROVED":
                return (
                    <Button onClick={onApproveClick} startIcon={<TaskAlt />} variant="contained" color="success">Выдать кредит</Button>
                )
                break;
            case "NOTHING":
                return (
                    <Container className={profileDecisionButtonsCn} flexDirection="row">
                        <Button
                            onClick={onApproveClick}
                            startIcon={<TaskAlt />}
                            variant="contained"
                            color="success">
                                Выдать кредит
                        </Button>
                        <Button
                            onClick={onDeniyClick}
                            startIcon={<Error />}
                            variant="contained"
                            color="error">
                                Отказать
                        </Button>
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