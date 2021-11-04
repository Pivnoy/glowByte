import React from "react";
import { Interviews } from "./components/Interviews/Interviews";
import { Container } from "./components/Container";
import { Navigation } from "./components/Navigation";
import { Modal } from "./components/Modal";
import { useAppSelector, useModalClose } from "./hooks/hooks";
import { AllPages } from "./pages/pages";

import './index.scss';

const App: React.FC = () => {
    const { page } = useAppSelector(state => state.pages);
    const { open, children } = useAppSelector(state => state.modal);
    const onModalClose = useModalClose();

    const PageToRender = AllPages[page];

    return (
        <Container flexDirection='row'>
            <Modal
                open={open}
                onClose={onModalClose}
            >
                {children}
            </Modal >
            
            <Navigation />
            <PageToRender />
        </Container>
    )};

export default App;