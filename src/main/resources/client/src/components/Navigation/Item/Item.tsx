import React from "react";
import { cn } from '@bem-react/classname'
import { Button } from '@mui/material';
import { Container } from "../../Container";
import { OverridableComponent } from "@mui/material/OverridableComponent";

import './Item.scss';

interface ItemProps {
    text: string,
    Icon: OverridableComponent<any>
    onCLick?: () => {}
}

const cnItem = cn('Item');
const itemCn = cnItem();

export const Item: React.FC<ItemProps> = (props) => {
    const { text, Icon } = props; 
    return (
        <Container className={cnItem(null, [itemCn])}>
            <Button startIcon={<Icon/>}>{text}</Button>
        </Container>
    )
}