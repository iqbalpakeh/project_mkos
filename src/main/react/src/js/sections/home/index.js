import React, { Component } from "react";

import { fetchIncomePayments, fetchExpensePayments } from "../../Api";
import Header from "../../components/Header";

class Index extends Component {
	componentDidMount() {
		fetchIncomePayments({
			year: "2020",
			startMonth: "09",
			endMonth: "11",
		});

		fetchExpensePayments({
			year: "2020",
			startMonth: "09",
			endMonth: "11",
		});
	}

	render() {
		return (
			<div>
				<Header icon="fas fa-home" title="Home" />
			</div>
		);
	}
}

export default Index;
