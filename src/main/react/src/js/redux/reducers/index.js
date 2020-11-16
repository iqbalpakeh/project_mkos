import { combineReducers } from "redux";

import income from "./Income";
import expense from "./Expense";
import expenseType from "./ExpenseType";
import room from "./Room";
import revenue from "./Revenue";

export default combineReducers({ income, expense, expenseType, room, revenue });
