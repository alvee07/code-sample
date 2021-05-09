import React, { Component } from "react";
import { Navbar, Nav, NavDropdown } from "react-bootstrap";

const spaceBetweenNavItems = "mx-2";
export class Navigation extends Component {
  render() {
    return (
      <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
        <Navbar.Brand href="#home">Alvee Akash</Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link href="#about" className={spaceBetweenNavItems}>
              About
            </Nav.Link>
            <Nav.Link href="#favourite" className={spaceBetweenNavItems}>
              Favourite
            </Nav.Link>
          </Nav>
          <Nav className="ml-auto">
            <Nav.Link href="#experience" className={spaceBetweenNavItems}>
              Experience
            </Nav.Link>
            <Nav.Link href="#example" className={spaceBetweenNavItems}>
              Example
            </Nav.Link>
            <NavDropdown title="In Progress" id="collasible-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">
                Another action
              </NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">
                Separated link
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    );
  }
}

export default Navigation;
