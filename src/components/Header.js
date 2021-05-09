import React, { Component } from "react";
import PropTypes from "prop-types"; // impt
import { Navbar, Nav, NavDropdown } from "react-bootstrap";

const spaceBetweenNavItems = "mx-2";

export class Header extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  // using default props, if parent comp does not provide any values.
  static defaultProps = {
    title: "User!",
  };

  render() {
    const { title } = this.props;
    console.log(this.props);
    return (
      <header>
        <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
          <Navbar.Brand href="/">Alvee Akash</Navbar.Brand>
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Link href="about" className={spaceBetweenNavItems}>
                About
              </Nav.Link>
              <Nav.Link href="favourite" className={spaceBetweenNavItems}>
                Favourite
              </Nav.Link>
            </Nav>
            <Nav className="ml-auto">
              <Nav.Link href="experience" className={spaceBetweenNavItems}>
                Experience
              </Nav.Link>
              <Nav.Link href="example" className={spaceBetweenNavItems}>
                Example
              </Nav.Link>
              <NavDropdown title="In Progress" id="collasible-nav-dropdown">
                <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                <NavDropdown.Item href="#action/3.2">
                  Another action
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.3">
                  Something
                </NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action/3.4">
                  Separated link
                </NavDropdown.Item>
              </NavDropdown>
            </Nav>
            <Navbar.Text className={spaceBetweenNavItems}>{title}</Navbar.Text>
          </Navbar.Collapse>
        </Navbar>
      </header>
    );
  }
}

Header.propTypes = {
  title: PropTypes.string,
};

export default Header;
