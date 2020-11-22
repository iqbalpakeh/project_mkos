import axios from "axios";

import {
	addIncome,
	addExpense,
	addExpenseType,
	addRevenue,
	addRoom,
	addTenant,
} from "./redux/Action";

// --------------------------------------------
// Fetch Revenue Payments
// --------------------------------------------

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

// --------------------------------------------
// Fetch Expense Payments
// --------------------------------------------

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

// --------------------------------------------
// Fetch Incomes
// --------------------------------------------

export const fetchIncomes = ({ year, startMonth, endMonth, dispatch }) => {
	axios({
		method: "GET",
		url: `/api/incomes-range?year=${year}&startMonth=${startMonth}&endMonth=${endMonth}`,
	}).then(
		(response) => dispatch(addIncome(response.data)),
		(error) => console.log(error)
	);
};

// --------------------------------------------
// Fetch Expense Types
// --------------------------------------------

export const fetchExpenseTypes = (dispatch) => {
	axios({
		method: "GET",
		url: `/api/expenses`,
	}).then(
		(response) => dispatch(addExpenseType(response.data)),
		(error) => console.log(error)
	);
};

// --------------------------------------------
// Fetch Rooms
// --------------------------------------------

export const fetchRooms = (dispatch) => {
	axios({
		method: "GET",
		url: `/api/rooms`,
	}).then(
		(response) => dispatch(addRoom(response.data)),
		(error) => console.log(error)
	);
};

// --------------------------------------------
// Fetch Tenants
// --------------------------------------------

export const fetchTenants = (dispatch) => {
	axios({
		method: "GET",
		url: `/api/tenants`,
	}).then(
		(response) => dispatch(addTenant(response.data)),
		(error) => console.log(error.data)
	);
};

// --------------------------------------------
// Create Revenue Payment
// --------------------------------------------

export const createRevenuePayment = ({
	paymentTimestamp,
	paymentAmount,
	paymentInformation,
	roomNumber,
	dispatch,
}) => {
	axios({
		method: "POST",
		url: `/api/revenue-payments-create`,
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

// --------------------------------------------
// Create Expense Payment
// --------------------------------------------

export const createExpensePayment = ({
	paymentTimestamp,
	paymentAmount,
	paymentInformation,
	expenseType,
	dispatch,
}) => {
	axios({
		method: "POST",
		url: `/api/expense-payments-create`,
		data: {
			paymentTimestamp,
			paymentAmount,
			paymentInformation,
			expenseType,
		},
	}).then(
		(response) => console.log(response.data),
		(error) => console.log(error.data)
	);
};

// --------------------------------------------
// Create Tenant
// --------------------------------------------

export const createTenant = ({
	tenantName,
	tenantPhone,
	checkin,
	roomNumber,
	dispatch,
}) => {
	axios({
		method: "POST",
		url: "/api/tenants-create",
		data: {
			tenantName,
			tenantPhone,
			checkin,
			roomNumber,
		},
	}).then(
		(response) => console.log(response.data),
		(error) => console.log(error)
	);
};

// --------------------------------------------
// Checkout Tenant
// --------------------------------------------

export const checkoutTenant = ({ checkout, roomNumber, dispatch }) => {
	axios({
		method: "POST",
		url: `/api/tenants-checkout`,
		data: {
			checkout,
			roomNumber,
		},
	}).then(
		(response) => console.log(response.data),
		(error) => console.log(error)
	);
};

// --------------------------------------------
// Fetch Tenant Logs
// --------------------------------------------

export default fetchTenantLogs = ({ dispatch }) => {
	axios({
		method: "GET",
		url: `/api/tenant-logs`,
	}).then(
		(response) => console.log(response.data),
		(error) => console.log(error)
	);
};
