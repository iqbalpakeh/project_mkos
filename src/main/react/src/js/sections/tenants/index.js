import React, { Component } from "react";
import { connect } from "react-redux";

import { fetchTenants, fetchTenantLogs, fetchRooms } from "../../Api";

import Controller from "./controller";
import Header from "../../components/Header";
import Tenant from "./Tenant";
import TenantLog from "./TenantLog";

class Index extends Component {
	componentDidMount() {
		fetchTenants(this.props.dispatch);
		fetchTenantLogs(this.props.dispatch);
		fetchRooms(this.props.dispatch);
	}

	render() {
		return (
			<div>
				<Header icon="fas fa-users" title="Tenants" />
				<Controller />
				<Tenant />
				<TenantLog />
			</div>
		);
	}
}

export default connect(null, null)(Index);
