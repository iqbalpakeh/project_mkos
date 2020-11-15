import React, { Component } from "react";

const Header = ({ icon, title }) => {
	return (
		<header id="main-header" className="py-2 bg-primary text-white mb-4">
			<div className="container">
				<div className="row">
					<div className="col-md-6">
						<h1>
							<i className={icon}> {title}</i>
						</h1>
					</div>
				</div>
			</div>
		</header>
	);
};

export default Header;
