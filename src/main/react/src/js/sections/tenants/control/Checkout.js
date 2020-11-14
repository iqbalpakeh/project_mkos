import React, { Component } from "react";
import { connect } from "react-redux";

import { checkoutTenant } from "../../../Api";
import { getMonthNumber } from "../../../components/DateFormatter";
import FormGroupYear from "../../../components/FormGroupYear";
import FormGroupMonth from "../../../components/FormGroupMonth";
import Submitter from "../../../components/Submitter";

class Checkout extends Component {
	constructor(props) {
		super(props);
		this.state = {
			room: "",
			month: "",
			year: "",
		};

		this.handleRoomChange = this.handleRoomChange.bind(this);
		this.handleYearChange = this.handleYearChange.bind(this);
		this.handleMonthChange = this.handleMonthChange.bind(this);
		this.handleSubmitClick = this.handleSubmitClick.bind(this);
	}

	handleRoomChange(event) {
		this.setState({
			room: event.target.value,
		});
		event.preventDefault();
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

	handleSubmitClick(event) {
		checkoutTenant({
			room: this.state.room,
			endDate: `${this.state.year}${this.state.month}`,
		});
		event.preventDefault();
	}

	render() {
		return (
			<div>
				<ButtonCheckout />
				<div className="modal fade" id="checkoutModal">
					<div className="modal-dialog modal-lg">
						<div className="modal-content">
							<div className="modal-header bg-primary text-white">
								<h5 className="modal-title">Checkout tenant</h5>
								<button className="close" data-dismiss="modal">
									<span>&times;</span>
								</button>
							</div>
							<div className="modal-body">
								<div className="container-fluid">
									<form>
										<FormGroupRoom
											onChange={this.handleRoomChange}
											defaultValue={this.state.room}
											rooms={this.props.room.rooms}
										/>
									</form>
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

const ButtonCheckout = () => {
	return (
		<a
			href="#"
			className="btn btn-warning btn-block"
			data-toggle="modal"
			data-target="#checkoutModal">
			<i className="fas fa-sign-out-alt"></i> Checkout
		</a>
	);
};

const FormGroupRoom = ({ onChange, defaultValue, rooms }) => {
	return (
		<div className="form-group">
			<label>Room</label>
			<select
				className="form-control"
				onChange={onChange}
				defaultValue={defaultValue}>
				{rooms.map((opVal, index) => {
					if (opVal.tenant != null) {
						return (
							<option value={opVal.roomNumber} key={index}>
								Room {opVal.roomNumber}
							</option>
						);
					}
				})}
			</select>
		</div>
	);
};

const mapStateToProps = (state) => {
	return state;
};

export default connect(mapStateToProps)(Checkout);
