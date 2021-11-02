import React from "react";
import { cn } from "@bem-react/classname";
import { IClassNameProps } from "@bem-react/core";
import { Container } from '../../Container';
import { Text } from '../../Text';

import './Pair.scss'

interface IPairProps extends IClassNameProps {
    name: string,
    value: string,
}

const cnPair = cn('Pair');
const pairCn = cnPair();
const pairNameCn = cnPair('Name'); 
const pairValueCn = cnPair('Value'); 

export const Pair: React.FC<IPairProps> = (props) => {
    const { name, value } = props;

    console.log(`pair: ${name} ${value}`);

    return (
        <Container className={pairCn}>
            <Text s className={pairNameCn}>{name}</Text>
            <Text m className={pairValueCn}>{value === 'undefined' ? 0 : value}</Text>
        </Container>
    )
}