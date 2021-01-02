import React from "react";

const FormGroupYear = ({ handleYearChange, defaultYear }) => {
	var years = [];
	years.push(parseInt(defaultYear) - 1);
	years.push(parseInt(defaultYear));
	years.push(parseInt(defaultYear) + 1);

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
				defaultValue={defaultYear}>
				{options}
			</select>
		</div>
	);
};

export default FormGroupYear;
