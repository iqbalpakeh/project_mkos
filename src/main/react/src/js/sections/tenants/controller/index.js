import React from "react";

import AddTenant from "./AddTenant";

const index = () => {
	return (
		<div>
			<div className="py-4 mb-2">
				<div className="container">
					<div className="row">
						<div className="col-md-3 mb-2">
							<AddTenant />
						</div>
						<div className="col-md-3"></div>
					</div>
				</div>
			</div>
		</div>
	);
};

export default index;
