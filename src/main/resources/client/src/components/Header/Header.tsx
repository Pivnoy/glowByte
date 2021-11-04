import React from 'react';
import { IClassNameProps } from '@bem-react/core';
import { cn } from '@bem-react/classname';

import './Header.scss';

interface IHeaderProps extends IClassNameProps {

}

const cnHeader = cn('Header');

export const Header: React.FC<IHeaderProps> = (props) => {
    const { children, className } = props;

    return (
        <div className={cnHeader(null, [className])}>
            {children}
        </div>
    )
}