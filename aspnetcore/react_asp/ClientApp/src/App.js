import React, { Component } from 'react';
import { Layout } from './components/Layout';
import { Navigation } from './components/Navigation';
import './custom.css';

export default class App extends Component {
	static displayName = App.name;

	render() {
		return (
			<div>
				<Navigation />
				<Layout></Layout>
			</div>
		);
	}
}
