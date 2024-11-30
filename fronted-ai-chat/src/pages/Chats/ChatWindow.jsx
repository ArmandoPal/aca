import React, { useRef, useState, useEffect } from "react";

function ChatWindow({ chatHistory: initialChatHistory, selectedChat }) {
  const [chatHistory, setChatHistory] = useState(initialChatHistory);
  const [input, setInput] = useState("");
  const fileInputRef = useRef(null);

  useEffect(() => {
    setChatHistory(initialChatHistory);
  }, [initialChatHistory]);

  const sendMessage = () => {
    if (input.trim()) {
      setChatHistory([...chatHistory, { sender: "user", text: input }]);
      setInput("");
    }
  };

  const handleImageClick = () => {
    fileInputRef.current?.click();
  };

  const handleImageChange = (e) => {
    const file = e.target.files?.[0];
    if (
      file?.name.split(".").pop()?.toLocaleLowerCase() !== "jpg" &&
      file?.name.split(".").pop()?.toLocaleLowerCase() !== "png" &&
      file?.name.split(".").pop()?.toLocaleLowerCase() !== "jpeg"
    ) {
      alert("The file must be a jpg or png image");
      return;
    }

    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setChatHistory([
          ...chatHistory,
          { sender: "user", text: "", image: reader.result },
        ]);
      };
      reader.readAsDataURL(file);
    }
  };

  return (
    <div className="w-3/4 p-4 flex flex-col bg-slate-400">
      <div className="flex-1 overflow-y-auto mb-4">
        <h2 className="text-xl font-bold mb-4 text-white">
          {selectedChat?.name ?? "Welcome"}
        </h2>
        {chatHistory.map((message, index) => (
          <div
            key={index}
            className={`mb-2 p-2 rounded max-w-xs ${
              message.sender === "user"
                ? "bg-blue-100 self-end"
                : "bg-gray-100 self-start"
            }`}
          >
            {message.text}
            {message.image && (
              <img src={message.image} alt="sent" className="mt-2 max-w-full" />
            )}
          </div>
        ))}
      </div>
      <div className="flex">
        <input
          type="text"
          className="flex-1 p-2 border rounded"
          value={input}
          onChange={(e) => setInput(e.target.value)}
        />
        <button
          className="ml-2 p-2 bg-blue-500 text-white rounded"
          onClick={sendMessage}
        >
          Send
        </button>
        <button
          className="ml-2 p-2 bg-green-500 text-white rounded"
          onClick={handleImageClick}
        >
          Send Image
        </button>
        <input
          type="file"
          ref={fileInputRef}
          style={{ display: "none" }}
          onChange={handleImageChange}
        />
      </div>
    </div>
  );
}

export default ChatWindow;
