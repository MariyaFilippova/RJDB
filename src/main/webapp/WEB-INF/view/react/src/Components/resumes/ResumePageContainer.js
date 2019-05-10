
import ResumePage from "./ResumePage";
import {
    fetchResumeCreator,
    setMustFetchResumeCreator,
    addResumeCreator,
    updateResumeCreator,
    updateNameCreator,
    selectAreaCreator,
    fetchAreasCreator
} from "../../redux/resumeReducer";
import {connect} from "react-redux";

let mapStateToProps = (state) => {
    return{
        mustFetch: state.resumePage.mustFetch,
        resumes: state.resumePage.resumes,
        resumeResume: state.resumePage.resumeResume,
        resumeName: state.resumePage.resumeName,
        resumeAreaId: state.resumePage.resumeAreaId,
        areas: state.resumePage.areas,
    }
};
let mapDispatchToProps = (dispatch) => {
    return {
        setMustFetch: (newValue) => {
            dispatch(setMustFetchResumeCreator(newValue));
        },
        fetchResumes: () => {
            dispatch(fetchResumeCreator());
        },
        addResume: () => {
            dispatch(addResumeCreator());
            dispatch(setMustFetchResumeCreator(true))
        },
        fetchAreas: () => {
            dispatch(fetchAreasCreator());
        },

        resumeChange: (event) => {
            let newText = event.target.value;
            dispatch(updateResumeCreator(newText));
        },
        nameChange: (event) => {
            let newText = event.target.value;
            dispatch(updateNameCreator(newText))
        },
        selectArea: (event) => {
            let area = event.target.value;
            dispatch(selectAreaCreator(area))
        }
    };
};


let ResumePageContainer = connect(mapStateToProps, mapDispatchToProps)(ResumePage);


export default ResumePageContainer;