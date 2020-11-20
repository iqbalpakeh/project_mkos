import React, { Component } from "react";
import { connect } from "react-redux";

import {
	fetchRevenuePayments,
	fetchExpensePayments,
	fetchIncomes,
	fetchExpenseTypes,
	fetchRooms,
} from "../../Api";

import Header from "../../components/Header";
import Income from "./Income";
import Expense from "./Expense";
import Revenue from "./Revenue";
import Controller from "./controller";

class Index extends Component {
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
	}

	render() {
		return (
			<div>
				<Header icon="fas fa-home" title="Home" />
				<Controller />
				<Income />
				<Expense />
				<Revenue />
			</div>
		);
	}
}

export default connect(null, null)(Index);
