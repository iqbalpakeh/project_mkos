import { ADD_ROOM } from "../Action";

const initialState = {
	rooms: [],
};

export default function (state = initialState, action) {
	switch (action.type) {
		case ADD_ROOM:
			return addRoom(state, action);
		default: {
			return state;
		}
	}

	function addRoom(state, action) {
		// Funtion just store the latest rooms from DB. Thus,
		// it's not store previous state.
		return {
			rooms: action.payload,
		};
	}
}
