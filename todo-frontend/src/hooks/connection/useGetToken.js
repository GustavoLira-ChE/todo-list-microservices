import { useState } from "react";
import axios from "axios";

const BACKEND_LOGIN_API = "http://localhost:8082/api/auth/login";

const useGetToken = () => {

    const [token, setToken] = useState(null);

    const getToken = (credentials) => {
        async function fecthToken() {
            const response = await axios.post(BACKEND_LOGIN_API,{
                user_email: credentials.email,
                user_password: credentials.password
            })
            setToken(response.data.token);
        }
        fecthToken();
    }

    return {
        token,
        getToken
    };
};

export default useGetToken;