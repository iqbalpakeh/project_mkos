import React, { Component } from "react";
import { connect } from "react-redux";

import Table from "../../components/Table";
import { getYear, getMonth } from "../../components/DateFormatter";

class Income extends Component {
	render() {
		const input = this.buildTableInput(this.props.income);
		return (
			<Table
				cardHeader={input.cardHeader}
				tableHeader={input.tableHeader}
				tableEntry={input.tableEntry}
			/>
		);
	}

	buildTableInput(income) {
		if (income.allIncomes.length > 0) {
			return {
				cardHeader: this.buildCardHeader(income),
				tableHeader: this.buildTableHeader(income),
				tableEntry: this.buildTableEntry(income),
			};
		} else {
			return { cardHeader: "Monthly Income", tableHeader: [], tableEntry: [] };
		}
	}

	buildCardHeader(income) {
		return `${getYear(income.allIncomes[0].incomeDate)} Monthly Income`;
	}

	buildTableHeader(income) {
		let tableHeader = ["Items"];
		income.allIncomes.map((monthlyIncome) => {
			tableHeader.push(getMonth(monthlyIncome.incomeDate));
		});
		return tableHeader;
	}

	buildTableEntry(income) {
		let entries = [];
		let totalRevenue = ["Total Revenue"];
		let totalExpense = ["Total Expense"];
		let totalIncome = ["Total Income"];

		income.allIncomes.map((monthlyIncome) => {
			totalRevenue.push(monthlyIncome.totalRevenue);
			totalExpense.push(monthlyIncome.totalExpense);
			totalIncome.push(monthlyIncome.totalIncome);
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
