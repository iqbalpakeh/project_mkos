import { AnyAction } from "redux";

// ----------------------
// Type and Interface
// ----------------------

const ADD_EXPENSE_TYPES = "ADD_EXPENSE_TYPES";
const CLEAR_EXPENSE_TYPES = "CLEAR_EXPENSE_TYPES";

type TExpenseTypeActions = "ADD_EXPENSE_TYPES" | "CLEAR_EXPENSE_TYPES";

interface IExpenseType {
	expenseType: string;
	expenseInformation: string;
}

interface IAddExpenseTypesAction {
	type: TExpenseTypeActions;
	payload: IExpenseType;
}

interface IClearExpenseTypesAction {
	type: TExpenseTypeActions;
}

// ----------------------
// Actions
// ----------------------

export const addExpenseTypeAction = ({
	expenseType,
	expenseInformation,
}: IExpenseType): IAddExpenseTypesAction => {
	return {
		type: ADD_EXPENSE_TYPES,
		payload: {
			expenseType,
			expenseInformation,
		},
	};
};

export const clearExpenseTypeAction = (): IClearExpenseTypesAction => {
	return {
		type: CLEAR_EXPENSE_TYPES,
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
		case ADD_EXPENSE_TYPES:
			return [...state, action.payload];
		case CLEAR_EXPENSE_TYPES:
			return [];
		default:
			return state;
	}
};
