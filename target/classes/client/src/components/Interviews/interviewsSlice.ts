import { createSlice } from "@reduxjs/toolkit";
import { Interview } from "../Interview/types";

interface InterviewsState {
    interviews: Interview[]
    chosenInterview?: number
}

const initialState: InterviewsState = {
    interviews: [],
}

export const interviewsSlice = createSlice({
    name: 'interviews',
    initialState,

    reducers: {
        setInterviews: (state, action) => {
            state.interviews = action.payload
        },

        setChosen: (state, action) => {
            state.chosenInterview = action.payload
        }
    }
});

export const { setInterviews, setChosen } = interviewsSlice.actions;
export default interviewsSlice.reducer;
