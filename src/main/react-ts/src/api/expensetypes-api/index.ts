import { AnyAction, Dispatch } from "redux";
import axios from "axios";

import { addExpenseTypeAction, clearAllExpenseTypesAction } from "redux-store";

// -------------------------------------------------------------------------------
// This function can be improved by first building the array of expenseTypes
// and then call the dispatch function to reduce number of dispatch function call.
// At the end, it will reduce rendering
// -------------------------------------------------------------------------------

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
