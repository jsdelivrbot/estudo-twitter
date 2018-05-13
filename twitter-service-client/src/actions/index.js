import axios from "axios";

export const FETCH_INDICADORES = "fetchIndicadores";

const ROOT_URL = "http://apigateway:8075/api/tweets";

export function fetchIndicadores() {
    const request = axios.get(`${ROOT_URL}/v1/tweets?view=indicadores`);
    return {
        type: FETCH_INDICADORES,
        payload: request
    };
}
