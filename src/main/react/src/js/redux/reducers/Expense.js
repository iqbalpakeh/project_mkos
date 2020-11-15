import { ADD_EXPENSE } from "../Action";

const initState = {
	expenses: [],
};

export default function (state = initState, action) {
	switch (action.type) {
		case ADD_EXPENSE:
			return addExpense(state, action);
		default: {
			return state;
		}
	}

	function addExpense(state, action) {
		// Function just store the latest incomes from DB. Thus,
		// it's not store previous state.
		return {
			expenses: action.payload,
		};
	}
}
