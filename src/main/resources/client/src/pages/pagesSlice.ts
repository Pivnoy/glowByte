import { createSlice } from "@reduxjs/toolkit";
import type { Page } from './types';

interface PagesState {
    page: Page,

}

const initialState: PagesState = {
    page: 'main'
}

export const pagesSlice = createSlice({
    name: 'modal',
    initialState,

    reducers: {
        setPage: (state, payload) => {
            state.page = payload.payload;
        }
    }
});

export const { setPage } = pagesSlice.actions;
export default pagesSlice.reducer;