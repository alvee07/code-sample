import React, { Component } from "react";
import Table from "react-bootstrap/Table";

export default class ApiDataTable extends Component {
  constructor(props) {
    super(props);

    this.state = {
      customers: [],
    };
  }

  render() {
    const { customers } = this.state.props.customersList;

    var body;
    if (customers) {
      body = (
        <div>
          <Table striped bordered hover size="sm">
            <thead>
              <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>EmailAddress</th>
                <th>Phone</th>
                <th>City</th>
                <th>State/Prov</th>
                <th>Last Update</th>
              </tr>
            </thead>
            <tbody>
              {customers.map((oneCustomer) => (
                <tr key={oneCustomer.customerId}>
                  <td>{oneCustomer.firstName}</td>
                  <td>{oneCustomer.lastName}</td>
                  <td>{oneCustomer.emailAddress}</td>
                  <td>{oneCustomer.phone}</td>
                  <td>{oneCustomer.city}</td>
                  <td>{oneCustomer.stateProvince}</td>
                  <td>{oneCustomer.lastUpdate}</td>
                  <td>@mdo</td>
                </tr>
              ))}
            </tbody>
          </Table>
        </div>
      );
    } else {
      body = <div></div>;
    }
    return body;
  }
}
