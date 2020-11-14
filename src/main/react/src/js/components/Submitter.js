import React from "react";

const Submitter = ({ handleSubmitClick }) => {
	return (
		<div className="modal-footer">
			<button
				className="btn btn-primary"
				data-dismiss="modal"
				onClick={handleSubmitClick}
			>
				Submit
			</button>
		</div>
	);
};

export default Submitter;
