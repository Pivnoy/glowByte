import React from "react";
import { cn } from "@bem-react/classname";
import { IClassNameProps } from "@bem-react/core";
import { Button } from '@mui/material';
import { Search as SearchIcon } from '@mui/icons-material';

import './Search.scss';

const cnSearch = cn('Search');
const searchCn = cnSearch();
const searchInputCn = cnSearch('Input');
const searchButtonCn = cnSearch('Button');

export const Search: React.FC = () => {
    return (
        <div className={searchCn}>
            <input className={searchInputCn} type="text" placeholder="фио"/>
            <Button className={searchButtonCn} startIcon={<SearchIcon />} />
        </div>
    )
}