import axios from "axios";
import { useDispatch, useSelector } from "react-redux";
import { startSession } from "../../state/reducer/userSession.reducer";


const BACKEND_LOGIN_API = "http://localhost:8082/api/auth/login";

const useGetToken = () => {

    const dispatch = useDispatch();
    const state = useSelector(state => state);

    const getToken = (credentials) => {
        async function fecthToken() {
            const response = await axios.post(BACKEND_LOGIN_API,{
                user_email: credentials.email,
                user_password: credentials.password
            })
            const userSessionInfo = {
                email: credentials.email,
                token: response.data.token
            }
            if(userSessionInfo.token != null){
                dispatch(startSession(userSessionInfo));
                console.log(dispatch(startSession(userSessionInfo)))
                console.log(state);
                return true;
            }
            return false;
        }
        fecthToken();
    }

    return {
        getToken
    };
};

export default useGetToken;