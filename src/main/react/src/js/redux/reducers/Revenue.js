import { ADD_REVENUE } from "../Action";

const initState = {
	revenues: [],
};

export default function (state = initState, action) {
	switch (action.type) {
		case ADD_REVENUE:
			return;
		default:
			return state;
	}

	function addRevenue(state, action) {
		// Function just store the latest incomes from DB. Thus,
		// it's not store previous state.
		return {
			revenues: action.payload,
		};
	}
}
