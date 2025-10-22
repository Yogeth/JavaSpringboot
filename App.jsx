import React, { useState } from "react";
import Editor from "@monaco-editor/react";
import axios from "axios";

function App() {
  const [code, setCode] = useState("// Type a command like 'ls' or 'pwd'");
  const [output, setOutput] = useState("");

  const handleRun = async () => {
    try {
      const res = await axios.post(
        "http://localhost:8080/api/terminal/exec",
        code,
        { headers: { "Content-Type": "text/plain" } }
      );
      setOutput(res.data);
    } catch (err) {
      setOutput("Error: " + err.message);
    }
  };

  return (
    <div style={{ display: "flex", flexDirection: "column", height: "100vh" }}>
      <h2 style={{ background: "#1e1e1e", color: "white", padding: "10px" }}>
        Web IDE (VS Code Style)
      </h2>

      <div style={{ display: "flex", flex: 1 }}>
        <Editor
          height="80vh"
          width="70%"
          theme="vs-dark"
          defaultLanguage="javascript"
          value={code}
          onChange={setCode}
        />
        <div
          style={{
            width: "30%",
            backgroundColor: "#111",
            color: "lime",
            padding: "10px",
            fontFamily: "monospace",
            overflowY: "auto",
          }}
        >
          <h3>Terminal Output:</h3>
          <pre>{output}</pre>
        </div>
      </div>

      <button
        onClick={handleRun}
        style={{
          background: "#007acc",
          color: "white",
          border: "none",
          padding: "10px",
          cursor: "pointer",
        }}
      >
        Run Code
      </button>
    </div>
  );
}

export default App;
