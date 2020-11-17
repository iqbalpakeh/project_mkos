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

	buildTableEntry(revenue, room) {
		const entry = [];
		room.rooms.map((element1) => {
			const row = [];
			row.push(`Room ${element1.room.roomNumber}`);
			revenue.revenues.map((element2) => {
				// If room number is on the payment list
				element2.revenuePayments.map((element3) => {
					if (element1.room.roomNumber == element3.roomNumber) {
						row.push(element3.paymentAmount);
					}
				});
				// If room number is not on the payment list
				if (
					!element2.revenuePayments.some(
						(element2) => element2.roomNumber == element1.room.roomNumber
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

export default connect(mapStateToProps)(Revenue);
