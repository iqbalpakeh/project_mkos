import React, { Component } from "react";
import { connect } from "react-redux";

import Table from "../../components/Table";
import { getYear, getMonth } from "../../components/DateFormatter";

class Expense extends Component {
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

	buildTableInput({ expense }) {
		if (expense.expenses.length > 0) {
			return {
				cardHeader: this.buildCardHeader(expense),
				tableHeader: this.buildTableHeader(expense),
				tableEntry: this.buildTableEntry(expense),
			};
		} else {
			return {
				cardHeader: "Monthly Expense",
				tableHeader: [],
				tableEntry: [],
			};
		}
	}

	buildCardHeader(expense) {
		return `${getYear(expense.expenses[0].timestamp)} Monthly Expense`;
	}

	buildTableHeader(expense) {
		let tableHeader = ["Expenses"];
		expense.expenses.map((element) => {
			tableHeader.push(getMonth(element.timestamp));
		});
		return tableHeader;
	}

	buildTableEntry(expense) {
		return [];
	}
}

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(Expense);
