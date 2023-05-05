import React from 'react';
import { BrowserRouter } from "react-router-dom";
import Header from './components/Header';
import MainRoutes from './routes/MainRoutes';
import Footer from './components/Footer';

const App = () => {
    return (
        <BrowserRouter>
            <Header />
            <MainRoutes />
            <Footer />
        </BrowserRouter>
    );
}

export default App;