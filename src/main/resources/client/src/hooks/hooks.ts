import { TypedUseSelectorHook, useDispatch, useSelector } from 'react-redux'
import type { RootState, AppDispatch } from '../store/store';
import { show, close } from '../components/Modal/modalSlice';
import { setInterviews } from '../components/Interviews/interviewsSlice';
import { setBase, setLoan, setIncome, setGuarantor } from '../components/Profile/profileSlice';

// Use throughout your app instead of plain `useDispatch` and `useSelector`
export const useAppDispatch = () => useDispatch<AppDispatch>()
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector

export const useModalShow = () => {
    const dispatch = useAppDispatch();
    return () => dispatch(show());
}

export const useModalClose = () => {
    const dispatch = useAppDispatch();
    return () => dispatch(close());
}

export const useReset = () => {
    const dispatch = useAppDispatch();
    return () => {
        dispatch(setInterviews([]));
        dispatch(setBase(null));
        dispatch(setLoan(null));
        dispatch(setIncome(null));
        dispatch(setGuarantor(null));
    }
}