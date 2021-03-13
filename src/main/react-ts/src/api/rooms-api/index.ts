import axios from "axios";

/**
 * Rest Api call with GET /api/rooms
 */
export const getRooms = () => {
	axios.get(`/api/rooms`).then(
		(response) => {
			console.log(response.data);
		},
		(error) => {
			console.log(error);
		}
	);
};
