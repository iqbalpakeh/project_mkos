import { default as NavBrand } from "./nav-brand";
import { default as CollapseButton } from "./collapse-button";
import { default as CollapseLinks } from "./collapse-links";

const Navbar = () => {
	return (
		<div>
			<div className="navbar navbar-expand-sm navbar-dark bg-dark p-0">
				<div className="container">
					<NavBrand title="MKOS" />
					<CollapseButton />
					<CollapseLinks />
				</div>
			</div>
		</div>
	);
};

export default Navbar;
