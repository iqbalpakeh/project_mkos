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

	buildTableInput({ income, room }) {
		if (income.allIncomes.length > 0 && room.rooms.length > 0) {
			return {
				cardHeader: this.buildCardHeader(income),
				tableHeader: this.buildTableHeader(income),
				tableEntry: this.buildTableEntry(room, income),
			};
		} else {
			return { cardHeader: "Monthly Revenue", tableHeader: [], tableEntry: [] };
		}
	}

	buildCardHeader(income) {
		return `${getYear(income.allIncomes[0].incomeDate)} Monthly Revenue`;
	}

	buildTableHeader(income) {
		let tableHeader = ["Room", "Names", "Phone"];
		income.allIncomes.map((monthlyIncome) => {
			tableHeader.push(getMonth(monthlyIncome.incomeDate));
		});
		return tableHeader;
	}

	buildTableEntry(room, income) {
		let entry = [];
		room.rooms.forEach((eachRoom) => {
			let row = [];

			row.push(eachRoom.roomNumber);

			eachRoom.tenant != null
				? row.push(eachRoom.tenant.name)
				: row.push("---");

			eachRoom.tenant != null
				? row.push(eachRoom.tenant.phone)
				: row.push("---");

			income.allIncomes.forEach((eachIncome) => {
				if (eachRoom.payments.length != 0) {
					// show existing payment
					eachRoom.payments.forEach((roomPayment) => {
						if (eachIncome.incomeDate == roomPayment.paymentDate) {
							row.push(roomPayment.amount);
						}
					});
					// show non-existing payment
					if (
						!eachRoom.payments.some(
							(element) => element.paymentDate == eachIncome.incomeDate
						)
					) {
						row.push(0);
					}
				} else {
					// show empty room
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

export default connect(mapStateToProps)(Revenue);
