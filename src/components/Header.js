import React, { Component } from 'react'
import PropTypes from 'prop-types';

export class Header extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             
        }
    }

    // using default props, if parent comp does not provide any values.
    static defaultProps ={
        title : 'Welcome'
    }

    render() {
        const {title} = this.props
        console.log(this.props)
        return (
            <header>
                <h1>{title} to React UI</h1>
            </header>
        )
    }
}

Header.propTypes ={
    title: PropTypes.string
}

export default Header
