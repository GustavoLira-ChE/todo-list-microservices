import React from "react";
import { Link } from "react-router-dom";
import "./../styles/MobileNavbar.scss";

const MobileNavbar = () => {


    return (
        <div className="navbar-mobile-items bg-dark">
            <ul className="navbar-nav">
                <li className="nav-item">
                    <Link className="nav-link" to="/login">Login</Link>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to="/signup">SignUp</Link>
                </li>
            </ul>
        </div>
    );
};

export default MobileNavbar;
