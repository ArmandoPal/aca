import axiosConfig from "../axios";

// const AUTH_URL = "http://localhost:8080/api";
export const login = async (email, password) => {
  try {
    const response = await axiosConfig.post("/login", {
      userName: email,
      password,
    });
    sessionStorage.setItem("user", JSON.stringify(response.data));
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const register = async (name, lastName, email, password) => {
  try {
    const response = await axiosConfig.post("/register", {
      userName: email,
      password,
      authorities: "ROLE_USER",
      firstName: name,
      lastName,
    });

    //return response.data;
  } catch (error) {
    throw error;
  }
};

export const logout = () => {
  sessionStorage.removeItem("user");
};
