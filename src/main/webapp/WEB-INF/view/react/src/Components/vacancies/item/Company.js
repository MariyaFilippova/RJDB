import React from 'react';


const Company = (props) =>
{
    return (

        <div>
            {props.id}
            {props.name}
            {props.email}
        </div>

    );
};

export default Company;