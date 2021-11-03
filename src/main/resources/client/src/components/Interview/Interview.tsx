import React, { useCallback } from "react";
import { cn } from "@bem-react/classname";
import { Container } from "../Container";
import { Header } from '../Header';
import { Text } from '../Text';
import { Aspects, Interview as InterviewType } from './types';
import { ProgressBar } from "react-bootstrap";
import { Chat } from "./Chat/Chat";
import { aspectsWithi18nColor } from "./types";

import './Interview.scss';

interface IInterviewProps {
    id: number
    preview?: boolean,
    interview: InterviewType,
    onClick?: (id: number) => void,
}

const cnInterview = cn('Interview');
const interviewCn = cnInterview();
const interviewProgressesCn = cnInterview('Progresses');
const interviewProgressBarCn = cnInterview('ProgressBar');

function isAspects() {

}

export const Interview: React.FC<IInterviewProps> = (props) => {
    const { id, preview = false, interview, onClick } = props;

    const renderInterviewHeader = useCallback(() => {
        return (
            <>
                <Header>
                    <Text>id: {interview.id}</Text>
                    <Text>{interview.interviewDatetime}</Text>
                </Header>
                
            </>
        )
    }, [interview])

    const renderInterviewPreview = useCallback(() => {
        return (
            <>
                {renderInterviewHeader()}
                <Chat preview dialog={interview.answersOnQuestions}/>
            </>
        )
    }, [interview])

    const renderFullInterview = useCallback(() => {
        const keys = Object.keys(interview.aspects) as Array<keyof Aspects>;
        return (
            <>
                {renderInterviewHeader()}
                <Container className={interviewProgressesCn}>
                    {keys.map((key) => {
                        return (
                            <ProgressBar 
                                animated
                                className={interviewProgressBarCn}
                                variant={aspectsWithi18nColor[key].color}
                                now={interview.aspects[key]}
                                label={`${aspectsWithi18nColor[key].name}: ${interview.aspects[key]}`} 
                            />
                        )
                    })}
                </Container>
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

    console.log("in interview preview render");

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