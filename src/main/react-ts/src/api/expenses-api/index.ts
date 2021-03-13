import { AnyAction, Dispatch } from "redux";
import axios from "axios";

interface IInput {
	dispatch: Dispatch<AnyAction>;
}

export const getExpenses = ({ dispatch }: IInput) => {
	axios.get(`/api/expenses`).then(
		(response) => {
			console.log(response.data);
		},
		(error) => {
			console.log(error);
		}
	);
};
