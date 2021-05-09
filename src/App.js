import Navigation from "./components/Navigation";
import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";

process.title = "react_ui";
function App() {
  return (
    <React.Fragment>
      <Navigation />
      <div className="container-fluid"></div>
    </React.Fragment>
  );
}

export default App;
