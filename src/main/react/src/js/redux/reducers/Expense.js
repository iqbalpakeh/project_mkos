import { ADD_EXPENSE } from "../Action";

const initialState = {
	expenses: [],
};

export default function (state = initialState, action) {
	switch (action.type) {
		case ADD_EXPENSE:
			return addExpense(state, action);
		default: {
			return state;
		}
	}

	function addExpense(state, action) {
		// Funtion just store the latest rooms from DB. Thus,
		// it's not store previous state.
		return {
			expenses: action.payload,
		};
	}
}
