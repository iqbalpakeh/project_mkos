import axios from "axios";

import { addIncome, addExpense, addExpenseType } from "./redux/Action";

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
		(response) => {
			// console.log(response.data);
		},
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
		(response) => {
			dispatch(addExpense(response.data));
		},
		(error) => console.log(error)
	);
};

export const fetchExpenseTypes = (dispatch) => {
	axios({
		method: "GET",
		url: `/api/expenses`,
	}).then(
		(response) => {
			dispatch(addExpenseType(response.data));
		},
		(error) => console.log(error)
	);
};

export const fetchIncomes = ({ year, startMonth, endMonth, dispatch }) => {
	axios({
		method: "GET",
		url: `/api/incomes-range?year=${year}&startMonth=${startMonth}&endMonth=${endMonth}`,
	}).then(
		(response) => {
			dispatch(addIncome(response.data));
		},
		(error) => console.log(error)
	);
};
