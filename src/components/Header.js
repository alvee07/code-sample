import React, { Component } from 'react'

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
                <h1>{title} to React UI page</h1>
            </header>
        )
    }
}



export default Header
