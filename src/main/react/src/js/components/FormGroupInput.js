import React from "react";

const FormGroupInput = ({ title, onChange, defaultValue, type }) => {
	return (
		<div className="form-group">
			<label>{title}</label>
			<input
				type={type}
				className="form-control"
				onChange={onChange}
				defaultValue={defaultValue}
			></input>
		</div>
	);
};

export default FormGroupInput;
