import { AnyAction } from "redux";

import { ITenant } from "../tenants-store";

// ----------------------
// Interfaces
// ----------------------

const ADD_ROOM = "ADD_ROOM";
const CLEAR_ALL_ROOMS = "CLEAR_ALL_ROOMS";

export interface IRoom {
	roomNumber: string;
	roomRate: number;
	roomInformation: string;
	tenant?: ITenant;
}

interface IAddRoomAction {
	type: string;
	payload: IRoom;
}

interface IClearAllRoomsAction {
	type: string;
}

// ----------------------
// Actions
// ----------------------

export const addRoomAction = ({
	roomNumber,
	roomRate,
	roomInformation,
	tenant,
}: IRoom): IAddRoomAction => {
	return {
		type: ADD_ROOM,
		payload: {
			roomNumber,
			roomRate,
			roomInformation,
			tenant,
		},
	};
};

export const clearAllRoomsAction = (): IClearAllRoomsAction => {
	return {
		type: CLEAR_ALL_ROOMS,
	};
};

// ----------------------
// Reducer
// ----------------------

export const roomReducer = (
	state: IRoom[] = [],
	action: AnyAction
): IRoom[] => {
	switch (action.type) {
		case ADD_ROOM:
			return [...state, action.payload];
		case CLEAR_ALL_ROOMS:
			return [];
		default:
			return state;
	}
};
