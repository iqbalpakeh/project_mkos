import { AnyAction } from "redux";

// ----------------------
// Interfaces
// ----------------------

const ADD_EXPENSE_TYPE = "ADD_EXPENSE_TYPE";
const CLEAR_ALL_EXPENSE_TYPES = "CLEAR_ALL_EXPENSE_TYPES";

interface IExpenseType {
	expenseType: string;
	expenseInformation: string;
}

interface IAddExpenseTypeAction {
	type: string;
	payload: IExpenseType;
}

interface IClearAllExpenseTypesAction {
	type: string;
}

// ----------------------
// Actions
// ----------------------

export const addExpenseTypeAction = ({
	expenseType,
	expenseInformation,
}: IExpenseType): IAddExpenseTypeAction => {
	return {
		type: ADD_EXPENSE_TYPE,
		payload: {
			expenseType,
			expenseInformation,
		},
	};
};

export const clearAllExpenseTypesAction = (): IClearAllExpenseTypesAction => {
	return {
		type: CLEAR_ALL_EXPENSE_TYPES,
	};
};

// ----------------------
// Reducer
// ----------------------

export const expenseTypesReducer = (
	state: IExpenseType[] = [],
	action: AnyAction
): IExpenseType[] => {
	switch (action.type) {
		case ADD_EXPENSE_TYPE:
			return [...state, action.payload];
		case CLEAR_ALL_EXPENSE_TYPES:
			return [];
		default:
			return state;
	}
};
