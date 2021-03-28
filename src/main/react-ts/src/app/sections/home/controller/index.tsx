import { default as AddPayment } from "./add-payment";

const Component = () => {
	return (
		<div>
			<div className="py-4 mb-2">
				<div className="container">
					<div className="row">
						<div className="col-md-3 mb-2">
							<AddPayment />
						</div>
						<div className="col-md-3">Set Filter</div>
					</div>
				</div>
			</div>
		</div>
	);
};

export default Component;
