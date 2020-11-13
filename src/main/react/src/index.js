import "jquery/dist/jquery.min.js";
import "bootstrap/dist/js/bootstrap.min.js";
import "./sass/custom.scss";

import React from "react";
import ReactDOM from "react-dom";

import App from "./js/App";

ReactDOM.render(
	<React.StrictMode>
		<App />
	</React.StrictMode>,
	document.getElementById("root")
);
