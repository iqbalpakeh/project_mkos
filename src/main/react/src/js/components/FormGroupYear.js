import React from "react";

const FormGroupYear = ({ handleYearChange, initialYear }) => {
	var years = [];
	years.push(parseInt(initialYear) - 1);
	years.push(parseInt(initialYear));
	years.push(parseInt(initialYear) + 1);

	var options = years.map((year) => (
		<option key={year} value={year.toString()}>
			{year}
		</option>
	));

	return (
		<div className="form-group">
			<label>Year</label>
			<select
				className="form-control"
				onChange={handleYearChange}
				value={initialYear}>
				{options}
			</select>
		</div>
	);
};

export default FormGroupYear;
