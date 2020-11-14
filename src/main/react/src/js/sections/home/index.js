import React, { Component } from "react";
import { connect } from "react-redux";
import { fetchIncomeRange, fetchAllRoom, fetchAllExpense } from "../../Api";

import Header from "../../components/Header";
import Control from "./control";
import Income from "./Income";
import Expense from "./Expense";
import Revenue from "./Revenue";

class Index extends Component {
	componentDidMount() {
		fetchIncomeRange({
			year: "2020",
			startMonth: "09",
			endMonth: "11",
			dispatch: this.props.dispatch,
		});

		fetchAllRoom({
			dispatch: this.props.dispatch,
		});

		fetchAllExpense({
			dispatch: this.props.dispatch,
		});
	}

	render() {
		return (
			<div>
				<Header icon="fas fa-home" title="Home" />
				<Control />
				<Income />
				<Expense />
				<Revenue />
			</div>
		);
	}
}

export default connect(null, null)(Index);
