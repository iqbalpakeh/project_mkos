import React from "react";

import Table from "../components/Table";

class Sample extends React.Component {
	render() {
		const input = {
			cardHeader: "2019 Monthly Income",
			tableHeader: ["Items", "September", "October", "November", "December"],
			tableEntry: [
				["Total Revenue", "309428", "295000", "290699", ""],
				["Total Expense", "309428", "295000", "290699", ""],
				["Total Income", "309428", "295000", "290699", ""],
			],
		};
		return (
			<Table
				cardHeader={input.cardHeader}
				tableHeader={input.tableHeader}
				tableEntry={input.tableEntry}
			/>
		);
	}
}

export default Sample;
