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

	buildTableInput({ expense, expenseType }) {
		if (expense.expenses.length > 0) {
			return {
				cardHeader: this.buildCardHeader(expense),
				tableHeader: this.buildTableHeader(expense),
				tableEntry: this.buildTableEntry(expense, expenseType),
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
		const tableHeader = ["Expenses"];
		expense.expenses.map((element) => {
			tableHeader.push(getMonth(element.timestamp));
		});
		return tableHeader;
	}

	buildTableEntry(expense, expenseType) {
		const entry = [];
		expenseType.expenseTypes.map((element1) => {
			const row = [];
			row.push(element1.expense.expenseType);
			expense.expenses.map((element2) => {
				if (element2.expenses.length > 0) {
					element2.expenses.map((element3) => {
						if (element3.expenseType == element1.expense.expenseType) {
							row.push(element3.paymentAmount);
						}
					});
				} else {
					row.push(0);
				}
			});
			entry.push(row);
		});
		return entry;
	}
}

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(Expense);
