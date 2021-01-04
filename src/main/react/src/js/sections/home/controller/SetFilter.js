import React, { Component } from "react";
import { connect } from "react-redux";
import {
	fetchRevenuePayments,
	fetchExpensePayments,
	fetchIncomes,
} from "../../../Api";
import {
	getNumberFromMonth,
	getCurrentYear,
	getFilterStartMonth,
	getFilterEndMonth,
} from "../../../components/DateFormatter";
import FormGroupYear from "../../../components/FormGroupYear";
import FormGroupMonth from "../../../components/FormGroupMonth";

class SetFilter extends Component {
	constructor(props) {
		super(props);
		this.state = this.getInitState();
		this.handleClick = this.handleClick.bind(this);
		this.handleYearChange = this.handleYearChange.bind(this);
		this.handleStartMonthChange = this.handleStartMonthChange.bind(this);
		this.handleEndMonthChange = this.handleEndMonthChange.bind(this);
		this.handleSaveChangesClick = this.handleSaveChangesClick.bind(this);
	}

	getInitState() {
		return {
			year: getCurrentYear(),
			startMonth: getFilterStartMonth(),
			endMonth: getFilterEndMonth(1),
		};
	}

	handleClick(event) {
		this.setState(this.getInitState());
		event.preventDefault();
	}

	handleYearChange(event) {
		this.setState({
			year: event.target.value,
		});
		event.preventDefault();
	}

	handleStartMonthChange(event) {
		this.setState({
			startMonth: getNumberFromMonth(event.target.value),
		});
		event.preventDefault();
	}

	handleEndMonthChange(event) {
		this.setState({
			endMonth: getNumberFromMonth(event.target.value),
		});
		event.preventDefault();
	}

	handleSaveChangesClick(event) {
		fetchRevenuePayments({
			year: this.state.year,
			startMonth: this.state.startMonth,
			endMonth: this.state.endMonth,
			dispatch: this.props.dispatch,
		});
		fetchExpensePayments({
			year: this.state.year,
			startMonth: this.state.startMonth,
			endMonth: this.state.endMonth,
			dispatch: this.props.dispatch,
		});
		fetchIncomes({
			year: this.state.year,
			startMonth: this.state.startMonth,
			endMonth: this.state.endMonth,
			dispatch: this.props.dispatch,
		});
		event.preventDefault();
	}

	render() {
		return (
			<div>
				<SetFilterButton handleClick={this.handleClick} />
				<div className="modal fade" id="setFilterModal">
					<div className="modal-dialog modal-lg">
						<div className="modal-content">
							<div className="modal-header bg-warning text-white">
								<h5 className="modal-title">Set Filter</h5>
								<button className="close" data-dismiss="modal">
									<span>&times;</span>
								</button>
							</div>
							<div className="modal-body">
								<div className="container-fluid">
									<div className="row">
										<div className="col-md-4">
											<FormGroupYear
												handleYearChange={this.handleYearChange}
												initialYear={this.state.year}
											/>
										</div>
										<div className="col-md-4">
											<FormGroupMonth
												title="Start Month"
												handleMonthChange={this.handleStartMonthChange}
												initialMonth={this.state.startMonth}
											/>
										</div>
										<div className="col-md-4">
											<FormGroupMonth
												title="End Month"
												handleMonthChange={this.handleEndMonthChange}
												initialMonth={this.state.endMonth}
											/>
										</div>
									</div>
								</div>
							</div>
							<SaveChangeButton
								handleSaveChangesClick={this.handleSaveChangesClick}
							/>
						</div>
					</div>
				</div>
			</div>
		);
	}
}

const SetFilterButton = ({ handleClick }) => {
	return (
		<a
			href="#"
			className="btn btn-warning btn-block"
			data-toggle="modal"
			data-target="#setFilterModal"
			onClick={handleClick}>
			<i className="fas fa-edit"></i> Set Filter
		</a>
	);
};

const SaveChangeButton = ({ handleSaveChangesClick }) => {
	return (
		<div className="modal-footer">
			<button
				className="btn btn-warning"
				data-dismiss="modal"
				onClick={handleSaveChangesClick}>
				Save Changes
			</button>
		</div>
	);
};

export default connect(null, null)(SetFilter);
