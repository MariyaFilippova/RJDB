
import React from 'react';
import Resume from "./item/Resume";
import s from './ResumePage.module.css';

import Area from "./item/Area";

const ResumePage = (props) => {

    if (props.mustFetch) {
        props.fetchResumes();
        props.fetchAreas();
        props.setMustFetch(false);

    }



    const onAddResume = () =>
    {
        props.addResume();
    };
    const onResumeChange = (event) =>
    {
       props.resumeChange(event);
    };
    const onNameChange = (event) =>
    {
        props.nameChange(event);
    };
    const onAreaChange = (event) =>
    {
        props.selectArea(event);
    };


    let resumes = props.resumes
        .map((resume) => <Resume key={resume.id}
                                 id={resume.id}
                                 name={resume.name}
                                 resume = {resume.resume}
                                 area_id = {resume.area_id}
                                 statusCode = {resume.status}
            />
        );


    let areas = props.areas
        .map((area) => <Area key = {area.area_id}
                                 id={area.area_id}
                                 area = {area.area}
            />
        );

        if (resumes.length === 0) {
            return (
                <div className={s.resumePageWrapper}>
                    <div className={s.resumes}>
                        <div className={s.noResume}> You don't have any resumes!</div>
                        </div>
                    <table className={s.table} border="1px" width="1px" height="2000px"> </table>
                    <div className={s.form}>
                        <div className={s.title}> Add a resume: </div>

                        <textarea className={s.area} onChange={onResumeChange}
                                                        value={props.resumeResume}
                                                         placeholder={'Enter information about your age, education and work experience:'}/>
                        <br/>
                        <textarea className={s.area}
                                                         onChange={onNameChange}
                                                         value={props.resumeName}
                                                         placeholder={'Enter name of vacancy:'}/>
                         <br/>
                        <textarea className={s.area}
                                  placeholder={'Enter information about your hobbies:'}/>
                        <br/>


                         <div >
                             <c className={s.title}> Select area: </c>
                            <select className={s.select} onChange={onAreaChange}
                                    value ={props.id}>

                                <option /> { areas.map((area) =>

                            {return <option key={area.props.id} value={area.props.id}> {area.props.area}

                                </option>
                            })
                            }
                            </select>
                         </div>

                        <b  onClick={onAddResume}> Add Resume </b>
                    </div>
                </div>
            )
        } else {
            return (
                <div className={s.resumePageWrapper}>
                    <table className={s.table} border="1px" width="1px" height="2000px"> </table>

                        <div className={s.form}>

                            <div className={s.title}> Add a resume: </div>
                              <textarea className={s.area} onChange={onResumeChange}
                                        value={props.resumeResume}
                                        placeholder={'Enter information about your education and work experience:'}/>
                            <br/>
                            <textarea className={s.area}
                                      onChange={onNameChange}
                                      value={props.resumeName}
                                      placeholder={'Enter name of vacancy:'}
                            />
                            <textarea className={s.area}
                                      placeholder={'Enter information about your hobbies:'}/>
                            <br/>

                            <div className={s.title}> Select area: <div/>
                            <select className={s.select} onChange={onAreaChange}
                                    value ={props.id}>
                                <option /> { areas.map((area) =>

                            {return <option key={area.props.id} value={area.props.id}> {area.props.area}

                            </option>
                            })
                            }
                            </select>
                            <br/>
                        <b onClick={onAddResume}> Add Resume </b>

                            </div>
                        </div>

                    <div className={s.resumes}>
                        <div className = {s.d}> Your resumes: </div>
                        <div className={s.main_container}>
                            {resumes.map((resume) =>
                            <div className={s.f}>
                                <div className={s.front_card}>
                                    <div className={s.name}> Vacancy name:</div> {resume.props.name}
                                </div>
                                <div className={s.back_card}>
                                    <div className={s.name}>Resume:</div> {resume.props.resume}
                                    <br/>
                                    <div className={s.name}>Status: </div> {resume.props.statusCode}
                                    <br/>
                                    <div className={s.name}> Area:</div>
                                    {areas.filter(area => area.props.id === resume.props.area_id)}
                                </div>
                            </div>
                            )}
                        </div>
                    </div>
                </div>


            )
        }
};

export default ResumePage;