import React, { Component } from "react";
import { connect } from "react-redux";
import { createPayment } from "../../../Api";
import { getMonthNumber } from "../../../components/DateFormatter";

import FormGroupYear from "../../../components/FormGroupYear";
import FormGroupMonth from "../../../components/FormGroupMonth";
import FormGroupInput from "../../../components/FormGroupInput";
import Submitter from "../../../components/Submitter";

class AddPaymentModal extends Component {
	constructor(props) {
		super(props);
		this.state = {
			amount: "0",
			type: "Revenue",
			item: "Electricity",
			year: "2020",
			month: "01",
			information: "",
		};

		this.handleAmountChange = this.handleAmountChange.bind(this);
		this.handleTypeChange = this.handleTypeChange.bind(this);
		this.handleItemChange = this.handleItemChange.bind(this);
		this.handleYearChange = this.handleYearChange.bind(this);
		this.handleMonthChange = this.handleMonthChange.bind(this);
		this.handleInformationChange = this.handleInformationChange.bind(this);
		this.handleSubmitClick = this.handleSubmitClick.bind(this);
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
			month: getMonthNumber(event.target.value),
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
		createPayment({
			amount: this.state.amount,
			type: this.state.type,
			item: this.state.item,
			paymentDate: `${this.state.year}${this.state.month}`,
			information: this.state.information,
		});
		event.preventDefault();
	}

	render() {
		return (
			<div>
				<ButtonAddPayment />
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
												defaultYear={this.state.year}
											/>
										</div>
										<div className="col-md-6">
											<FormGroupMonth
												handleMonthChange={this.handleMonthChange}
												defaultMonth={this.state.month}
												title="Month"
											/>
										</div>
									</div>
									<form>
										<FormGroupInput
											title="Amount"
											onChange={this.handleAmountChange}
											defaultValue={this.state.amount}
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
											expense={this.props.expense.expenses}
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

const ButtonAddPayment = () => {
	return (
		<a
			href="#"
			className="btn btn-primary btn-block"
			data-toggle="modal"
			data-target="#addPaymentModal">
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
								<option value={opVal.roomNumber} key={index}>
									Room {opVal.roomNumber}
								</option>
							);
					  })
					: expense.map((opVal, index) => {
							return (
								<option value={opVal.expenseType} key={index}>
									{opVal.expenseType}
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
