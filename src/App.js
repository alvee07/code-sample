import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import { Container } from "react-bootstrap";
import Header from "./components/Header";
import About from "./components/About";
import Favourite from "./components/Favourite";
import Experience from "./components/Experience";
import Example from "./components/Example";

process.title = "react_ui";
function App() {
  return (
    <React.Fragment>
      <Router>
        <Header />
        <Container fluid={true}>
          <Switch>
            <Route exact path="/" component={About} />
            <Route path="/about" component={About} />
            <Route path="/favourite" component={Favourite} />
            <Route path="/experience" component={Experience} />
            <Route path="/example" component={Example} />
          </Switch>
        </Container>
      </Router>
    </React.Fragment>
  );
}

export default App;
