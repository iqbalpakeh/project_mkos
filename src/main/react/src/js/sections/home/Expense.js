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

	buildTableInput({ income, expense }) {
		if (income.allIncomes.length > 0 && expense.expenses.length > 0) {
			return {
				cardHeader: this.buildCardHeader(income),
				tableHeader: this.buildTableHeader(income),
				tableEntry: this.buildTableEntry(expense, income),
			};
		} else {
			return { cardHeader: "Monthly Expense", tableHeader: [], tableEntry: [] };
		}
	}

	buildCardHeader(income) {
		return `${getYear(income.allIncomes[0].incomeDate)} Monthly Expense`;
	}

	buildTableHeader(income) {
		let tableHeader = ["Expenses"];
		income.allIncomes.map((monthlyIncome) => {
			tableHeader.push(getMonth(monthlyIncome.incomeDate));
		});
		return tableHeader;
	}

	buildTableEntry(expense, income) {
		let entry = [];
		expense.expenses.forEach((eachExpense) => {
			let row = [];
			row.push(eachExpense.expenseType);
			income.allIncomes.forEach((eachIncome) => {
				// show existing payment
				eachExpense.payments.forEach((eachExpensePayment) => {
					if (eachIncome.incomeDate == eachExpensePayment.paymentDate) {
						row.push(eachExpensePayment.amount);
					}
				});
				// show non-existing payment
				if (
					!eachExpense.payments.some(
						(element) => element.paymentDate == eachIncome.incomeDate
					)
				) {
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
