import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Header from "./components/Header";
import About from "./components/About";
import Favourite from "./components/Favourite";
import Experience from "./components/Experience";
import Example from "./components/Example";
//import Signup from "./components/Signup";
import Body from "./components/Body";
import ApiData from "./components/ApiData";

process.title = "react_ui";
function App() {
  return (
    <React.Fragment>
      <Router>
        <div className="App">
          <Header />
          <div className="container-fluid">
            <Switch>
              <Route exact path="/" component={Body} />
              <Route path="/about" component={About} />
              <Route path="/favourite" component={Favourite} />
              <Route path="/apidata" component={ApiData} />
              <Route path="/experience" component={Experience} />
              <Route path="/example" component={Example} />
            </Switch>
          </div>
        </div>
      </Router>
    </React.Fragment>
  );
}

export default App;
