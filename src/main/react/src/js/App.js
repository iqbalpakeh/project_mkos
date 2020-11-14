import React, { Component } from "react";
import { connect } from "react-redux";
import axios from "axios";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Login from "./sections/Login";

class App extends Component {
	componentDidMount() {
		axios({
			method: "GET",
			url: `/api/tenants`,
		}).then(
			(response) => {
				console.log(response.data);
			},
			(error) => console.log(error)
		);
	}

	render() {
		return (
			<div>
				<h1>Hello from React v3</h1>
				<form action="/logout" method="post">
					<input type="submit" value="Sign Out"></input>
				</form>
			</div>
		);
	}
}

export default App;
