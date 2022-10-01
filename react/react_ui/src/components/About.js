import React, { Component } from "react";

export class About extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoaded: false,
      error: null,
      items: [],
    };
  }

  render() {
    var body = (
      <div>
        <h1>About</h1>
      </div>
    );

    return body;
  }
}

export default About;
