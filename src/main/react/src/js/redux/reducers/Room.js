import { ADD_ROOM } from "../Action";

const initState = {
	rooms: [],
};

export default function (state = initState, action) {
	switch (action.type) {
		case ADD_ROOM:
			return addRoom(state, action);
		default:
			return state;
	}

	function addRoom(state, action) {
		// Function just store the latest incomes from DB. Thus,
		// it's not store previous state.
		return {
			rooms: action.payload,
		};
	}
}
