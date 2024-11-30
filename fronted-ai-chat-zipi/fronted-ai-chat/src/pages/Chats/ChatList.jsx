import React, { useState } from "react";
import { getChats } from "../../api/services/chat";

const chats = [
  { id: 1, name: "Chat 1" },
  { id: 2, name: "Chat 2" },
  { id: 3, name: "Chat 3" },
];

function ChatList({ onSelectChat }) {
  //   const [chats, setChats] = useState([]);

  //   useEffect(() => {
  //     getChats().then((data) => setChats(data));
  //   }, []);


  const setChat = (chat) => {
    onSelectChat(chat);
  };

  return (
    <div className="w-1/4 bg-gray-100 p-4">
      <h2 className="text-xl font-bold mb-4">Chats</h2>
      <ul>
        {chats.map((chat) => (
          <li
            key={chat.id}
            className="mb-2 p-2 bg-white rounded shadow cursor-pointer"
            onClick={() => setChat(chat)}
          >
            {chat.name}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ChatList;
