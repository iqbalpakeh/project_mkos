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

	buildTableInput({ revenue, room }) {
		console.log(revenue);
		if (revenue.revenues.length > 0) {
			return {
				cardHeader: this.buildCardHeader(revenue),
				tableHeader: this.buildTableHeader(revenue),
				tableEntry: this.buildTableEntry(revenue, room),
			};
		} else {
			return {
				cardHeader: "Monthly Revenue",
				tableHeader: [],
				tableEntry: [],
			};
		}
	}

	buildCardHeader({ revenues }) {
		return `${getYear(revenues[0].timestamp)} Monthly Revenue`;
	}

	buildTableHeader({ revenues }) {
		const tableHeader = ["Rooms"];
		revenues.map((element) => {
			tableHeader.push(getMonth(element.timestamp));
		});
		return tableHeader;
	}

	buildTableEntry(expense, expenseType) {
		return [];
	}
}

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(Revenue);
