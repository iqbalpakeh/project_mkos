import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";

import "jquery/dist/jquery.min.js";
import "bootstrap/dist/js/bootstrap.min.js";
import "sass/custom.scss";

import { default as App } from "app";
import { store } from "redux-store";

ReactDOM.render(
	<React.StrictMode>
		<Provider store={store}>
			<App />
		</Provider>
	</React.StrictMode>,
	document.getElementById("root")
);
