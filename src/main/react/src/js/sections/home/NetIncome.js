import React, { Component } from "react";
import { connect } from "react-redux";

import Table from "../../components/Table";
import { getYear, getMonth } from "../../components/DateFormatter";

class NetIncome extends Component {
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

	buildTableInput({ netIncome }) {
		if (netIncome.netIncomes.length > 0) {
			return {
				cardHeader: this.buildCardHeader(netIncome),
				tableHeader: this.buildTableHeader(netIncome),
				tableEntry: this.buildTableEntry(netIncome),
			};
		} else {
			return {
				cardHeader: "Monthly Income",
				tableHeader: [],
				tableEntry: [],
			};
		}
	}

	buildCardHeader(netIncome) {
		return `${getYear(
			netIncome.netIncomes[0].netIncome.timestamp
		)} Monthly Income`;
	}

	buildTableHeader(netIncome) {
		let tableHeader = ["Items"];
		netIncome.netIncomes.map((netIncome) => {
			tableHeader.push(getMonth(netIncome.netIncome.timestamp));
		});
		return tableHeader;
	}

	buildTableEntry(netIncome) {
		let entries = [];
		let valNetIncome = ["Total Income"]; // rename net income to be income
		let totalIncome = ["Total Revenue"]; // rename income to be revenue
		let totalExpense = ["Total Expense"];

		console.log(netIncome);
		netIncome.netIncomes.map((element) => {
			valNetIncome.push(element.netIncome.netIncome);
			totalIncome.push(element.netIncome.totalIncome);
			totalExpense.push(element.netIncome.totalExpense);
		});

		entries.push(totalIncome);
		entries.push(totalExpense);
		entries.push(valNetIncome);

		return entries;
	}
}

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(NetIncome);
