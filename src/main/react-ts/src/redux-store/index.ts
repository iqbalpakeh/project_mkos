import { createStore, combineReducers } from "redux";
import { devToolsEnhancer } from "redux-devtools-extension";

import { expenseTypesReducer } from "./expensetypes-store";
import { roomReducer } from "./rooms-store";
import { tenantReducer } from "./tenants-store";

// ------------------------------------
// Export all action from each store
// ------------------------------------

export {
	addExpenseTypeAction,
	clearAllExpenseTypesAction,
} from "./expensetypes-store";
export { addRoomAction, clearAllRoomsAction } from "./rooms-store";
export { addTenantAction, clearAllTenantsAction } from "./tenants-store";

// ------------------------------------
// Combine Reducer from all store type
// and create global store object
// ------------------------------------

const initialState = {};
const reducers = combineReducers({
	expenseTypesReducer,
	roomReducer,
	tenantReducer,
});

export type IReducer = ReturnType<typeof reducers>;
export const store = createStore(reducers, initialState, devToolsEnhancer({}));
