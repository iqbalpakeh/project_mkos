import React, { Component } from "react";
import { connect } from "react-redux";

import { fetchTenants } from "../../Api";

import Controller from "./controller";
import Header from "../../components/Header";
import Tenant from "./Tenant";

class Index extends Component {
	componentDidMount() {
		fetchTenants(this.props.dispatch);
	}

	render() {
		return (
			<div>
				<Header icon="fas fa-users" title="Tenants" />
				<Controller />
				<Tenant />
			</div>
		);
	}
}

export default connect(null, null)(Index);
