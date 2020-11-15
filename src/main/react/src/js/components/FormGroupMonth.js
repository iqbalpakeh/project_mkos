import React from "react";

const FormGroupMonth = ({ handleMonthChange, defaultMonth, title }) => {
	return (
		<div className="form-group">
			<label>{title}</label>
			<select
				className="form-control"
				onChange={handleMonthChange}
				defaultValue={defaultMonth}
			>
				<option value="January">January</option>
				<option value="February">February</option>
				<option value="March">March</option>
				<option value="May">May</option>
				<option value="June">June</option>
				<option value="July">July</option>
				<option value="August">August</option>
				<option value="September">September</option>
				<option value="October">October</option>
				<option value="November">November</option>
				<option value="December">December</option>
			</select>
		</div>
	);
};

export default FormGroupMonth;