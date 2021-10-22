import React from "react";
import { Interviews } from "./components/Interviews/Interviews";

import './style.scss';

const App: React.FC = () => {
return (
    <div className="wrapper">
        <h1>To the moon!🚀</h1>
        <Interviews />
    </div>
  );
};
export default App;