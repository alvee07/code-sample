import React, { Component } from "react";
import PropTypes from "prop-types";
import Signup from "./Signup";

class Body extends Component {
  // rce
  constructor(props) {
    // rconst
    super(props);

    this.state = {
      message: "This is body tag",
      isGreet: true,
      incrementNum: 1,
    };

    this.clickHandler = this.clickHandler.bind(this);
  }

  clickHandler() {
    this.setState({
      incrementNum: this.state.incrementNum + 1,
      message: "Body tag increments by " + this.state.incrementNum,
    });
  }

  render() {
    return (
      <React.Fragment>
        <Signup />
        <div>{this.state.message}</div>
        <div>
          <button onClick={this.clickHandler}>
            Click me to see some text changes
          </button>
        </div>
      </React.Fragment>
    );
  }
}

export default Body;
Body.propTypes = {
  incrementNum: PropTypes.number,
};
