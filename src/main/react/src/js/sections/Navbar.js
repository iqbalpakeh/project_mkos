import React, { Component } from "react";
import { NavLink } from "react-router-dom";

class Navbar extends Component {
	render() {
		return (
			<div>
				<div className="navbar navbar-expand-sm navbar-dark bg-dark p-0">
					<div className="container">
						<NavLink to="/" className="navbar-brand">
							MKOS
						</NavLink>
						<button
							className="navbar-toggler"
							data-toggle="collapse"
							data-target="#navbarCollapse">
							<span className="navbar-toggler-icon" />
						</button>
						<div className="collapse navbar-collapse" id="navbarCollapse">
							<ul className="navbar-nav">
								<li className="nav-item px-2">
									<NavLink exact={true} to="/" className="nav-link">
										Home
									</NavLink>
								</li>
								<li className="nav-item px-2">
									<NavLink to="/tenants" className="nav-link">
										Tenants
									</NavLink>
								</li>
							</ul>
							<ul className="navbar-nav ml-auto">
								<li className="nav-item">
									<a href="#" className="nav-link">
										<i className="fas fa-user-times" /> Welcome, Admin
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		);
	}
}

export default Navbar;
