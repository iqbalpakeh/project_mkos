import React, { Component } from "react";

import SetFilter from "./SetFilter";
import AddPayment from "./AddPayment";

class Index extends Component {
	constructor(props) {
		super(props);
	}

	render() {
		return (
			<div>
				<div className="py-4 mb-2">
					<div className="container">
						<div className="row">
							<div className="col-md-3 mb-2">
								<AddPayment />
							</div>
							<div className="col-md-3">
								<SetFilter />
							</div>
						</div>
					</div>
				</div>
			</div>
		);
	}
}

export default Index;
