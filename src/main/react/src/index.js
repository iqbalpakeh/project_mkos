import "jquery/dist/jquery.min.js";
import "bootstrap/dist/js/bootstrap.min.js";
import "./sass/custom.scss";

import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";

import App from "./js/App";
import store from "./js/redux/Store";

/**
 * Todos:
 * - Implement checkout function
 * - Implement automated regression test
 * - Implement user input validation
 * - Implement user input default value
 * - Implement login/logout page
 * - Implement UI if no entry added [done]
 * - Improve the ui on mobile
 */

ReactDOM.render(
	<Provider store={store}>
		<React.StrictMode>
			<App />
		</React.StrictMode>
	</Provider>,
	document.getElementById("root")
);
