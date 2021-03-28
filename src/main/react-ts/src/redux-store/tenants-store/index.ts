import { AnyAction } from "redux";

// ----------------------
// Type and Interface
// ----------------------

const ADD_TENANT = "ADD_TENANT";
const CLEAR_ALL_TENANTS = "CLEAR_ALL_TENANTS";

export interface ITenant {
	tenantName: string;
	tenantPhone: string;
	checkin: number;
	checkout: number;
}

interface IAddTenantAction {
	type: string;
	payload: ITenant;
}

interface IClearAllTenants {
	type: string;
}

// ----------------------
// Actions
// ----------------------

export const addTenantAction = ({
	tenantName,
	tenantPhone,
	checkin,
	checkout,
}: ITenant): IAddTenantAction => {
	return {
		type: ADD_TENANT,
		payload: {
			tenantName,
			tenantPhone,
			checkin,
			checkout,
		},
	};
};

export const clearAllTenantsAction = (): IClearAllTenants => {
	return {
		type: CLEAR_ALL_TENANTS,
	};
};

// ----------------------
// Reducer
// ----------------------

export const tenantReducer = (
	state: ITenant[] = [],
	action: AnyAction
): ITenant[] => {
	switch (action.type) {
		case ADD_TENANT:
			return [...state, action.payload];
		case CLEAR_ALL_TENANTS:
			return [];
		default:
			return state;
	}
};
