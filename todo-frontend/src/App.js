import React from 'react';
import { BrowserRouter } from "react-router-dom";
import Header from './components/Header';
import MainRoutes from './routes/MainRoutes';
import Footer from './components/Footer';
import store from "./state/store/userSession.store";
import { Provider } from "react-redux";
import { UserTokenProvider } from './context/UserTokenContext';


const App = () => {
    return (
        <Provider store={store}>
            <UserTokenProvider>
                <BrowserRouter>
                    <Header />
                    <MainRoutes />
                    <Footer />
                </BrowserRouter>
            </UserTokenProvider>
        </Provider>
    );
}

export default App;