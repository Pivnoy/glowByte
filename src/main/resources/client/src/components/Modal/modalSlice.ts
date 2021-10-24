import { createSlice } from "@reduxjs/toolkit";

interface ModalState {
    open: boolean,

}

const initialState: ModalState = {
    open: false
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
        }
    }
});

export const { show, close } = modalSlice.actions;
export default modalSlice.reducer;