import { ADD_TENANT } from "../Action";

const initState = {
	tenants: [],
};

export default function (state = initState, action) {
	switch (action.type) {
		case ADD_TENANT:
			return addTenant(state, action);
		default:
			return state;
	}

	function addTenant(state, action) {
		// Function just store the latest incomes from DB. Thus,
		// it's not store previous state.
		return {
			tenants: action.payload,
		};
	}
}
