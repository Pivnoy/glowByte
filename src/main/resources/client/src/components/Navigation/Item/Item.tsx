import React, { useCallback } from "react";
import { cn } from '@bem-react/classname'
import { Button } from '@mui/material';
import { Container } from "../../Container";
import { OverridableComponent } from "@mui/material/OverridableComponent";
import { Page } from "../../../pages/types";

import './Item.scss';

interface ItemProps {
    pageName: Page
    text: string,
    Icon: OverridableComponent<any>
    onClick: (pageName: Page) => void
}

const cnItem = cn('Item');
const itemCn = cnItem();

export const Item: React.FC<ItemProps> = (props) => {
    const { text, Icon, onClick, pageName } = props; 

    const onItemClick = useCallback(() => {
        onClick(pageName);
    }, [pageName])

    const buttonStyle = {
        width: '100%',
        height: '100%',
        justifyContent: 'start',
    }

    return (
        <Container className={cnItem(null, [itemCn])}>
            <Button style={buttonStyle} onClick={onItemClick} startIcon={<Icon/>}>{text}</Button>
        </Container>
    )
}