import { createSlice } from "@reduxjs/toolkit";
import { ProfileBase, ProfileIncome, ProfileGuarantor, ProfilePledge } from './types';
import { ProfileLoan } from './types';

interface ProfileState {
    base: ProfileBase | null,
    loan: ProfileLoan | null,
    income: ProfileIncome | null,
    guarantor: ProfileGuarantor | null,
    pledge: ProfilePledge | null,
}

const initialState: ProfileState = {
    base: null,
    loan: null,
    income: null,
    guarantor: null,
    pledge: null,
}

export const profileSlice = createSlice({
    name: 'profile',
    initialState,

    reducers: {
        setBase: (state, action) => {
            state.base = action.payload
        },

        setLoan: (state, action) => {
            state.loan = action.payload
        },

        setIncome: (state, action) => {
            state.income = action.payload
        },

        setGuarantor: (state, action) => {
            state.guarantor = action.payload
        },

        setPledge: (state, action) => {
            state.pledge = action.payload
        },
    }
});

export const { 
    setBase,
    setLoan,
    setIncome,
    setGuarantor,
    setPledge,
 } = profileSlice.actions;
export default profileSlice.reducer;
