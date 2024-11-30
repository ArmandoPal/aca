import React, { useEffect, useState } from "react";
import ChatList from "./ChatList";
import ChatWindow from "./ChatWindow";
import { getChatById } from "../../api/services/chat";

function Chat() {
  const [selectedChat, setSelectedChat] = useState(null);
  const [chatHistory, setChatHistory] = useState([]);

  /*useEffect(() => {
    if (setSelectedChat?.id) {
      getChatById(setSelectedChat.id)
        .then((data) => setChatHistory(data))
        .catch((error) => console.error("Error fetching chat history:", error));
    }
  }, [setSelectedChat]);*/
  useEffect(() => {
    console.log("🚀 ~ Chat ~ selectedChatId:", selectedChat);
    if (selectedChat?.id) {
      setChatHistory([
        {
          sender: "user",
          text: "Hello",
          image: "",
        },
        { sender: "bot", text: "Hi! How can I help you today?", image: "" },
        {
          sender: "user",
          text: "Analize this image ",
          image:
            "https://img.freepik.com/vector-gratis/paisaje-primavera-dibujado-mano_23-2147605182.jpg?semt=ais_hybrid",
        },

        {
          sender: "bot",
          text: "This a nice image",
          image: "",
        },
      ]);
    }
  }, [selectedChat]);

  return (
    <div className="flex h-screen">
      <ChatList onSelectChat={setSelectedChat} />
      <ChatWindow chatHistory={chatHistory} selectedChat={selectedChat} />
    </div>
  );
}

export default Chat;
