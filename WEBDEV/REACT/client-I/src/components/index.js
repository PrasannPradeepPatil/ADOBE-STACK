//IMPORT MODELS
import React from 'react';
import {BrowserRouter as Router,Routes,Route} from "react-router-dom";

//IMPORT COMPONENTS
import Posts from './Posts/Posts';
import Form from './Form/Form';


//
/*
const Components = () => {
    return (
        <Router>
            <Routes>
                <Route path="/Posts" element={<Posts />} />  --For baseURL/Posts go to component Posts
                <Route path="/Forms" element={<Form />} />   --For baseURL/Forms go to component Form
            </Routes>
        </Router>
    );
};

*/
export const  Components = () => {
    return (
        <Router>
            <Routes>
                <Route path="/Posts" element={<Posts />} /> 
                <Route path="/Forms" element={<Form />} /> 
            </Routes>
        </Router>
    );
};

