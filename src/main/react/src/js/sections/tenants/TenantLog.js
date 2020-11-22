import React, { Component } from "react";
import { connect } from "react-redux";

import Table from "../../components/Table";

class TenantLog extends Component {
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

	buildTableInput({ tenantLog }) {
		if (tenantLog.tenantLogs.length > 0) {
			return {
				cardHeader: this.buildCardHeader(tenantLog),
				tableHeader: this.buildTableHeader(tenantLog),
				tableEntry: this.buildTableEntry(tenantLog),
			};
		} else {
			return { cardHeader: "Tenants History", tableHeader: [], tableEntry: [] };
		}
	}

	buildCardHeader(tenantLog) {
		return "Tenants History";
	}

	buildTableHeader(tenantLog) {
		return ["Name", "Phone", "Room", "Checkin", "Checkout"];
	}

	buildTableEntry(tenantLog) {
		const entry = [];
		tenantLog.tenantLogs.forEach((element) => {
			const row = [];
			row.push(element.tenantLog.tenantName);
			row.push(element.tenantLog.tenantPhone);
			row.push(element.tenantLog.room);
			row.push(element.tenantLog.checkin);
			row.push(element.tenantLog.checkout);
			entry.push(row);
		});
		return entry;
	}
}

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(TenantLog);
