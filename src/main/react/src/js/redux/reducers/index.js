import { combineReducers } from "redux";
import income from "./Income";
import room from "./Room";
import expense from "./Expense";
import tenant from "./Tenant";

export default combineReducers({ income, room, expense, tenant });
