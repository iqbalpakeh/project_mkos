import React from "react";

const Pagination = () => {
	return (
		<div className="ml-4">
			<ul className="pagination">
				<li className="page-item disabled">
					<a href="#" className="page-link">
						Previous
					</a>
				</li>
				<li className="page-item active">
					<a href="#" className="page-link">
						1
					</a>
				</li>
				<li className="page-item">
					<a href="#" className="page-link">
						2
					</a>
				</li>
				<li className="page-item">
					<a href="#" className="page-link">
						3
					</a>
				</li>
				<li className="page-item">
					<a href="#" className="page-link">
						Next
					</a>
				</li>
			</ul>
		</div>
	);
};

export default Pagination;
