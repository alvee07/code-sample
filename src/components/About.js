import React, { Component } from "react";

export class About extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoaded: false,
      error: null,
      dataFetched: false,
      data: [],
    };
  }

  componentDidMount() {
    fetch("https://alveeapi.azurewebsites.net/weatherforecast", {
      method: "get",
      //body: JSON.stringify(body),
    })
      .then((res) => res.json())
      .then(
        (response) => {
          this.setState({
            dataFetched: true,
            data: response.data,
            isLoaded: true,
          });
        },
        (error) => {
          this.setState({
            dataFetched: true,
            error,
          });
        }
      );
  }

  render() {
    const { error, data } = this.state;
    if (error) {
      return <div>Error: {error.message}</div>;
    } else if (!this.state.isLoaded) {
      return <div>Loading...</div>;
    } else {
      return 
        <React.render>
          {data.map((item, i) => {
            return <h1>item.date</h1>
          })}
        </React.render>
      
      // {
      //   data.map((item, i) => {
      //     return <h1>item.date</h1>;
      //   });
      // }
    }
  }
}

export default About;
