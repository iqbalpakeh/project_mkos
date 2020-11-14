import axios from "axios";
import { addIncome, addRoom, addExpense, addTenant } from "./redux/Action";

export const fetchIncomeThisMonth = () => {
	axios({
		method: "GET",
		url: `/api/income?date=202009`,
	}).then(
		(response) => {
			console.log(response.data);
		},
		(error) => console.log(error)
	);
};

export const fetchIncomeRange = ({ year, startMonth, endMonth, dispatch }) => {
	axios({
		method: "GET",
		url: `/api/incomes?year=${year}&startMonth=${startMonth}&endMonth=${endMonth}`,
	}).then(
		(response) => {
			dispatch(addIncome(response.data));
		},
		(error) => console.log(error)
	);
};

export const fetchAllRoom = ({ dispatch }) => {
	axios({
		method: "GET",
		url: `/api/rooms`,
	}).then(
		(response) => {
			dispatch(addRoom(response.data));
		},
		(error) => {
			console.log(error);
		}
	);
};

export const fetchAllExpense = ({ dispatch }) => {
	axios({
		method: "GET",
		url: `/api/expenses`,
	}).then(
		(response) => {
			dispatch(addExpense(response.data));
		},
		(error) => {
			console.log(error);
		}
	);
};

export const fetchAllTenants = ({ dispatch }) => {
	axios({
		method: "GET",
		url: "/api/tenants",
	}).then(
		(response) => {
			dispatch(addTenant(response.data));
		},
		(error) => {
			console.log(error);
		}
	);
};

export const createPayment = (payment) => {
	axios({
		method: "POST",
		url: "/api/payments/create",
		data: payment,
	}).then(
		(response) => {
			console.log(response);
		},
		(error) => {
			console.log(error);
		}
	);
};

export const newTenant = (tenant) => {
	axios({
		method: "POST",
		url: "/api/tenants/new",
		data: tenant,
	}).then(
		(response) => {
			console.log(response);
		},
		(error) => {
			console.log(error);
		}
	);
};

export const checkoutTenant = (checkout) => {
	axios({
		method: "POST",
		url: "/api/tenants/checkout",
		data: checkout,
	}).then(
		(response) => {
			console.log(response);
		},
		(error) => {
			console.log(error);
		}
	);
};
