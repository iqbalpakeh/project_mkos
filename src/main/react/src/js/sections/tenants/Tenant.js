import React, { Component } from "react";
import { connect } from "react-redux";

import Table from "../../components/Table";

class Tenant extends Component {
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

	buildTableInput({ tenant }) {
		if (tenant.tenants.length > 0) {
			return {
				cardHeader: this.buildCardHeader(tenant),
				tableHeader: this.buildTableHeader(tenant),
				tableEntry: this.buildTableEntry(tenant),
			};
		} else {
			return { cardHeader: "Tenants", tableHeader: [], tableEntry: [] };
		}
	}

	buildCardHeader(tenant) {
		return "Tenants Now";
	}

	buildTableHeader(tenant) {
		return ["Name", "Phone", "Room", "Checkin"];
	}

	buildTableEntry(tenant) {
		const entry = [];
		tenant.tenants.forEach((element) => {
			const row = [];
			row.push(element.tenant.tenantName);
			row.push(element.tenant.tenantPhone);
			row.push(element.room);
			row.push(element.tenant.checkin);
			entry.push(row);
		});
		return entry;
	}
}

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(Tenant);
