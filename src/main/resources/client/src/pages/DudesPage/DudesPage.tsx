import React from "react";
import { Text } from "../../components/Text";
import { cn } from "@bem-react/classname";
import { Container } from '../../components/Container';

import './DudesPage.scss';

const cnPicture = cn('Picture');
const pictureCn = cnPicture();

export const DudesPage: React.FC = () => {
    return (
        <Container className={pictureCn}>

        </Container>
    )
}