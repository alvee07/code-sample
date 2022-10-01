import React, { Component } from 'react';
import './Navigation.css';

export class Navigation extends Component {
	static displayName = Navigation.name;

	constructor(props) {
		super(props);
		this.state = { showNav: true, showDropdown: false };
		this.toggleNav = this.toggleNav.bind(this);
		this.toggleDropdown = this.toggleDropdown.bind(this);
	}

	toggleNav() {
		this.setState({
			showNav: !this.state.showNav,
		});
	}

	toggleDropdown() {
		console.log(this);
		this.setState({
			showDropdown: !this.state.showDropdown,
		});
	}

	render() {
		const { showNav, showDropdown } = this.state;

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
							<a className="nav-link" href="/">
								Home
							</a>
						</li>
						<li className="nav-item dropdown">
							<button
								className={
									'nav-link dropdown-toggle ' + showDropdown
										? 'show'
										: ''
								}
								onClick={this.toggleDropdown}
								onMouseLeave={this.toggleDropdown}
							>
								Dropdown
							</button>
							<div
								className={
									'dropdown-menu ' +
									(showDropdown ? 'show' : '')
								}
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
							<a className="nav-link" href="/fetch-data">
								FetchData
							</a>
						</li>
					</ul>
				</div>
			</div>
		);
	}
}
