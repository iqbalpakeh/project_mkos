export const ADD_INCOME = "ADD_INCOME";

export const addNetIncome = (income) => ({
	type: ADD_INCOME,
	payload: income,
});
