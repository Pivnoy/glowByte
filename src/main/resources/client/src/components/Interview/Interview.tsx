import React, { useCallback } from "react";
import { cn } from "@bem-react/classname";
import { Container } from "../Container";
import { Header } from '../Header';
import { Text } from '../Text';
import { Interview as InterviewType } from './types';

import './Interview.scss';
import { Chat } from "./Chat/Chat";

interface IInterviewProps {
    id: number
    preview?: boolean,
    interview: InterviewType,
    onClick?: (id: number) => void,
}

const cnInterview = cn('Interview');
const interviewCn = cnInterview();

export const Interview: React.FC<IInterviewProps> = (props) => {
    const { id, preview = false, interview, onClick } = props;

    const renderInterviewPreview = useCallback(() => {
        return (
            <>
                <Header>
                    <Text>id: {interview.id}</Text>
                    <Text>{interview.interviewDatetime}</Text>
                </Header>
                <Chat preview dialog={interview.answersOnQuestions}/>
            </>
        )
    }, [interview])

    const renderFullInterview = useCallback(() => {
        return (
            <>
                <Header>
                    <Text>id: {interview.id}</Text>
                    <Text>{interview.interviewDatetime}</Text>
                </Header>
                <Chat dialog={interview.answersOnQuestions}/>
            </>
        )
    }, [interview])

    const renderInterview = useCallback(() => {
        return preview ? renderInterviewPreview() : renderFullInterview();
    }, [preview, renderInterviewPreview, renderFullInterview]);

    const onInterviewClick = useCallback(() => {
        onClick && onClick(id);
    }, [])

    return (
        <Container 
            flexDirection="column"
            className={cnInterview({ preview })}
            onClick={onInterviewClick}
        >
            {renderInterview()}
        </Container>
    );
}