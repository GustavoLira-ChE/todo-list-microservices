import { createSlice } from "@reduxjs/toolkit";

const initialStateValues = {
    email: null,
    token: null
};

const sessionSlice = createSlice({
    name: "session",
    initialState: {
        userInfo: initialStateValues
    },
    reducers: {
        startSession: (state, action) => {
            state.userInfo = action.payload
        },
        closeSession: (state) => {
            state.userInfo = initialStateValues
        }
    }
})

export const { startSession, closeSession } = sessionSlice.actions;

export default sessionSlice.reducer;