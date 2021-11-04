import { createSlice } from "@reduxjs/toolkit";
import { Interview } from "../Interview/types";
import { interviewPlaceholder } from '../../utils/interviewPlaceholder';

interface InterviewsState {
    interviews: Interview[],
    chosenInterview?: number,
}

const initialState: InterviewsState = {
    interviews: [],
}

// const initialState: InterviewsState = {
//     interviews: [
//         {
//             id: 1,
//             interviewDatetime: 'сёдня нах',
//             appId: 228,
//             answersOnQuestions: {
//                 'I1': 'Здравствуйте, как насчет пойти нахуй?',
//                 'A1': 'Здравствуйте, сами нахуй идите!',
//                 'I2': 'Мы не дадим вам кредит, грубиян',
//                 'A2': 'Ваще до пизды, микрозайм возьму!',
//                 'I3': 'Здравствуйте, как насчет пойти нахуй?',
//                 'A3': 'Здравствуйте, сами нахуй идите!',
//                 'I4': 'Мы не дадим вам кредит, грубиян',
//                 'A4': 'Ваще до пизды, микрозайм возьму!',
//                 'I5': 'Здравствуйте, как насчет пойти нахуй?',
//                 'A5': 'Здравствуйте, сами нахуй идите!',
//                 'I6': 'Мы не дадим вам кредит, грубиян',
//                 'A6': 'Ваще до пизды, микрозайм возьму!',
//                 'I7': 'Здравствуйте, как насчет пойти нахуй?',
//                 'A7': 'Здравствуйте, сами нахуй идите!',
//                 'I8': 'Мы не дадим вам кредит, грубиян',
//                 'A8': 'Ваще до пизды, микрозайм возьму!',
//                 'I9': 'Здравствуйте, как насчет пойти нахуй?',
//                 'A9': 'Здравствуйте, сами нахуй идите!',
//                 'I10': 'Мы не дадим вам кредит, грубиян',
//                 'A10': 'Ваще до пизды, микрозайм возьму!',
//             },
//             aspects: {
//                 aggressiveness: 30,
//                 politeness: 90,
//                 authority: 60,
//                 manipulativeness: 37,
//                 specifics: 67,
//                 brevity: 43
//             }
//         },
//     ],
// };

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
