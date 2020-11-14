import React, { Component } from "react";

import AddTenant from "./AddTenant";
import Checkout from "./Checkout";

class Index extends Component {
	render() {
		return (
			<div>
				<div className="py-4 mb-2">
					<div className="container">
						<div className="row">
							<div className="col-md-3 mb-2">
								<AddTenant />
							</div>
							<div className="col-md-3 mb-2">
								<Checkout />
							</div>
						</div>
					</div>
				</div>
			</div>
		);
	}
}

export default Index;
