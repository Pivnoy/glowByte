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
    decision: 'APPROVED' | 'NOTHING' | 'DENIED' | null
}

// const initialState: ProfileState = {
//     base: null,
//     loan: null,
//     income: null,
//     guarantor: null,
//     pledge: null,
//     statistics: null,
// }

const initialState: ProfileState = {
    base: {
        custFio: 'Тоха Яйцев',
        custBirth: '08.05.2002',
        custId: '228-1488',
        custInn: 13371337
    },
    loan: {
        appId: 228,
        appDate: '24.05.2013',
        credAmount:  1000000000,
        credTerm: 552,
        credObject: 'hz',
        custFio: 'poshel nahuy'
    },
    income: {
        custFio: 'nahuy',
        creditCounts: 2,
        creditSum: 14243123,
        custMonthIncome: 4441414,
        custFamilyMonthIncome: 123423512
    },
    guarantor: null,
    pledge: null,
    statistics: null,
    decision: 'NOTHING'
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

        setDecision: (state, action) => {
            state.decision = action.payload;
        }
    }
});

export const { 
    setBase,
    setLoan,
    setIncome,
    setGuarantor,
    setPledge,
    setStatistics,
    setDecision,

 } = profileSlice.actions;

export default profileSlice.reducer;
