import { ADD_INCOME } from "../Action";

const initState = {
	incomes: [],
};

export default function (state = initState, action) {
	switch (action.type) {
		case ADD_INCOME:
			return addIncome(state, action);
		default: {
			return state;
		}
	}

	function addIncome(state, action) {
		// Function just store the latest incomes from DB. Thus,
		// it's not store previous state.
		return {
			incomes: action.payload,
		};
	}
}
