import { configureStore } from "@reduxjs/toolkit";
import sessionReducer from "./../reducer/userSession.reducer"

const store = configureStore({
    reducer: {sessionReducer} 
  });

export default store;