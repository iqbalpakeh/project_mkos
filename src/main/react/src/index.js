import "jquery/dist/jquery.min.js";
import "bootstrap/dist/js/bootstrap.min.js";
import "./sass/custom.scss";

import React from "react";
import ReactDOM from "react-dom";

import App from "./js/App";

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
	<React.StrictMode>
		<App />
	</React.StrictMode>,
	document.getElementById("root")
);
