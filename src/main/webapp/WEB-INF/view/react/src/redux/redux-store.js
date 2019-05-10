
import {applyMiddleware, combineReducers, createStore} from "redux";
import promise from "redux-promise-middleware";
import thunk from "redux-thunk";
import resumeReducer from "./resumeReducer";
import vacancyReducer from "./vacancyReducer";
import {routerMiddleware, routerReducer} from "react-router-redux";
import {createBrowserHistory} from 'history'



let reducers = combineReducers({
    routing: routerReducer,
    vacancyPage: vacancyReducer,
    resumePage: resumeReducer,
});

export let browserHistory = createBrowserHistory();

const middleware = applyMiddleware(promise, thunk, routerMiddleware(browserHistory));
export let store = createStore(reducers, middleware);

export default store;