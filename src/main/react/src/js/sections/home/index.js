import React, { Component } from "react";

import Header from "../../components/Header";
import Income from "./Income";
import Expense from "./Expense";
import Revenue from "./Revenue";
import Controller from "./controller";

const Index = () => {
	return (
		<div>
			<Header icon="fas fa-home" title="Home" />
			<Controller />
			<Income />
			<Expense />
			<Revenue />
		</div>
	);
};

export default Index;
