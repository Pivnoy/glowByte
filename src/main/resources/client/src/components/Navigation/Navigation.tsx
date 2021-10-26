import React, { useCallback } from "react";
import { cn } from "@bem-react/classname";
import { Container } from "../Container";
import { Item } from './Item';
import { Home } from '@mui/icons-material';
import { Info } from '@mui/icons-material';
import { AlarmAdd } from '@mui/icons-material';
import { BluetoothDisabled } from '@mui/icons-material/';
import { Bluetooth } from '@mui/icons-material/';
import { useAppDispatch } from "../../hooks/hooks";
import { Page } from "../../pages/types";
import { setPage } from "../../pages/pagesSlice";

import './Navigation.scss';

const cnNavigation = cn('Navigation');
const navigationCn = cnNavigation();

export const Navigation: React.FC = () => {
    const dispatch = useAppDispatch();

    const onItemClick = useCallback((pageName: Page) => {
        dispatch(setPage(pageName));
    }, [dispatch]);

    return (
        <Container className={navigationCn}>
            <Item onClick={onItemClick} pageName={'dudes'} Icon={AlarmAdd} text="Dudes" />
            <Item onClick={onItemClick} pageName={'main'} Icon={Home} text="Главная" />
            <Item onClick={onItemClick} pageName={'info'} Icon={Info} text="О проекте" />
            <Item onClick={onItemClick} pageName={'dudes'} Icon={Bluetooth} text="что за кнопка?" />
            <Item onClick={onItemClick} pageName={'dudes'} Icon={BluetoothDisabled} text="хуй знает" />
        </Container>
    )
}