import { combineReducers } from "redux";

import income from "./Income";
import expense from "./Expense";

export default combineReducers({ income, expense });
