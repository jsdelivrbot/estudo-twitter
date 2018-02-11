import axios from "axios";

export const FETCH_INDICADORES = "fetchIndicadores";
export const CREATE_POST = "create_post";

const ROOT_URL = "http://localhost:3000";
const API_KEY = "?key=PAPERCLIP1234";

export function fetchIndicadores() {
    const request = axios.get(`${ROOT_URL}/data`);
    console.log('==================================================');
    console.log('request', request);
    console.log('==================================================');
    return {
        type: FETCH_INDICADORES,
        payload: request
    };
}

export function createPost(values, callback) {
    const request = axios
        .post(`${ROOT_URL}/posts${API_KEY}`, values)
        .then(() => callback());

    return {
        type: CREATE_POST,
        payload: request
    };
}