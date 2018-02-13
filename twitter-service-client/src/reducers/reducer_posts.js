import _ from "lodash";
import { FETCH_INDICADORES } from "../actions";

export default function(state = {}, action) {
    switch (action.type) {
        case FETCH_INDICADORES:
            return {...state, ...action.payload.data };
        default:
            return state;
    }
}