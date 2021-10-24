import React from "react";
import { cn } from "@bem-react/classname";
import { IClassNameProps } from "@bem-react/core";

import './Button.scss';

interface IButtonProps extends IClassNameProps {
    type: 'primary' | 'default',
    text: string,
    onClick: () => void,
}

const cnButton = cn('Button');

export const Button: React.FC<IButtonProps> = (props) => {
    const { text, className, onClick } = props;

    return (
        <button
            onClick={onClick}
            className={cnButton(null, [className])}
        >
            {text}
        </button>
    )
}