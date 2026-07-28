import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor() {
    super();
    this.state = {
      amount: "",
      currency: "Euro"
    };
  }

  handleChange = (e) => {
    this.setState({
      amount: e.target.value
    });
  };

  handleSubmit = (e) => {
    e.preventDefault();

    const euro = this.state.amount / 90;

    alert("Converting to Euro Amount is " + euro.toFixed(2));
  };

  render() {
    return (
      <div>
        <h1 style={{ color: "green" }}>Currency Convertor!!!</h1>

        <form onSubmit={this.handleSubmit}>
          <table>
            <tbody>
              <tr>
                <td>Amount:</td>
                <td>
                  <input
                    type="number"
                    value={this.state.amount}
                    onChange={this.handleChange}
                  />
                </td>
              </tr>

              <tr>
                <td>Currency:</td>
                <td>
                  <input
                    type="text"
                    value={this.state.currency}
                    readOnly
                  />
                </td>
              </tr>

              <tr>
                <td></td>
                <td>
                  <button type="submit">Submit</button>
                </td>
              </tr>
            </tbody>
          </table>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;