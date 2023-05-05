import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./../styles/Navbar.scss"
import MobileNavbar from "./MobileNavbar";

const Header = () => {

    const [toggleMobile, setToggleMobile] = useState(false);

    const handleToggleMobile = () => {
		setToggleMobile(!toggleMobile);
	};

    return (
        <nav className="navbar navbar-dark bg-dark header-background">
            <div className="container navbar-container">
                <h2>
                <Link className="navbar-brand" to="/">ToDo App</Link>
                </h2>
                <div className="navbar-desktop">
                    <ul className="navbar-nav nav-items">
                        <li className="nav-item">
                            <Link className="nav-link" to="/login">Login</Link>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">Sign up</a>
                        </li>
                    </ul>
                </div>
                <div className="navbar-mobile">
                    <button className="navbar-toggler" type="button" onClick={handleToggleMobile}>
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    {toggleMobile && <MobileNavbar />}
                </div>
            </div>
        </nav>
    );
};

export default Header;