import { createSlice } from "@reduxjs/toolkit";
import { ProfileBase, ProfileIncome, ProfileGuarantor, ProfilePledge, CommonStatistics } from './types';
import { ProfileLoan } from './types';

interface ProfileState {
    base: ProfileBase | null,
    loan: ProfileLoan | null,
    income: ProfileIncome | null,
    guarantor: ProfileGuarantor | null,
    pledge: ProfilePledge | null,
    statistics: CommonStatistics | null,
}

const initialState: ProfileState = {
    base: null,
    loan: null,
    income: null,
    guarantor: null,
    pledge: null,
    statistics: null,
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

        setStatistics: (state, action) => {
            state.statistics = action.payload
        },
    }
});

export const { 
    setBase,
    setLoan,
    setIncome,
    setGuarantor,
    setPledge,
    setStatistics,
    
 } = profileSlice.actions;
export default profileSlice.reducer;
