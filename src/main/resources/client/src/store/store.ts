import { configureStore } from "@reduxjs/toolkit";
import modalReducer from '../components/Modal/modalSlice';
import interviewsReducer from '../components/Interviews/interviewsSlice';
import pagesReducer from '../pages/pagesSlice';
import profileReducer from '../components/Profile/profileSlice';

export const store = configureStore({
    reducer: {
        modal: modalReducer,
        interviews: interviewsReducer,
        pages: pagesReducer,
        profile: profileReducer
    }
})

// Infer the `RootState` and `AppDispatch` types from the store itself
export type RootState = ReturnType<typeof store.getState>
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof store.dispatch