import { AnyAction, Dispatch } from "redux";
import axios from "axios";

import { addTenantAction, clearAllTenantsAction } from "redux-store";

export const getTenants = (dispatch: Dispatch<AnyAction>) => {
	axios.get(`/api/tenants`).then(
		(response) => {
			const datas = response.data as Array<any>;
			dispatch(clearAllTenantsAction());
			datas.forEach((data) => {
				dispatch(
					addTenantAction({
						tenantName: data.tenant.tenantName,
						tenantPhone: data.tenant.tenantPhone,
						checkin: data.tenant.checkin,
						checkout: data.tenant.checkout,
					})
				);
			});
		},
		(error) => {
			console.log(error);
		}
	);
};
