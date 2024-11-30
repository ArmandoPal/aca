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
          image:
            "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png",
        },
        { sender: "bot", text: "Hi! How can I help you today?", image: "" },
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
