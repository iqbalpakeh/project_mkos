import React, { Component } from "react";
import { connect } from "react-redux";
import { createRevenuePayment, createExpensePayment } from "../../../Api";
import { getNumberFromMonth } from "../../../components/DateFormatter";

import FormGroupYear from "../../../components/FormGroupYear";
import FormGroupMonth from "../../../components/FormGroupMonth";
import FormGroupInput from "../../../components/FormGroupInput";
import Submitter from "../../../components/Submitter";

class AddPaymentModal extends Component {
	constructor(props) {
		super(props);
		this.state = this.getInitState();
		this.handleClick = this.handleClick.bind(this);
		this.handleAmountChange = this.handleAmountChange.bind(this);
		this.handleTypeChange = this.handleTypeChange.bind(this);
		this.handleItemChange = this.handleItemChange.bind(this);
		this.handleYearChange = this.handleYearChange.bind(this);
		this.handleMonthChange = this.handleMonthChange.bind(this);
		this.handleInformationChange = this.handleInformationChange.bind(this);
		this.handleSubmitClick = this.handleSubmitClick.bind(this);
	}

	getInitState() {
		return {
			amount: "0",
			type: "Revenue",
			item: "Electricity",
			year: this.getCurrentYear(),
			month: this.getCurrentMonth(),
			information: "",
		};
	}

	getCurrentYear() {
		const date = new Date();
		return `${date.getFullYear()}`;
	}

	getCurrentMonth() {
		const date = new Date();
		const month = date.getMonth() + 1;
		return month > 9 ? `${month}` : `0${month}`;
	}

	handleClick(event) {
		console.log("handleClick()");
		this.setState(this.getInitState());
		event.preventDefault();
	}

	handleAmountChange(event) {
		this.setState({
			amount: event.target.value,
		});
		event.preventDefault();
	}

	handleTypeChange(event) {
		this.setState({
			type: event.target.value,
		});
		event.preventDefault();
	}

	handleItemChange(event) {
		this.setState({
			item: event.target.value,
		});
	}

	handleYearChange(event) {
		this.setState({
			year: event.target.value,
		});
		event.preventDefault();
	}

	handleMonthChange(event) {
		this.setState({
			month: getNumberFromMonth(event.target.value),
		});
		event.preventDefault();
	}

	handleInformationChange(event) {
		this.setState({
			information: event.target.value,
		});
		event.preventDefault();
	}

	handleSubmitClick(event) {
		console.log(this.state);
		// if (this.state.type == "Revenue") {
		// 	createRevenuePayment({
		// 		paymentTimestamp: `${this.state.year}${this.state.month}`,
		// 		paymentAmount: this.state.amount,
		// 		paymentInformation: this.state.information,
		// 		roomNumber: this.state.item,
		// 		dispatch: this.props.dispatch,
		// 	});
		// } else {
		// 	createExpensePayment({
		// 		paymentTimestamp: `${this.state.year}${this.state.month}`,
		// 		paymentAmount: this.state.amount,
		// 		paymentInformation: this.state.information,
		// 		expenseType: this.state.item,
		// 		dispatch: this.props.dispatch,
		// 	});
		// }
		event.preventDefault();
	}

	render() {
		return (
			<div>
				<ButtonAddPayment handleClick={this.handleClick} />
				<div className="modal fade" id="addPaymentModal">
					<div className="modal-dialog modal-lg">
						<div className="modal-content">
							<div className="modal-header bg-primary text-white">
								<h5 className="modal-title">Add Payment</h5>
								<button className="close" data-dismiss="modal">
									<span>&times;</span>
								</button>
							</div>
							<div className="modal-body">
								<div className="container-fluid">
									<div className="row">
										<div className="col-md-6">
											<FormGroupYear
												handleYearChange={this.handleYearChange}
												defaultYear={this.getCurrentYear()}
											/>
										</div>
										<div className="col-md-6">
											<FormGroupMonth
												handleMonthChange={this.handleMonthChange}
												defaultMonth={this.getCurrentMonth()}
												title="Month"
											/>
										</div>
									</div>
									<form>
										<FormGroupInput
											title="Amount"
											onChange={this.handleAmountChange}
											initialValue={this.state.amount}
											type="number"
										/>
										<FormGroupType
											handleTypeChange={this.handleTypeChange}
											defaultType={this.state.type}
										/>
										<FormGroupItem
											handleItemChange={this.handleItemChange}
											defaultItem={this.state.item}
											revenue={this.props.room.rooms}
											expense={this.props.expenseType.expenseTypes}
											type={this.state.type}
										/>
									</form>
									<FormGroupInformation
										handleInformationChange={this.handleInformationChange}
									/>
								</div>
							</div>
							<Submitter handleSubmitClick={this.handleSubmitClick} />
						</div>
					</div>
				</div>
			</div>
		);
	}
}

const ButtonAddPayment = ({ handleClick }) => {
	return (
		<a
			href="#"
			className="btn btn-primary btn-block"
			data-toggle="modal"
			data-target="#addPaymentModal"
			onClick={handleClick}>
			<i className="fas fa-plus"></i> Add Payment
		</a>
	);
};

const FormGroupType = ({ handleTypeChange, defaultType }) => {
	return (
		<div className="form-group">
			<label>Type</label>
			<select
				className="form-control"
				onChange={handleTypeChange}
				defaultValue={defaultType}>
				<option value="Revenue">Revenue</option>
				<option value="Expense">Expense</option>
			</select>
		</div>
	);
};

const FormGroupItem = ({
	handleItemChange,
	defaultItem,
	revenue,
	expense,
	type,
}) => {
	return (
		<div className="form-group">
			<label>Item</label>
			<select
				className="form-control"
				onChange={handleItemChange}
				defaultValue={defaultItem}>
				{type === "Revenue"
					? revenue.map((opVal, index) => {
							return (
								<option value={opVal.room.roomNumber} key={index}>
									Room {opVal.room.roomNumber}
								</option>
							);
					  })
					: expense.map((opVal, index) => {
							return (
								<option value={opVal.expense.expenseType} key={index}>
									{opVal.expense.expenseType}
								</option>
							);
					  })}
			</select>
		</div>
	);
};

const FormGroupInformation = ({ handleInformationChange }) => {
	return (
		<div className="form-group">
			<label>Information</label>
			<textarea
				className="form-control"
				onChange={handleInformationChange}
				rows="7"></textarea>
		</div>
	);
};

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(AddPaymentModal);
