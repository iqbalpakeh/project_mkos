import { AnyAction, Dispatch } from "redux";
import axios from "axios";

import { addExpenseTypeAction, clearAllExpenseTypesAction } from "redux-store";

export const getExpenseTypes = (dispatch: Dispatch<AnyAction>) => {
	axios.get(`/api/expenses`).then(
		(response) => {
			const datas = response.data as Array<any>;
			dispatch(clearAllExpenseTypesAction());
			datas.forEach((data) => {
				dispatch(
					addExpenseTypeAction({
						expenseType: data.expense.expenseType,
						expenseInformation: data.expense.expenseInformation,
					})
				);
			});
		},
		(error) => {
			console.log(error);
		}
	);
};
