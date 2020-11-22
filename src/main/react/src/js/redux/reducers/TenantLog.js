import { ADD_TENANT_LOG } from "../Action";

const initState = {
	tenantLogs: [],
};

export default function (state = initState, action) {
	switch (action.type) {
		case ADD_TENANT_LOG:
			return addTenantLog(state, action);
		default:
			return state;
	}

	function addTenantLog(state, action) {
		// Function just store the latest incomes from DB. Thus,
		// it's not store previous state.
		return {
			tenantLogs: action.payload,
		};
	}
}
