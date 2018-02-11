import _ from "lodash";
import { FETCH_INDICADORES } from "../actions";

export default function(state = {}, action) {
    console.log('==================================================');
    console.log('action', action);
    console.log('==================================================');
    switch (action.type) {
        case FETCH_INDICADORES:
            return {...state, ...action.payload.data };
        default:
            return state;
    }
}