import React from "react";
import useGetToken from "../hooks/connection/useGetToken";

const UserTokenContext = React.createContext({});

const UserTokenProvider = ( {children} ) => {
    const userTokenSetting = useGetToken();

    return(
        <UserTokenContext.Provider value={userTokenSetting}>
            {children}
        </UserTokenContext.Provider>
    );
};

export { UserTokenProvider };
export default UserTokenContext;
