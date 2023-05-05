import React from 'react';
import { Routes, Route } from "react-router-dom";
import Home from '../components/Home';
import Layout from '../containers/Layout'
import NotFound from '../components/NotFound';
import Login from '../components/Login';

const MainRoutes = () => {
    return (
        <Routes>
            <Route path='/' element={<Layout />}></Route>
                <Route index element={<Home />}></Route>
                <Route path='/login' element={<Login />}></Route>
                <Route path='*' element={<NotFound />} />
        </Routes>
    );
};

export default MainRoutes;