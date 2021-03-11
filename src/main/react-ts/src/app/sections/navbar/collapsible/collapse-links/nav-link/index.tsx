import { NavLink } from "react-router-dom";

interface IInput {
	title: string;
	destination: string;
	exact: boolean;
}

const Component = ({ title, destination, exact }: IInput) => {
	return (
		<NavLink exact={exact} to={destination} className="nav-link">
			{title}
		</NavLink>
	);
};

export default Component;
