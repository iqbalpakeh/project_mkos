import React, { Component } from "react";
import { connect } from "react-redux";
import { fetchAllTenants, fetchAllRoom } from "../../Api";

import Header from "../../components/Header";
import Tenant from "./Tenant";
import Control from "./control";

class Index extends Component {
	componentDidMount() {
		fetchAllTenants({ dispatch: this.props.dispatch });
		fetchAllRoom({ dispatch: this.props.dispatch });
	}

	render() {
		return (
			<div>
				<Header icon="fas fa-users" title="Tenants" />
				<Control />
				<Tenant />
			</div>
		);
	}
}

export default connect(null, null)(Index);
