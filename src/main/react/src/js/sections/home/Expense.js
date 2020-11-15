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

	buildTableInput(input) {
		console.log(input);
		return {
			cardHeader: "Monthly Expense",
			tableHeader: [],
			tableEntry: [],
		};
	}
}

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(Expense);
