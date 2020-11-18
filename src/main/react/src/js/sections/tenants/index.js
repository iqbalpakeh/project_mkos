import React, { Component } from "react";

import Header from "../../components/Header";
import Tenant from "./Tenant";

class Index extends Component {
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
