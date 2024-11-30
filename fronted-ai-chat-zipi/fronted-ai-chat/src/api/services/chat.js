import axiosConfig from "../axios";

export const getChats = async () => {
  try {
    const response = await axiosConfig.get("/chats");
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const postChat = async () => {
  try {
    const response = await axiosConfig.post("/chats");
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const getChatById = async (id) => {
  try {
    const response = await axiosConfig.get("/chats" + `/${id}`);
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const postMessage = async (content, chatID, aiModel) => {
  try {
    const response = await axiosConfig.post("/messages", {
      content,
      chatID,
      aiModel,
    });
    return response.data;
  } catch (error) {
    throw error;
  }
};
