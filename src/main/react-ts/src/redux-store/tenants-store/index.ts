import { AnyAction } from "redux";

// ----------------------
// Type and Interface
// ----------------------

export interface ITenants {
	tenantName: string;
	tenantPhone: string;
	checkin: number;
	checkout: number;
}
