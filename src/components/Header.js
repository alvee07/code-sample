import React, { Component } from "react";
import PropTypes from "prop-types"; // impt

export class Header extends Component {
  constructor(props) {
    super(props);

    this.state = {};
  }

  // using default props, if parent comp does not provide any values.
  static defaultProps = {
    title: "Welcome",
  };

  render() {
    const { title } = this.props;
    console.log(this.props);
    return (
      <header>
        <h1>{title} to React UI</h1>
        <a
          href="https://alvee.azurewebsites.net"
          target="_blank"
          rel="noreferrer"
        >
          Azure web app
        </a>
      </header>
    );
  }
}

Header.propTypes = {
  title: PropTypes.string,
};

export default Header;
