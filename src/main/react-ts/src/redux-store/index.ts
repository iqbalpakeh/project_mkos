import { createStore, combineReducers } from "redux";
import { devToolsEnhancer } from "redux-devtools-extension";

// -------------------------
// ExpenseTypes Store
// -------------------------

import { expenseTypesReducer } from "./expensetypes-store";
export {
	addExpenseTypeAction,
	clearExpenseTypeAction,
} from "./expensetypes-store";

// -------------------------
// Combine Reducer
// -------------------------

export const store = createStore(
	combineReducers({
		expenseTypesReducer,
		devToolsEnhancer,
	})
);
