import React from "react";
import { cn } from "@bem-react/classname";
import { IClassNameProps } from "@bem-react/core";
import { Modal as ModalMUI} from '@mui/material';
import { Container } from "../Container";

import './Modal.scss';

interface IModalProps extends IClassNameProps {
    open: boolean,
    onClose: () => void,

}

const cnModal = cn('Modal')
const modalCn = cnModal();

export const Modal: React.FC<IModalProps> = (props) => {
    const { open, onClose, children } = props;
    return (
        <ModalMUI open={open} onClose={onClose}>
            <Container className={modalCn}>
                {children}
            </Container>
        </ModalMUI>
    )
}