import React, { Component } from "react";
import { connect } from "react-redux";

import {
	fetchIncomePayments,
	fetchExpensePayments,
	fetchNetIncomes,
} from "../../Api";

import Header from "../../components/Header";
import NetIncome from "./NetIncome";

class Index extends Component {
	componentDidMount() {
		const filter = {
			year: "2020",
			startMonth: "09",
			endMonth: "11",
			dispatch: this.props.dispatch,
		};

		fetchIncomePayments(filter);
		fetchExpensePayments(filter);
		fetchNetIncomes(filter);
	}

	render() {
		return (
			<div>
				<Header icon="fas fa-home" title="Home" />
				<NetIncome />
			</div>
		);
	}
}

export default connect(null, null)(Index);
