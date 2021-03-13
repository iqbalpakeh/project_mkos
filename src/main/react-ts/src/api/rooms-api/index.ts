import axios from "axios";

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
