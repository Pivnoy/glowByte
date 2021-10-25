import React from "react";
import { cn } from "@bem-react/classname";
import { IClassNameProps } from "@bem-react/core";
import { Container } from "../Container";
import { Item } from './Item';
import { Home } from '@mui/icons-material';
import { Info } from '@mui/icons-material';
import { Help } from '@mui/icons-material';
import { AlarmAdd } from '@mui/icons-material';
import { BluetoothDisabled } from '@mui/icons-material/';
import { Bluetooth } from '@mui/icons-material/';


import './Navigation.scss';

const cnNavigation = cn('Navigation');
const navigationCn = cnNavigation();

export const Navigation: React.FC = () => {
    return (
        <Container className={navigationCn}>
            <Item Icon={AlarmAdd} text="Dudes" />
            <Item Icon={Home} text="Главная" />
            <Item Icon={Info} text="Справка" />
            <Item Icon={Help} text="Помощь" />
            <Item Icon={Bluetooth} text="что за кнопка?" />
            <Item Icon={BluetoothDisabled} text="хуй знает" />
        </Container>
    )
}