import { createSlice } from "@reduxjs/toolkit";
import React from 'react';

interface ModalState {
    open: boolean,
    children: React.ReactNode,

}

const initialState: ModalState = {
    open: false,
    children: null
}

export const modalSlice = createSlice({
    name: 'modal',
    initialState,

    reducers: {
        show: (state) => {
            state.open = true;
        },
        
        close: (state) => {
            state.open = false;
        },

        setChidren: (state, action) => {
            state.children = action.payload
        }
    }
});

export const { show, close, setChidren } = modalSlice.actions;
export default modalSlice.reducer;