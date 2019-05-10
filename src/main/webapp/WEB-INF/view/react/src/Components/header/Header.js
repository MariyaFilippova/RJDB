import React from 'react';
import s from './Header.module.css';

const Header =  () => {
    return (
        <div className= {s.header}>

                <h className = {s.text}>
                Russian Job DataBase
                    </h>
                    <img className={s.img} src = "https://avatanplus.com/files/resources/mid/591036d6c57ee15be7563719.png" height={120} width={120}/>
        </div>);


};
export default  Header;