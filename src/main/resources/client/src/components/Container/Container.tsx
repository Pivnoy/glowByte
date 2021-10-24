import React from "react";
import { cn } from '@bem-react/classname';
import { IClassNameProps } from "@bem-react/core";

import './Container.scss';

interface IContainer extends IClassNameProps {
    flexDirection?: 'column' | 'row',
    onClick?: () => void,
}

const cnContainer = cn('Container');

export const Container: React.FC<IContainer> = (props) => {
    const { flexDirection = 'column', children, onClick, className } = props;
    return (
        <div 
            className={cnContainer({ flexDirection }, [className])}
            onClick={onClick}
        >
            {children}
        </div>
    )
}