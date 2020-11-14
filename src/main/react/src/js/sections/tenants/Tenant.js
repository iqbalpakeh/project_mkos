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
		return "Tenants";
	}

	buildTableHeader(tenant) {
		return ["Name", "Phone", "Room", "Checkin", "Checkout"];
	}

	buildTableEntry(tenant) {
		let entry = [];
		tenant.tenants.forEach((eachTenant) => {
			let row = [];
			row.push(eachTenant.name);
			row.push(eachTenant.phone);
			row.push(eachTenant.room);
			row.push(eachTenant.startDate);
			row.push(eachTenant.endDate == null ? "--" : eachTenant.endDate);
			entry.push(row);
		});
		return entry;
	}
}

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(Tenant);
