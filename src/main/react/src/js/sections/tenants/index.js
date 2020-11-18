import React, { Component } from "react";

import { fetchTenants } from "../../Api";

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
				<Tenant />
			</div>
		);
	}
}

export default Index;
