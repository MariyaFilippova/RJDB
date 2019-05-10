import axios from "axios";
const SET_MUST_FETCH_VACANCIES = 'SET_MUST_FETCH_VACANCIES';
const FETCH_VACANCIES = 'FETCH_VACANCIES';
const FETCH_VACANCIES_FULFILLED = 'FETCH_VACANCIES_FULFILLED';
const FETCH_VACANCIES_PENDING = 'FETCH_VACANCIES_PENDING';

const SELECT_RESUME ='SELECT_RESUME';
const SEND_RESUME = 'SEND_RESUME';
const  FETCH_RESUMES = 'FETCH_RESUMES ';
const FETCH_RESUMES_FULFILLED = 'FETCH_RESUMES_FULFILLED';

const FETCH_COMPANIES_FULFILLED ='FETCH_COMPANIES_FULFILLED';
const SET_MUST_FETCH_COMPANIES = 'SET_MUST_FETCH_COMPANIES';
const FETCH_COMPANIES = 'FETCH_COMPANIES';
const SET_MUST_FETCH_AREAS = 'SET_MUST_FETCH_AREAS';
const FETCH_AREAS_FULFILLED ='FETCH_AREAS_FULFILLED';


const initialState = {
    mustFetch: true,
    fetching: false,
    fetched: false,
    error: null,
    vacancies: [],
    companies: [],
    resumes : [],
    areas : [],
    resumeId: "",
    vacancyId: "",
    companyVacancyId:""
};

const vacancyReducer = (state = initialState, action) => {
    switch (action.type) {
        case FETCH_RESUMES_FULFILLED:
            return fetchResumesFulfilled(state, action);
        case SET_MUST_FETCH_VACANCIES:
            return {
                ...state,
                mustFetch: action.newValue
            };
        case SET_MUST_FETCH_AREAS:
        {
            return {
                ...state,
                mustFetch: action.newValue
            }
        }
        case FETCH_AREAS_FULFILLED:
            return fetchAreasFulfilled(state, action);

        case FETCH_COMPANIES_FULFILLED:
            return fetchCompaniesFulfilled(state, action);
        case SET_MUST_FETCH_COMPANIES:
            return {
                ...state,
                mustFetch: action.newValue
            };
        case FETCH_COMPANIES:
            return  fetchCompaniesCreator;
        case SEND_RESUME:
            return sendResume(state);
        case FETCH_RESUMES:
            return fetchResumeCreator;

        case FETCH_VACANCIES_PENDING:
            return {
                ...state,
                fetching: false,
            };
        case FETCH_VACANCIES_FULFILLED:
            return fetchVacanciesFulfilled(state, action);
        default:
            return state;
    }
};
const fetchVacanciesFulfilled = (state, action) => {
    return {
        ...state,
        fetching: false,
        fetched: true,
        vacancies: action.payload.data
    };
};
const fetchResumesFulfilled = (state, action) => {
    return {
        ...state,
        fetching: false,
        fetched: true,
        resumes: action.payload.data,
    };
};
const fetchCompaniesFulfilled = (state, action) => {
    return {
        ...state,
        fetching: false,
        fetched: true,
        companies: action.payload.data
    };
};
const fetchAreasFulfilled = (state, action) => {
    return {
        ...state,
        fetching: false,
        fetched: true,
        areas: action.payload.data,
    };
};

const sendResume = (state) =>
{
    let stateCopy = {...state};

    let vacancyResumeDto  = {
        resume_id : stateCopy.resumeId,
        vacancy_id : stateCopy.vacancyId,
        company_id : stateCopy.companyVacancyId
    };
    axios.post("api/vacancy_resume/create" ,  vacancyResumeDto);
    return stateCopy;
};
export const fetchResumeCreator = () => {
    return {
        type: FETCH_RESUMES,
        payload: axios.get("api/resumes")
    }
};
export const setMustFetchCompanyCreator = (newValue) => {
    return{
        type: SET_MUST_FETCH_COMPANIES,
        newValue: newValue
    }
};
export const setMustFetchAreaCreator = (newValue) => {
    return{
        type: SET_MUST_FETCH_AREAS,
        newValue: newValue
    }
};

export const setMustFetchVacanciesCreator = (newValue) => {
    return {
        type: SET_MUST_FETCH_VACANCIES,
        newValue: newValue
    }
};

export const fetchVacanciesCreator = () => {
    return {
        type: FETCH_VACANCIES,
        payload: axios.get("api/vacancy")
    }
};
export const fetchCompaniesCreator = () => {
    return {
        type: FETCH_COMPANIES,
        payload: axios.get("api/company")
    }
};

export const sendResumeCreator = () =>
{
    return{
        type: SEND_RESUME
    }
};

export default vacancyReducer;