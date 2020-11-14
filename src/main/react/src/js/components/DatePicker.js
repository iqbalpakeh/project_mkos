import React, { useState } from "react";
import ReactDatePicker from "react-datepicker";

const DatePicker = () => {
	// https://reactdatepicker.com/
	// add missing style https://github.com/Hacker0x01/react-datepicker/issues/879
	//   Just use a tilde in front of the the path. Just like you import bootstrap from the node dependencies.
	//   Add this in your scss file import @import "~react-datepicker/dist/react-datepicker.css". This should work.

	const [startDate, setStartDate] = useState(new Date());

	return (
		<ReactDatePicker
			showMonthYearPicker
			dateFormat="MM/yyyy"
			selected={startDate}
			onChange={(date) => setStartDate(date)}
		/>
	);
};

export default DatePicker;
