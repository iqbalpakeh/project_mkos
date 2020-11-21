import React, { Component } from "react";
import { connect } from "react-redux";

import { createTenant } from "../../../Api";
import { getMonthNumber } from "../../../components/DateFormatter";
import FormGroupYear from "../../../components/FormGroupYear";
import FormGroupMonth from "../../../components/FormGroupMonth";
import FormGroupInput from "../../../components/FormGroupInput";
import Submitter from "../../../components/Submitter";

class AddTenant extends Component {
	constructor(props) {
		super(props);
		this.state = {
			name: "",
			phone: "",
			room: "",
			month: "",
			year: "",
		};

		this.handleNameChange = this.handleNameChange.bind(this);
		this.handlePhoneChange = this.handlePhoneChange.bind(this);
		this.handleRoomChange = this.handleRoomChange.bind(this);
		this.handleYearChange = this.handleYearChange.bind(this);
		this.handleMonthChange = this.handleMonthChange.bind(this);
		this.handleSubmitClick = this.handleSubmitClick.bind(this);
	}

	handleNameChange(event) {
		this.setState({
			name: event.target.value,
		});
		event.preventDefault();
	}

	handlePhoneChange(event) {
		this.setState({
			phone: event.target.value,
		});
		event.preventDefault();
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
		createTenant({
			tenantName: this.state.name,
			tenantPhone: this.state.phone,
			checkin: `${this.state.year}${this.state.month}`,
			roomNumber: this.state.room,
		});
		event.preventDefault();
	}

	render() {
		console.log(this.props);
		return (
			<div>
				<ButtonAddTenant />
				<div className="modal fade" id="addTenantModal">
					<div className="modal-dialog modal-lg">
						<div className="modal-content">
							<div className="modal-header bg-primary text-white">
								<h5 className="modal-title">
									Add tenant information and checkin date
								</h5>
								<button className="close" data-dismiss="modal">
									<span>&times;</span>
								</button>
							</div>
							<div className="modal-body">
								<div className="container-fluid">
									<form>
										<FormGroupInput
											title="Name"
											onChange={this.handleNameChange}
											defaultValue={this.state.name}
											type="text"
										/>
										<FormGroupInput
											title="Phone"
											onChange={this.handlePhoneChange}
											defaultValue={this.state.phone}
											type="number"
										/>
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

const ButtonAddTenant = () => {
	return (
		<a
			href="#"
			className="btn btn-primary btn-block"
			data-toggle="modal"
			data-target="#addTenantModal">
			<i className="fas fa-plus"></i> Add Tenant
		</a>
	);
};

const FormGroupRoom = ({ onChange, defaultValue, rooms }) => {
	console.log(rooms);
	return (
		<div className="form-group">
			<label>Room</label>
			<select
				className="form-control"
				onChange={onChange}
				defaultValue={defaultValue}>
				{rooms.map((opVal, index) => {
					if (opVal.room.tenant == null) {
						return (
							<option value={opVal.room.roomNumber} key={index}>
								Room {opVal.room.roomNumber}
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

export default connect(mapStateToProps)(AddTenant);
