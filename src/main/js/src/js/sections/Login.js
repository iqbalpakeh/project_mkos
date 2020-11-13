import React, { Component } from "react";

class Login extends Component {
	render() {
		return (
			<div className="d-flex flex-column min-vh-100">
				<div className="text-center my-auto">
					<form className="form-signin">
						<i className="fas fa-home fa-5x text-secondary mb-2"></i>
						<h1 className="h3 mb-3 font-weight-normal">Please sign in</h1>
						<label htmlFor="inputEmail" className="sr-only">
							Email address
						</label>
						<input
							type="email"
							id="inputEmail"
							className="form-control"
							placeholder="Email address"
							required
							autoFocus></input>
						<label htmlFor="inputPassword" className="sr-only">
							Password
						</label>
						<input
							type="password"
							id="inputPassword"
							className="form-control"
							placeholder="Password"
							required></input>
						<div className="checkbox mb-3">
							<label>
								<input type="checkbox" value="remember-me"></input> Remember me
							</label>
						</div>
						<button className="btn btn-lg btn-primary btn-block" type="submit">
							Sign in
						</button>
						<p className="mt-5 mb-3 text-muted">Mkos &copy; 2020-2021</p>
					</form>
				</div>
			</div>
		);
	}
}

export default Login;
