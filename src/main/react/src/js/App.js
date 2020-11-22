import React, { Component } from "react";
import { connect } from "react-redux";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import {
	fetchTenants,
	fetchTenantLogs,
	fetchRooms,
	fetchRevenuePayments,
	fetchExpensePayments,
	fetchIncomes,
	fetchExpenseTypes,
} from "./Api";

import Navbar from "./sections/Navbar";
import Home from "./sections/home";
import Tenants from "./sections/tenants";
import Footer from "./sections/Footer";

// Bug
// 1. Non-initilized data on ui controller
// 2. Non-responsize redux

class App extends Component {
	componentDidMount() {
		const filter = {
			year: "2020",
			startMonth: "09",
			endMonth: "10",
			dispatch: this.props.dispatch,
		};

		fetchRevenuePayments(filter);
		fetchExpensePayments(filter);
		fetchIncomes(filter);

		fetchExpenseTypes(this.props.dispatch);
		fetchRooms(this.props.dispatch);
		fetchTenants(this.props.dispatch);
		fetchTenantLogs(this.props.dispatch);
	}

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
