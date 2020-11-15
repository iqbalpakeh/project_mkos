import { ADD_NETINCOME } from "../Action";

const initState = {
	netIncomes: [],
};

export default function (state = initState, action) {
	switch (action.type) {
		case ADD_NETINCOME:
			return addNetIncome(state, action);
		default: {
			return state;
		}
	}

	function addNetIncome(state, action) {
		// Function just store the latest incomes from DB. Thus,
		// it's not store previous state.
		return {
			netIncomes: action.payload,
		};
	}
}
