import React from 'react';
import './App.css';
import Menu from "./Components/menu/Menu";
import Header from "./Components/header/Header";
import {Route} from "react-router";
import VacancyPageContainer from "./Components/vacancies/VacancyPageContainer";
import ResumePageContainer from "./Components/resumes/ResumePageContainer";


import GoodJob from "./Components/GoodJob";

const App =  (props) => {
    return (

            <div className='app-wrapper'>

                <Menu />
                <Header />
               <div className='app-wrapper-content'>

                   <Route path = "/resumes" render = { () => <ResumePageContainer store = {props.store}/> }
                   />
                   <Route path= "/vacancies" render = { () => <VacancyPageContainer store = {props.store}/>}
                   />
                   <Route path= "/goodJobBro" render = { () => <GoodJob store = {props.store}/>}/>

               </div>
            </div>

    );
};

export default App;

