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

// Add another store type here ... and don't forget to combine it

// -------------------------
// Combine Reducer
// -------------------------

const initialState = {};
export const store = createStore(
	combineReducers({
		expenseTypesReducer,
	}),
	initialState,
	devToolsEnhancer({})
);
