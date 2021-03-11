import { default as NavLink } from "./nav-link";
import { default as Login } from "./login";

const Component = () => {
	return (
		<div className="collapse navbar-collapse" id="navbarCollapse">
			<ul className="navbar-nav">
				<li className="nav-item px-2">
					<NavLink title="Home" destination="/" exact={true} />
				</li>
				<li className="nav-item px-2">
					<NavLink title="Tenants" destination="/tenants" exact={false} />
				</li>
			</ul>
			<ul className="navbar-nav ml-auto">
				<li className="nav-item">
					<Login />
				</li>
			</ul>
		</div>
	);
};

export default Component;
