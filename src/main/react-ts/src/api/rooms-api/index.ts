import axios from "axios";

/**
 * Get all rooms with GET /api/rooms
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
