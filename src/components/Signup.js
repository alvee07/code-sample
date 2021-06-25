import React, { Component } from "react";
import { Form, Button } from "react-bootstrap";

export class Signup extends Component {
  constructor(props) {
    super(props);

    this.state = {};

    this.submitHandler = this.submitHandler.bind(this);
    this.emailChangeHandler = this.emailChangeHandler.bind(this);
  }

  submitHandler(event) {
    event.preventDefault();
    console.log("Submit but not reload ");
  }

  emailChangeHandler(event) {
    console.log(event.target.value);
  }

  render() {
    return (
      <React.Fragment>
        <h3>
          TODO - AA-2021 - I am working on the screen, soon it will publish.
        </h3>
        <Form onSubmit={this.submitHandler.bind(this)}>
          <Form.Group controlId="formBasicEmail">
            <Form.Label>Email address</Form.Label>
            <Form.Control
              type="email"
              placeholder="Enter email"
              onChange={this.emailChangeHandler.bind(this)}
            />
            <Form.Text className="text-muted">
              We'll never share your email with anyone else.
            </Form.Text>
          </Form.Group>

          <Form.Group controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control type="password" placeholder="Password" />
          </Form.Group>
          <Form.Group controlId="formBasicCheckbox">
            <Form.Check type="checkbox" label="Check me out" />
          </Form.Group>
          <Button variant="primary" type="submit">
            Submit
          </Button>
        </Form>
      </React.Fragment>
    );
  }
}

export default Signup;
