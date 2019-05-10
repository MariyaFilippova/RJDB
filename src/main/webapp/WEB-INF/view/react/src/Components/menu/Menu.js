import React from 'react';
import s from './Menu.module.css';
import {NavLink} from "react-router-dom";

const Menu =  () => {
    return (
        <div className = {s.menu}>

            <NavLink to ="/resumes" >Resumes </NavLink>


            <NavLink to ="/vacancies" > Vacancies  </NavLink>


            <a href= '/perform_logout' > Log out </a>
        </div>);


};
export default  Menu;