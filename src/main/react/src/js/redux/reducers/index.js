import { combineReducers } from "redux";

import income from "./Income";
import expense from "./Expense";
import expenseType from "./ExpenseType";

export default combineReducers({ income, expense, expenseType });
