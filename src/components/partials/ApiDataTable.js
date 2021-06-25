import React, { Component } from "react";
import Table from "react-bootstrap/Table";

export default class ApiDataTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      customersListInChild: [],
      isLoaded: false,
    };
  }

  componentDidMount() {
    //console.log(this.props.customersList);
    if (this.props.customersList) {
      this.setState({
        customersListInChild: this.props.customersList,
      });
    }
  }

  //   componentDidUpdate(prevProps) {
  //     //console.log(this.props.customersList);
  //     if (prevProps.customersListInChild !== this.props.customersList) {
  //       this.setState({
  //         customersListInChild: this.props.customersList,
  //       });
  //     }
  //   }

  render() {
    const customers = this.state.customersListInChild;

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
                <th>EmailAddress</th>
                <th width="160px">Phone</th>
                <th width="200px">City</th>
                <th>State/Prov</th>
                <th width="300px">Last Update</th>
              </tr>
            </thead>
            <tbody>
              {customers.map((oneCustomer) => (
                <tr key={oneCustomer.customerId}>
                  <td>{oneCustomer.customerId}</td>
                  <td>{oneCustomer.firstName}</td>
                  <td>{oneCustomer.lastName}</td>
                  <td>{oneCustomer.emailAddress}</td>
                  <td>{oneCustomer.phone}</td>
                  <td>{oneCustomer.city}</td>
                  <td>{oneCustomer.stateProvince}</td>
                  <td>{oneCustomer.lastUpdate}</td>
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
