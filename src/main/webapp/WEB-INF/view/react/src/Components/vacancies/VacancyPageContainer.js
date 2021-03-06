import {connect} from "react-redux";
import VacancyPage from "./VacancyPage";
import {
    fetchVacanciesCreator,
    setMustFetchVacanciesCreator,
    fetchResumeCreator,
    sendResumeCreator,
    fetchCompaniesCreator,
    setMustFetchCompanyCreator, setMustFetchAreaCreator, selectResumeCreator, selectVacancyCreator,

} from "../../redux/vacancyReducer";
import {fetchAreasCreator, setMustFetchResumeCreator} from "../../redux/resumeReducer";


let mapStateToProps = (state) => {
    return {
        resumes: state.resumePage.resumes,
        vacancies: state.vacancyPage.vacancies,
        mustFetch: state.vacancyPage.mustFetch,
        companies: state.vacancyPage.companies,
        areas : state.vacancyPage.areas
    };
};


let mapDispatchToProps = (dispatch) => {
    return {
        setMustFetch: (newValue) => {
            dispatch(setMustFetchVacanciesCreator(newValue));
            dispatch(setMustFetchResumeCreator(newValue));
            dispatch(setMustFetchCompanyCreator(newValue));
            dispatch(setMustFetchAreaCreator(newValue));
        },
        sendResume: () => {
            dispatch(sendResumeCreator());
        },
        fetchVacancies: () => {
            dispatch(fetchVacanciesCreator());
        },
        fetchResumes: () => {
            dispatch(fetchResumeCreator())
        },
        fetchCompanies: () => {
            dispatch(fetchCompaniesCreator())
        },
        fetchAreas: () => {
            dispatch(fetchAreasCreator())
        },
        selectResume: (event) => {
            let resumeId = event.target.value;

            dispatch(selectResumeCreator(resumeId))
        },
        selectVacancy: (event) => {
            let vacancyId = event.target.value;
            console.log(event.target.value);
            dispatch(selectVacancyCreator(vacancyId))
        }
    };
};

let VacancyPageContainer = connect(mapStateToProps, mapDispatchToProps)(VacancyPage);

export default VacancyPageContainer;