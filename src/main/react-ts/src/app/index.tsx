import { BrowserRouter as Router } from "react-router-dom";

import { default as Navbar } from "./sections/navbar";

const app = () => {
	return (
		<Router>
			<Navbar />
		</Router>
	);
};

export default app;
