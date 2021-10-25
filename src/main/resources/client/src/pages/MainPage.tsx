import React from "react";
import { cn } from "@bem-react/classname";
import { IClassNameProps } from "@bem-react/core";
import { Interviews } from "../components/Interviews";
import { Container } from '../components/Container';
import { Header } from "../components/Header";
import { Search } from '../components/Search';
import { Navigation } from '../components/Navigation';

export const MainPage:React.FC = () => {
    return (
        <Container flexDirection='row'>
            <Navigation />

            <div>
                <Header>
                    <Search />
                </Header>
                <Interviews />
            </div>
        </Container>
    )
}