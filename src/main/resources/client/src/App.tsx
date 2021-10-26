import React, { useEffect, useMemo } from "react";
import { Interviews } from "./components/Interviews/Interviews";
import { Container } from "./components/Container";
import { Navigation } from "./components/Navigation";
import { useAppSelector } from "./hooks/hooks";
import { AllPages } from "./pages/pages";



import './index.scss';

const App: React.FC = () => {
    const { page } = useAppSelector(state => state.pages);
    
    const PageToRender = AllPages[page];

    return (
        <Container flexDirection='row'>
            <Navigation />
            <PageToRender />
        </Container>
    )};

export default App;