import { combineReducers } from "redux";

import income from "./Income";
import expense from "./Expense";
import expenseType from "./ExpenseType";
import room from "./Room";
import revenue from "./Revenue";
import tenant from "./Tenant";

export default combineReducers({
	income,
	expense,
	expenseType,
	room,
	revenue,
	tenant,
});
