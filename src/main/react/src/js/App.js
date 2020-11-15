import React, { Component } from "react";
import { connect } from "react-redux";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Navbar from "./sections/Navbar";
import Footer from "./sections/Footer";

import Home from "./sections/home";
import Tenants from "./sections/tenants";

class App extends Component {
	render() {
		return <h1>Hello from React</h1>;
	}
}

export default connect(null, null)(App);
