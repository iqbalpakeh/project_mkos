export const ADD_INCOME = "ADD_INCOME";
export const ADD_EXPENSE = "ADD_EXPENSE";
export const ADD_EXPENSE_TYPE = "ADD_EXPENSE_TYPE";

export const addIncome = (income) => ({
	type: ADD_INCOME,
	payload: income,
});

export const addExpense = (expense) => ({
	type: ADD_EXPENSE,
	payload: expense,
});

export const addExpenseType = (expenseType) => ({
	type: ADD_EXPENSE_TYPE,
	payload: expenseType,
});
