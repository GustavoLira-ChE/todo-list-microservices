import React, { useRef } from 'react';
import "./../styles/Login.scss";
import { Link } from 'react-router-dom';

const Login = () => {

    const loginForm = useRef(null);

    const handleLoginFormValues = (event) => {
        event.preventDefault();
        const formData = new FormData(loginForm.current);
        const data = {
            email: formData.get("email"),
            password: formData.get("password")
        }
        console.log(data);
    }

    return (
        <div className="login">
            <div className="login-container mb-3">
                <h1>Login to your account</h1>
                <form ref={loginForm}>
                    <div className="login-field input-group">
                        <label className='form-label' htmlFor="">Email: </label><br />
                        <input type="email" className='form-control'
                        name="email" />
                    </div>
                    <div className="login-field input-group">
                        <label className='form-label' htmlFor="">Password: </label><br />
                        <input type="password" className='form-control' name='password'/>
                    </div>
                    <input className="login-submit-button" type="submit" value="Login" onClick={(event)=> handleLoginFormValues(event)} />
                </form>
                <p>Need an account? <Link to="/signup">SIGN UP</Link></p>
            </div>
        </div>
    );
};

export default Login;