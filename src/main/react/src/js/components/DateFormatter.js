export const getYear = (timestamp) => {
	return timestamp.toString().substring(0, 4);
};

export const getMonth = (timestamp) => {
	const month = timestamp.toString().substring(4, 6);
	switch (month) {
		case "01":
			return "January";
		case "02":
			return "February";
		case "03":
			return "March";
		case "04":
			return "April";
		case "05":
			return "May";
		case "06":
			return "June";
		case "07":
			return "July";
		case "08":
			return "August";
		case "09":
			return "September";
		case "10":
			return "October";
		case "11":
			return "November";
		case "12":
			return "December";
	}
};

export const getMonthNumber = (month) => {
	switch (month) {
		case "January":
			return "01";
		case "February":
			return "02";
		case "March":
			return "03";
		case "April":
			return "04";
		case "May":
			return "05";
		case "June":
			return "06";
		case "July":
			return "07";
		case "August":
			return "08";
		case "September":
			return "09";
		case "October":
			return "10";
		case "November":
			return "11";
		case "December":
			return "12";
	}
};

export const getFilterYear = () => {
	const date = new Date();
	return `${date.getFullYear()}`;
};

export const getFilterStartMonth = () => {
	const date = new Date();
	const month = date.getMonth() + 1;
	return month > 9 ? `${month}` : `0${month}`;
};

export const getFilterEndMonth = (delta) => {
	const date = new Date();
	const month = date.getMonth() + 1;
	if (month + delta < 12) {
		return month > 9 ? `${month + delta}` : `0${month + delta}`;
	} else {
		return month > 9 ? `${month}` : `0${month}`;
	}
};
