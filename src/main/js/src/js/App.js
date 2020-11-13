import React, { Component } from "react";
import { connect } from "react-redux";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Login from "./sections/Login";

class App extends Component {
	render() {
		return <Login />;
	}
}

export default App;
