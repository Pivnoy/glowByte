import React, { useCallback, useEffect, useState } from "react";
import { cn } from '@bem-react/classname';
import { Modal } from '../Modal';
import { Container } from '../Container';
import { Interview } from "../Interview";
import { Header } from "../Header";
import { Button } from "../Button/";
import { Text } from '../Text';
import { useAppDispatch, useAppSelector } from "../../hooks/hooks";
import { show, close, setChidren } from '../Modal/modalSlice';

import './Interviews.scss';

interface IInterviewsProps {

}

const cnInterviews = cn('Interviews');
const cnInterviewsHeader = cnInterviews('Header');
const interviewsCn = cnInterviews();

export const Interviews: React.FC<IInterviewsProps> = () => {
    const [ chosenInterview, setChosenInterview ] = useState(0);
    const { interviews } = useAppSelector(state => state.interviews);
    const dispatch = useAppDispatch();

    const onInterviewClick = useCallback((id: number) => {
        setChosenInterview(id);
        dispatch(show());
        dispatch(setChidren(
        <Interview 
            id={chosenInterview}
            interview={interviews[chosenInterview]}
            onClick={onInterviewClick}
        />))
    }, [dispatch, chosenInterview, interviews])

    const onShowAllClick = useCallback(() => {

    }, [])

    const renderHeader = useCallback(() => {
        return (
            <Header className={cnInterviewsHeader}>
                <Text xxl>Интервью</Text>
                {/* {interviews.length > 3 && (
                    <Button 
                        type="primary"
                        text="показать все"
                        onClick={onShowAllClick}
                    />)} */}
            </Header>
        )
    }, [interviews, onShowAllClick])

    return (
        <Container className={interviewsCn}>
            {renderHeader()}
            {interviews.map((interview, i) => (
                <Interview 
                    id={i}
                    preview
                    interview={interview}
                    onClick={onInterviewClick}
                />
            ))}
        </Container>
    )
}