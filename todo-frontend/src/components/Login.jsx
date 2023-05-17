import React, { useRef, useContext } from 'react';
import { useSelector } from 'react-redux';
import "./../styles/Login.scss";
import { Link, useNavigate } from 'react-router-dom';
import UserTokenContext from '../context/UserTokenContext';

const Login = () => {

    const { getToken } = useContext(UserTokenContext);
    const loginForm = useRef(null);
    let navigate = useNavigate();
    const state = useSelector(state => state)

    const handleLoginFormValues = () => {
        const formData = new FormData(loginForm.current);
        const data = {
            email: formData.get("email"),
            password: formData.get("password")
        }
        let validate = getToken(data);
        console.log(state, validate);
        if(validate){
            navigate("/");
        }
    }

    return (
        <div className="login">
            <div className="login-container mb-3">
                <h1>Login to your account</h1>
                <form ref={loginForm} onSubmit={(e) => e.preventDefault()}>
                    <div className="login-field input-group">
                        <label className='form-label' htmlFor="">Email: </label><br />
                        <input type="email" className='form-control'
                        name="email" />
                    </div>
                    <div className="login-field input-group">
                        <label className='form-label' htmlFor="">Password: </label><br />
                        <input type="password" className='form-control' name='password'/>
                    </div>
                    <button className="login-submit-button" onClick={()=> handleLoginFormValues()}>Login</button>
                </form>
                <p>Need an account? <Link to="/signup">SIGN UP</Link></p>
            </div>
        </div>
    );
};

export default Login;