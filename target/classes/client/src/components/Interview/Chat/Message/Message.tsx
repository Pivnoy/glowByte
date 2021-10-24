import React from "react";
import { cn } from "@bem-react/classname";
import { IClassNameProps } from "@bem-react/core";
import { Text } from "../../../Text";

import './Message.scss';

interface IMessageProps extends IClassNameProps {
    position: 'left' | 'right',
}

const cnMessage = cn('Message');

export const Message: React.FC<IMessageProps> = ({ children, position }) => {

    return (
        <Text className={cnMessage({ position })}>
            {children}
        </Text>
    )
}