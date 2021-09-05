import React, { Component } from "react";
import { NavLink } from "react-router-dom";
import PropTypes from "prop-types"; // impt

const customNavItemsCSS = "nav-item mx-2 nav-link-decor";
const customNavContainerStyle = {
  paddingBottom: "60px",
};
const customNavBrandStyle = {
  color: "grey",
};
export class Header extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  // using default props, if parent component does not provide any values.
  static defaultProps = {
    title: "User!",
  };

  render() {
    const { title } = this.props;
    // console.log(this.props);
    return (
      <div className="container-fluid" style={customNavContainerStyle}>
        <nav className="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
          <div className="container-fluid">
            <NavLink
              exact
              to="/"
              className="navbar-brand"
              activeClassName="active"
              style={customNavBrandStyle}
            >
              New Alvee
            </NavLink>
            <button
              className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarNavDropdown"
              aria-controls="navbarNavDropdown"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNavDropdown">
              <ul className="navbar-nav mr-auto">
                <li className={customNavItemsCSS}>
                  <NavLink
                    to="about"
                    className="nav-link nav-link-decor"
                    activeClassName="active"
                  >
                    About
                  </NavLink>
                </li>

                <li className={customNavItemsCSS}>
                  <NavLink
                    to="favourite"
                    className="nav-link nav-link-decor"
                    activeClassName="active"
                  >
                    Favourite
                  </NavLink>
                </li>
              </ul>
              <ul className="navbar-nav">
                <li className={customNavItemsCSS}>
                  <NavLink
                    to="apidata"
                    className="nav-link nav-link-decor"
                    activeClassName="active"
                  >
                    API
                  </NavLink>
                </li>
                <li className={customNavItemsCSS}>
                  <NavLink
                    to="experience"
                    className="nav-link nav-link-decor"
                    activeClassName="active"
                  >
                    Experience
                  </NavLink>
                </li>
                <li className={customNavItemsCSS}>
                  <NavLink
                    to="example"
                    className="nav-link nav-link-decor"
                    activeClassName="active"
                  >
                    Example
                  </NavLink>
                </li>

                <li className={`nav-item dropdown ${customNavItemsCSS}`}>
                  <a
                    className="nav-link dropdown-toggle"
                    href="/"
                    id="navbarDropdownMenuLink"
                    role="button"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    In Progress
                  </a>
                  <ul
                    className="dropdown-menu"
                    aria-labelledby="navbarDropdownMenuLink"
                  >
                    <li>
                      <a className="dropdown-item" href="#action/3.1">
                        Action
                      </a>
                    </li>
                    <li>
                      <a className="dropdown-item" href="#action/3.2">
                        Another action
                      </a>
                    </li>
                    <li>
                      <a className="dropdown-item" href="#action/3.3">
                        Something else here
                      </a>
                    </li>
                    <hr className="dropdown-divider"></hr>
                    <li>
                      <a className="dropdown-item" href="#action/3.4">
                        Something else here
                      </a>
                    </li>
                  </ul>
                </li>
              </ul>
              <span className="navbar-text">{title}</span>
            </div>
          </div>
        </nav>
      </div>
    );
  }
}

Header.propTypes = {
  title: PropTypes.string,
};

export default Header;
