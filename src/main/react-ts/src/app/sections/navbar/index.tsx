import { default as NavBrand } from "./nav-brand";
import { default as Collapsible } from "./collapsible";

const Component = () => {
	return (
		<div>
			<div className="navbar navbar-expand-sm navbar-dark bg-dark p-0">
				<div className="container">
					<NavBrand title="MKOS" />
					<Collapsible />
				</div>
			</div>
		</div>
	);
};

export default Component;
