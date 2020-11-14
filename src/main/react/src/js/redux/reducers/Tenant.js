import { addTenant, ADD_TENANT } from "../Action";

const initialState = {
	tenants: [],
};

export default function (state = initialState, action) {
	switch (action.type) {
		case ADD_TENANT:
			return addTenant(state, action);
		default: {
			return state;
		}
	}

	function addTenant(state, action) {
		// Funtion just store the latest rooms from DB. Thus,
		// it's not store previous state.
		return {
			tenants: action.payload,
		};
	}
}
