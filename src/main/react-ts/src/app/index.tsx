import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { useEffect } from "react";

import { NavBar, Home, Tenants, Footer } from "./sections";
import { getRooms } from "api";

const Component = () => {
	useEffect(() => {
		getRooms();
	});

	return (
		<Router>
			<div className="d-flex flex-column min-vh-100">
				<NavBar />
				<div className="wrapper flex-grow-1">
					<Switch>
						<Route exact path="/">
							<Home />
						</Route>
						<Route path="/tenants">
							<Tenants />
						</Route>
					</Switch>
				</div>
				<Footer />
			</div>
		</Router>
	);
};

export default Component;
