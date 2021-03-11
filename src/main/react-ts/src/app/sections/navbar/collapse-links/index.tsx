import { default as NavLink } from "./nav-link";

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
					<a href="#" className="nav-link">
						<i className="fas fa-user-times" /> Welcome, Admin
					</a>
				</li>
			</ul>
		</div>
	);
};

export default Component;
