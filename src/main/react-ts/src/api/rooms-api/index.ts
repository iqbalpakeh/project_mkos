import { AnyAction, Dispatch } from "redux";
import axios from "axios";

import { addRoomAction, clearAllRoomsAction } from "redux-store";

export const getRooms = (dispatch: Dispatch<AnyAction>) => {
	axios.get(`/api/rooms`).then(
		(response) => {
			const datas = response.data as Array<any>;
			dispatch(clearAllRoomsAction());
			datas.forEach((data) => {
				dispatch(
					addRoomAction({
						roomNumber: data.room.roomNumber,
						roomRate: data.room.roomRate,
						roomInformation: data.room.roomInformation,
						tenant: data.room.tenant,
					})
				);
			});
		},
		(error) => {
			console.log(error);
		}
	);
};
