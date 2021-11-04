import React from "react";
import { cn } from "@bem-react/classname";
import { IClassNameProps } from "@bem-react/core";
import { Container } from '../Container';

import './Card.scss';

interface ICardProps extends IClassNameProps {

}

const cnCard = cn('Card');

export const Card: React.FC<ICardProps> = (props) => {
    const { children, className } = props;
    return (
        <Container className={cnCard(null, [className])}>
            {children}
        </Container>
    )
}