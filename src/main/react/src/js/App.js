import React, { Component } from "react";
import { connect } from "react-redux";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Navbar from "./sections/Navbar";
import Footer from "./sections/Footer";

import Home from "./sections/home";
import Tenants from "./sections/tenants";

class App extends Component {
	render() {
		return (
			<Router>
				<div className="d-flex flex-column min-vh-100">
					<Navbar />
					<div className="wrapper flex-grow-1">
						<Switch>
							<Route exact path="/">
								<Home />
							</Route>
							<Route path="/tenants">
								<Tenants />
							</Route>
						</Switch>
					</div>
					<Footer />
				</div>
			</Router>
		);
	}
}

export default connect(null, null)(App);
