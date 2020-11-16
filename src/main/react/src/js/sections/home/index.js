import React, { Component } from "react";
import { connect } from "react-redux";

import {
	fetchRevenuePayments,
	fetchExpensePayments,
	fetchIncomes,
	fetchExpenseTypes,
} from "../../Api";

import Header from "../../components/Header";
import Income from "./Income";
import Expense from "./Expense";

class Index extends Component {
	componentDidMount() {
		const filter = {
			year: "2020",
			startMonth: "09",
			endMonth: "11",
			dispatch: this.props.dispatch,
		};

		fetchRevenuePayments(filter);
		fetchExpensePayments(filter);
		fetchIncomes(filter);

		fetchExpenseTypes(this.props.dispatch);
	}

	render() {
		return (
			<div>
				<Header icon="fas fa-home" title="Home" />
				<Income />
				<Expense />
			</div>
		);
	}
}

export default connect(null, null)(Index);
