import React, { Component } from "react";
import { connect } from "react-redux";

import Table from "../../components/Table";
import { getYear, getMonth } from "../../components/DateFormatter";

class Revenue extends Component {
	render() {
		const input = this.buildTableInput(this.props);
		return (
			<Table
				cardHeader={input.cardHeader}
				tableHeader={input.tableHeader}
				tableEntry={input.tableEntry}
			/>
		);
	}

	buildTableInput({ expense, expenseType }) {
		if (expense.expenses.length > 0) {
			return {
				cardHeader: this.buildCardHeader(expense),
				tableHeader: this.buildTableHeader(expense),
				tableEntry: this.buildTableEntry(expense, expenseType),
			};
		} else {
			return {
				cardHeader: "Monthly Revenue",
				tableHeader: [],
				tableEntry: [],
			};
		}
	}

	buildCardHeader(expense) {
		return `${getYear(expense.expenses[0].timestamp)} Monthly Revenue`;
	}

	buildTableHeader(expense) {
		return [];
	}

	buildTableEntry(expense, expenseType) {
		return [];
	}
}

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(Revenue);
