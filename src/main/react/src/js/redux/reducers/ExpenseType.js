import { ADD_EXPENSE_TYPE } from "../Action";

const initState = {
	expenseTypes: [],
};

export default function (state = initState, action) {
	switch (action.type) {
		case ADD_EXPENSE_TYPE:
			return addExpenseType(state, action);
		default:
			return state;
	}

	function addExpenseType(state, action) {
		// Function just store the latest incomes from DB. Thus,
		// it's not store previous state.
		return {
			expenseTypes: action.payload,
		};
	}
}
