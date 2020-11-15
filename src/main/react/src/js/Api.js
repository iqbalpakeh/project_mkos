import axios from "axios";

import { addNetIncome } from "./redux/Action";

export const fetchIncomePayments = ({
	year,
	startMonth,
	endMonth,
	dispatch,
}) => {
	axios({
		method: "GET",
		url: `/api/income-payments-range?year=${year}&startMonth=${startMonth}&endMonth=${endMonth}`,
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
			// console.log(response.data);
		},
		(error) => console.log(error)
	);
};

export const fetchNetIncomes = ({ year, startMonth, endMonth, dispatch }) => {
	axios({
		method: "GET",
		url: `/api/net-income-range?year=${year}&startMonth=${startMonth}&endMonth=${endMonth}`,
	}).then(
		(response) => {
			dispatch(addNetIncome(response.data));
		},
		(error) => console.log(error)
	);
};
