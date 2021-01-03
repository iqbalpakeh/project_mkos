import React from "react";

const FormGroupInput = ({ title, onChange, initialValue, type }) => {
	return (
		<div className="form-group">
			<label>{title}</label>
			<input
				type={type}
				className="form-control"
				onChange={onChange}
				value={initialValue}></input>
		</div>
	);
};

export default FormGroupInput;
