import "jquery/dist/jquery.min.js";
import "bootstrap/dist/js/bootstrap.min.js";
import "./sass/custom.scss";

import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";

import App from "./js/App";
import Store from "./js/redux/Store";

ReactDOM.render(
	<Provider store={Store}>
		<React.StrictMode>
			<App />
		</React.StrictMode>
	</Provider>,
	document.getElementById("root")
);
