import { MainPage } from "./MainPage/MainPage";
import { DudesPage } from "./DudesPage/DudesPage";
import { Page } from "./types";
import React from "react";

export const AllPages: Record<Page, React.FC> = {
    'main': MainPage,
    'dudes': DudesPage,
};