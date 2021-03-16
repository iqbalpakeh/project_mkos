import { AnyAction } from "redux";

// ----------------------
// Type and Interface
// ----------------------

const ADD_EXPENSE_TYPE = "ADD_EXPENSE_TYPE";
const CLEAR_ALL_EXPENSE_TYPES = "CLEAR_ALL_EXPENSE_TYPES";

type TExpenseTypeAction = "ADD_EXPENSE_TYPE" | "CLEAR_ALL_EXPENSE_TYPES";

interface IExpenseType {
	expenseType: string;
	expenseInformation: string;
}

interface IAddExpenseTypeAction {
	type: TExpenseTypeAction;
	payload: IExpenseType;
}

interface IClearAllExpenseTypesAction {
	type: TExpenseTypeAction;
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
