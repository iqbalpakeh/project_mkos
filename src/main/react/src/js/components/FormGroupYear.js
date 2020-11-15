import React from "react";

const FormGroupYear = ({ handleYearChange, defaultYear }) => {
	return (
		<div className="form-group">
			<label>Year</label>
			<select
				className="form-control"
				onChange={handleYearChange}
				defaultValue={defaultYear}
			>
				<option value="2020">2020</option>
				<option value="2021">2021</option>
				<option value="2022">2022</option>
				<option value="2023">2023</option>
				<option value="2024">2024</option>
				<option value="2025">2025</option>
			</select>
		</div>
	);
};

export default FormGroupYear;
