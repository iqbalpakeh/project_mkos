import { NavLink } from "react-router-dom";

interface IInput {
	title: string;
}

const Component = ({ title }: IInput) => {
	return (
		<NavLink to="/" className="navbar-brand">
			{title}
		</NavLink>
	);
};

export default Component;
