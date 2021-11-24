import React, { Component } from 'react';
import './Navigation.css';

export class Navigation extends Component {
	static displayName = Navigation.name;

	constructor(props) {
		super(props);
		this.state = { showNav: true };
		this.toggleNav = this.toggleNav.bind(this);
	}

	toggleNav() {
		this.setState({
			showNav: !this.state.showNav,
		});
	}

	render() {
		const { showNav } = this.state;

		return (
			<div className="navbar navbar-expand-lg navbar-light bg-light">
				<a className="navbar-brand" href="#">
					Navbar
				</a>
				<button
					className="navbar-toggler"
					type="button"
					onClick={this.toggleNav}
				>
					<span className="navbar-toggler-icon"></span>
				</button>
				<div
					className={
						(showNav ? 'show' : '') + ' collapse navbar-collapse'
					}
					ref="mynav"
				>
					<ul className="navbar-nav mr-auto">
						<li className="nav-item">
							<a className="nav-link" href="#">
								Link
							</a>
						</li>
						<li className="nav-item dropdown">
							<a
								className="nav-link dropdown-toggle"
								href="#"
								id="navbarDropdown"
								role="button"
								data-toggle="dropdown"
								aria-haspopup="true"
								aria-expanded="false"
							>
								Dropdown
							</a>
							<div
								className="dropdown-menu"
								aria-labelledby="navbarDropdown"
							>
								<a className="dropdown-item" href="#">
									Action
								</a>
								<a className="dropdown-item" href="#">
									Another action
								</a>
								<div className="dropdown-divider"></div>
								<a className="dropdown-item" href="#">
									Something else here
								</a>
							</div>
						</li>
						<li className="nav-item">
							<a className="nav-link disabled" href="#">
								Disabled
							</a>
						</li>
					</ul>
				</div>
			</div>
		);
	}
}
