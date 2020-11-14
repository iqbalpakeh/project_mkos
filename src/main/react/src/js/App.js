import React, { Component } from "react";
import { connect } from "react-redux";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Login from "./sections/Login";

class App extends Component {
	render() {
		return (
			<div>
				<h1>Hello from React</h1>
				<form action="/logout" method="post">
					<input type="submit" value="Sign Out"></input>
				</form>
			</div>
		);
	}
}

export default App;
