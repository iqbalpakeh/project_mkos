import React, { Component } from "react";
import { connect } from "react-redux";

import Table from "../../components/Table";
import { getYear, getMonth } from "../../components/DateFormatter";

class Income extends Component {
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

	buildTableInput({ income }) {
		if (income.incomes.length > 0) {
			return {
				cardHeader: this.buildCardHeader(income),
				tableHeader: this.buildTableHeader(income),
				tableEntry: this.buildTableEntry(income),
			};
		} else {
			return {
				cardHeader: "Monthly Income",
				tableHeader: [],
				tableEntry: [],
			};
		}
	}

	buildCardHeader(income) {
		return `${getYear(income.incomes[0].income.timestamp)} Monthly Income`;
	}

	buildTableHeader(income) {
		let tableHeader = ["Items"];
		income.incomes.map((income) => {
			tableHeader.push(getMonth(income.income.timestamp));
		});
		return tableHeader;
	}

	buildTableEntry(income) {
		let entries = [];
		let totalRevenue = ["Total Revenue"];
		let totalExpense = ["Total Expense"];
		let totalIncome = ["Total Income"];

		console.log(income);
		income.incomes.map((element) => {
			totalRevenue.push(element.income.totalRevenue);
			totalExpense.push(element.income.totalExpense);
			totalIncome.push(element.income.totalIncome);
		});

		entries.push(totalRevenue);
		entries.push(totalExpense);
		entries.push(totalIncome);

		return entries;
	}
}

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(Income);
