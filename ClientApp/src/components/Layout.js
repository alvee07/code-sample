import React, { Component } from 'react';
import { Route, Routes } from 'react-router-dom';
import { Home } from './Home';
import { FetchData } from './FetchData';
import { Counter } from './Counter';

export class Layout extends Component {
	static displayName = Layout.name;

	render() {
		return (
			<div>
				<div>
					<Routes>
						<Route exact path="/" element={<Home />} />
						<Route path="/counter" element={<Counter />} />
						<Route path="/fetch-data" element={<FetchData />} />
					</Routes>
				</div>
			</div>
		);
	}
}
