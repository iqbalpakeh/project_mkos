import React, { Component } from "react";

import Pagination from "./Pagination";

class Table extends Component {
	render() {
		const { cardHeader, tableHeader, tableEntry } = this.props;
		return (
			<section className="mb-4">
				<div className="container">
					<div className="row">
						<div className="col">
							<div className="card">
								<div className="card-header">
									<h4>{cardHeader}</h4>
								</div>
								<table className="table table-striped mb-0">
									<thead className="thead-dark">
										<tr>
											{tableHeader.map((column, index) => {
												return <th key={index}>{column}</th>;
											})}
										</tr>
									</thead>
									<tbody>
										{tableEntry.map((entry, index) => {
											return (
												<tr key={index}>
													{entry.map((data, index) => {
														return (
															<td key={index}>
																<p className="text-left my-2">{data}</p>
															</td>
														);
													})}
												</tr>
											);
										})}
									</tbody>
								</table>
								{/*<Pagination />*/}
							</div>
						</div>
					</div>
				</div>
			</section>
		);
	}
}

export default Table;
