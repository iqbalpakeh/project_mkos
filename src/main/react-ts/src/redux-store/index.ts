import { createStore, combineReducers } from "redux";
import { devToolsEnhancer } from "redux-devtools-extension";

import { expenseTypesReducer } from "./expensetypes-store";
import { roomReducer } from "./rooms-store";

// ------------------------------------
// Combine Reducer from all store type
// ------------------------------------

const initialState = {};
const reducers = combineReducers({
	expenseTypesReducer,
	roomReducer,
});

export {
	addExpenseTypeAction,
	clearAllExpenseTypesAction,
} from "./expensetypes-store";
export { addRoomAction, clearAllRoomsAction } from "./rooms-store";

export type IReducer = ReturnType<typeof reducers>;
export const store = createStore(reducers, initialState, devToolsEnhancer({}));
