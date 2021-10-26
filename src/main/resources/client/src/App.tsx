import React from "react";
import { Interviews } from "./components/Interviews/Interviews";
import { Modal } from '@mui/material';
import { useAppDispatch, useAppSelector } from "./hooks/hooks";

import './style.scss';

const App: React.FC = () => {
    
return (
    <>  
        <div className="wrapper">
            <h1>To the moon!🚀</h1>
        </div>
        <Interviews />
    </>
  );
};
export default App;