import { combineReducers } from "redux";

import income from "./Income";
import expense from "./Expense";
import expenseType from "./ExpenseType";
import room from "./Room";

export default combineReducers({ income, expense, expenseType, room });
