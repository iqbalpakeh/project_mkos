import React, { Component } from "react";

import Controller from "./controller";
import Header from "../../components/Header";
import Tenant from "./Tenant";
import TenantLog from "./TenantLog";

const Index = () => {
	return (
		<div>
			<Header icon="fas fa-users" title="Tenants" />
			<Controller />
			<Tenant />
			<TenantLog />
		</div>
	);
};

export default Index;
