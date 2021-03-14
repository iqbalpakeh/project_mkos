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
	payload: {};
}

interface IExpenseTypesReducer {
	state: IExpenseType[];
	action: IAddExpenseTypesAction | IClearExpenseTypesAction;
}

// ----------------------
// Actions
// ----------------------

export const addExpenseType = ({
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

export const clearExpenseType = (): IClearExpenseTypesAction => {
	return {
		type: CLEAR_EXPENSE_TYPES,
	};
};

// ----------------------
// Reducer
// ----------------------

const initialState: IExpenseType[] = [];

export const expenseTypesReducer = ({
	state = initialState,
	action,
}: IExpenseTypesReducer): IExpenseType[] => {
	switch (action.type) {
		case ADD_EXPENSE_TYPES:
			return state.push(action.payload);
		default:
			return state;
	}
};

export {};
