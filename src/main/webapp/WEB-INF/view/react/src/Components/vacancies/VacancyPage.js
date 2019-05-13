import React from 'react';
import Vacancy from "./item/Vacancy";
import s from "./VacancyPage.module.css";
import Resume from "../resumes/item/Resume";

import Company from "./item/Company";
import Area from "../resumes/item/Area";


let VacancyPage = (props) => {
    if (props.mustFetch) {
        props.fetchVacancies();
        props.fetchResumes();
        props.setMustFetch(false);
        props.fetchCompanies();
        props.fetchAreas();
    }
    const onSendResume = () =>
    {
        props.sendResume();
    };
    const onSelectResume = (event) =>
    {
        props.selectResume(event);
    };
    const onSelectVacancy = (event) =>
    {
        props.selectVacancy(event);
    };


    let areas = props.areas
        .map((area) =>
                    <Area key = {area.area_id}
                             id={area.area_id}
                             area = {area.area}/>

        );




    let vacancies = props.vacancies
        .map(vacancy =>
            <Vacancy key={vacancy.id}
                     id={vacancy.id}
                     company={vacancy.company_id}
                     vacancy={vacancy.vacancy}
                     name={vacancy.name}
                     area={vacancy.area_id}
                     status={vacancy.status}

            />);




    let resumes = props.resumes
        .map((resume) => <Resume key={resume.id}
                                 id={resume.id}
                                 name={resume.name}
                                 resume = {resume.resume}/>
        );
    let companies = props.companies
        .map((company) => <Company key={company.id}
                                   id = {company.id}
                                        name={company.name}

            />
        );



    return  <div className={s.vacancyWrapper}>
        <table className={s.table} border="1px" width="1px" height="2000px"> </table>
                <div className={s.main_container}>

                    {vacancies.map((v) =>
                        <div className={s.f}>
                            <div className={s.card}>

                                <div className={s.name}> Vacancy: </div> {v.props.name}
                                <br/>


                            </div>
                            <div className={s.back_card}>
                                <div className={s.name}> Details: </div>{v.props.vacancy}
                                <br/>
                                <div className={s.name}> Status: </div>{v.props.status}
                                <br/>
                                <div className={s.name}> Area: </div> {areas.filter(area => area.props.id === v.props.area)}
                                <br/>
                                <div className={s.name}> Company:  </div> {companies.filter(company => company.props.id === v.props.company)}
                                <br/>


                            </div>
                        </div>

                    )}
                </div>

                    <div className={s.sending}>

                        <div className={s.vacancy}> Choose your resume to send:</div>

                        <div>
                            <select className={s.select}
                                    value = {props.id}

                                    onChange={onSelectResume}>

                                <option/>
                                {resumes.map((resume) => {
                                    return <option key={resume.props.id} value={resume.props.id} > {resume.props.name}

                                    </option>
                                })
                                }
                            </select>
                        </div>

                            <div className={s.vacancy}> Choose vacancy :</div>

                        <div>
                            <select className={s.select}
                                    value = {props.id}

                                    onChange={onSelectVacancy}>

                                <option/>
                                {vacancies.map((vacancy) => {
                                    return <option key={vacancy.props.id} value={vacancy.props.id} > {vacancy.props.name}
                                        {console.log(vacancy.props.id)}
                                    </option>


                                })
                                }

                            </select>
                        </div>
                        <button className={s.button} onClick = {onSendResume}> Send Resume </button>
                    </div>
                </div>




};
export default VacancyPage;