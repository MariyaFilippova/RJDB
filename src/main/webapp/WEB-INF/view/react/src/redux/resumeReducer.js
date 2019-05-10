import axios from "axios";


const SELECT_AREA = 'SELECT_AREA';
const FETCH_AREAS = 'FETCH_AREAS';
const FETCH_AREAS_FULFILLED ='FETCH_AREAS_FULFILLED';
const SET_MUST_FETCH_RESUMES = 'SET_MUST_FETCH_ORDERS';
const FETCH_RESUMES = 'FETCH_ORDERS';
const FETCH_RESUMES_PENDING = 'FETCH_ORDERS_PENDING';
const FETCH_RESUMES_REJECTED = 'FETCH_ORDERS_REJECTED';
const FETCH_RESUMES_FULFILLED = 'FETCH_ORDERS_FULFILLED';
const ADD_RESUME = 'ADD_RESUME';
const UPDATE_RESUME = 'UPDATE_RESUME';
const UPDATE_NAME = 'UPDATE_NAME';

let initialState = {

    mustFetch: true,
    fetching: false,
    fetched: false,
    error: null,
    resumes: [],
    areas: [],
    resumeResume: "",
    resumeName: "",
    resumeAreaId: ""

};
const resumeReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_MUST_FETCH_RESUMES:
            return {
                ...state,
                mustFetch: action.newValue
            };

        case FETCH_RESUMES_PENDING:
            return {
                ...state,
                fetching: false,
                error: null
            };
        case SELECT_AREA:
            return selectArea(state, action);
        case FETCH_AREAS:
            return fetchAreasCreator();

        case FETCH_RESUMES_REJECTED:
            return {
                ...state,
                fetching: false,
                error: action.error
            };
        case FETCH_RESUMES_FULFILLED:
            return {
                ...state,
                fetching: false,
                fetched: true,
                resumes: action.payload.data,
            };
        case UPDATE_NAME :
            return updateName(state, action.newText);
        case UPDATE_RESUME:
            return updateResume(state, action.newText);
        case ADD_RESUME:
            return addResume(state);
        case FETCH_AREAS_FULFILLED:
            return fetchAreasFulfilled(state, action);
        default:
            return state;

    }

};
    const updateName = (state, newText) => {
        let stateCopy = {...state};
        stateCopy.resumeName = newText;
        return stateCopy;
    };
    const updateResume = (state, newText) => {
        let stateCopy = {...state};
        stateCopy.resumeResume = newText;
        return stateCopy;
    };
    const selectArea = (state, action) => {
        let stateCopy = {...state};
        stateCopy.resumeAreaId = action.resumeAreaId;
        return stateCopy;
    };

    const fetchAreasFulfilled = (state, action) => {
        return {
            ...state,
            fetching: false,
            fetched: true,
            areas: action.payload.data,
        };
    };

    const addResume = (state) =>
    {
        let stateCopy = {...state};

        let resumeDto  = {
            resume : stateCopy.resumeResume,
            name : stateCopy.resumeName,
            area_id : stateCopy.resumeAreaId,

        };
        axios.post("api/resumes/create_resume", resumeDto);
        stateCopy.resumeName = "";
        stateCopy.resumeResume = "";
        stateCopy.resumeAreaId = "";
        return stateCopy;
    };

    export const setMustFetchResumeCreator = (newValue) => {
        return {
            type: SET_MUST_FETCH_RESUMES,
            newValue: newValue
        }
    };

    export const addResumeCreator = () =>
    {
        return{
            type: ADD_RESUME
        }
    };
    export const updateResumeCreator = (newText) =>
    {
        return{
            type:UPDATE_RESUME,
            newText: newText,

        }
    };
    export const updateNameCreator = (newText) =>
    {
        return{
            type:UPDATE_NAME,
            newText: newText,
        }
    };
    export const selectAreaCreator = (resumeAreaId) =>
    {
        return {
            type: SELECT_AREA,
            resumeAreaId: resumeAreaId
        }
    };
    export const fetchResumeCreator = () => {
        return {
            type: FETCH_RESUMES,
            payload: axios.get("api/resumes")
        }
    };
    export const fetchAreasCreator = () => {
        return {
            type: FETCH_AREAS,
            payload: axios.get("api/areas")
        };
    };


export default resumeReducer;