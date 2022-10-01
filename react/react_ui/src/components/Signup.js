import React, { Component } from "react";

export class Signup extends Component {
  constructor(props) {
    super(props);

    this.state = {
      fname: "",
      lname: "",
      email: "",
    };

    // this.submitHandler = this.submitHandler.bind(this);
    this.emailChangeHandler = this.emailChangeHandler.bind(this);
  }

  emailChangeHandler(event) {
    console.log(event.target.value);
  }

  onChange = (e) => {
    /*
      Because we named the inputs to match their
      corresponding values in state, it's
      super easy to update the state
    */
    console.log(e.target.name);
    this.setState({ [e.target.name]: e.target.value });
  };

  onSubmit = (e) => {
    e.preventDefault();
    // get our form data out of state
    // const { fname, lname, email } = this.state;

    console.log(this.state);

    fetch("https://alveeapi.azurewebsites.net/api/customer/all")
      .then((data) => {
        return data.json();
      })
      .then((data) => {
        console.log(data);
      });

    // axios.post('/', { fname, lname, email })
    //   .then((result) => {
    //     //access the results here....
    //   });
  };

  render() {
    const { fname, lname, email } = this.state;
    return (
      <React.Fragment>
        <h3>
          TODO - AA-2021 - I am working on the screen, soon it will publish.
        </h3>
        <form onSubmit={this.onSubmit}>
          <input
            type="text"
            name="fname"
            value={fname}
            onChange={this.onChange}
          />
          <input
            type="text"
            name="lname"
            value={lname}
            onChange={this.onChange}
          />
          <input
            type="text"
            name="email"
            value={email}
            onChange={this.onChange}
          />
          <button type="submit">Submit</button>
        </form>
      </React.Fragment>
    );
  }
}

export default Signup;
