import React from 'react';
import "./../styles/Home.scss"

const Home = () => {
    return (
        <div className='container height-home'>
            <div className='row'>
                <div className='col-6 col-items'>
                    <h3>To Do app, handled your projects and tasks</h3>
                </div>
                <div className='col-6 col-items'>
                    <ul>
                        <li>Get organized all your projects</li>
                        <li>Easy to create an account</li>
                        <li>Free accounts</li>
                        <li>Minimalism</li>
                    </ul>
                </div>
            </div> 
        </div>
    );
};

export default Home;