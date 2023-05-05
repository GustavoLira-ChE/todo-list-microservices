import React from "react";
import "./../styles/NotFound.scss"

const NotFound = () => {
    return(
        <div className="container">
            <div className="row spacing">
                <h1 className="notFoundTitle">
                    Not Found, error 404. <strong>:(</strong>
                </h1>
            </div>
        </div>
    );
}

export default NotFound;