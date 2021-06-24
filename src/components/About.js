import React, { Component } from "react";

// use this to get and render the data
// https://soshace.com/react-and-ajax-the-art-of-fetching-data-in-react/
export class About extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoaded: false,
      error: null,
      items: [],
    };
  }

  componentDidMount() {
    var xhr = new XMLHttpRequest();

    xhr.addEventListener("readystatechange", () => {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
          // request successful
          var response = xhr.responseText,
            json = JSON.parse(response);
          //console.log(json);
          this.setState({
            isLoaded: true,
            items: json,
          });
        } else {
          // error
          this.setState({
            isLoaded: true,
            error: xhr.responseText,
          });
        }
      }
    });

    xhr.open(
      "GET",
      "https://alveeapi.azurewebsites.net/api/customer/all",
      true
    );
    xhr.send();
  }
  render() {
    var body;

    if (!this.state.isLoaded) {
      // yet loading
      body = <div>Loading...</div>;
    } else if (this.state.error) {
      // error
      body = <div>Error occured: {this.state.error}</div>;
    } else {
      // success

      var items = this.state.items.map((item) => (
        <div key={item.customerId}>
          <p>
            {item.firstName} {"--"} {item.lastName}
          </p>
          <p></p>
        </div>
      ));

      body = <div>{items}</div>;
    }

    return body;
  }
}

export default About;
