import { Header } from "app/reusable-components";

import { default as Controller } from "./controller";

const Component = () => {
	return (
		<div>
			<Header icon="fas fa-home" title="Home" />
			<Controller />
		</div>
	);
};

export default Component;
