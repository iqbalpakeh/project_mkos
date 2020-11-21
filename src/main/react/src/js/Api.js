import axios from "axios";

import {
	addIncome,
	addExpense,
	addExpenseType,
	addRevenue,
	addRoom,
	addTenant,
} from "./redux/Action";

export const fetchRevenuePayments = ({
	year,
	startMonth,
	endMonth,
	dispatch,
}) => {
	axios({
		method: "GET",
		url: `/api/revenue-payments-range?year=${year}&startMonth=${startMonth}&endMonth=${endMonth}`,
	}).then(
		(response) => dispatch(addRevenue(response.data)),
		(error) => console.log(error)
	);
};

export const fetchExpensePayments = ({
	year,
	startMonth,
	endMonth,
	dispatch,
}) => {
	axios({
		method: "GET",
		url: `/api/expense-payments-range?year=${year}&startMonth=${startMonth}&endMonth=${endMonth}`,
	}).then(
		(response) => dispatch(addExpense(response.data)),
		(error) => console.log(error)
	);
};

export const fetchIncomes = ({ year, startMonth, endMonth, dispatch }) => {
	axios({
		method: "GET",
		url: `/api/incomes-range?year=${year}&startMonth=${startMonth}&endMonth=${endMonth}`,
	}).then(
		(response) => dispatch(addIncome(response.data)),
		(error) => console.log(error)
	);
};

export const fetchExpenseTypes = (dispatch) => {
	axios({
		method: "GET",
		url: `/api/expenses`,
	}).then(
		(response) => dispatch(addExpenseType(response.data)),
		(error) => console.log(error)
	);
};

export const fetchRooms = (dispatch) => {
	axios({
		method: "GET",
		url: `/api/rooms`,
	}).then(
		(response) => dispatch(addRoom(response.data)),
		(error) => console.log(error)
	);
};

export const fetchTenants = (dispatch) => {
	axios({
		method: "GET",
		url: `/api/tenants`,
	}).then(
		(response) => dispatch(addTenant(response.data)),
		(error) => console.log(error.data)
	);
};

export const createRevenuePayment = ({
	paymentTimestamp,
	paymentAmount,
	paymentInformation,
	roomNumber,
	dispatch,
}) => {
	axios({
		method: "POST",
		url: `api/revenue-payments-create`,
		data: {
			paymentTimestamp,
			paymentAmount,
			paymentInformation,
			roomNumber,
		},
	}).then(
		(response) => console.log(response.data),
		(error) => console.log(error.data)
	);
};

export const createExpensePayment = ({
	paymentTimestamp,
	paymentAmount,
	paymentInformation,
	expenseType,
	dispatch,
}) => {
	axios({
		method: "POST",
		url: `api/expense-payments-create`,
		data: {
			paymentTimestamp,
			paymentAmount,
			paymentInformation,
			expenseType,
			dispatch,
		},
	}).then(
		(response) => console.log(response.data),
		(error) => console.log(error.data)
	);
};
