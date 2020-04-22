import React, { Component } from 'react';
import Counter from './Counter';
import PropTypes from 'prop-types';
import { INIT_COUNTER_SIZE } from "../constants/contants"
import './CounterGroup.css';

class CounterGroup extends Component {
  constructor(props) {
    super(props);

    this.onChange = this.onChange.bind(this);
    this.onCalculate = this.onCalculate.bind(this);
    this.state = {
      size: INIT_COUNTER_SIZE,
      sum: 0
    }
  }
  
  initArray(size) {
    return Array.from(Array(size).keys());
  }

  onChange(event) {
    const value = event.target.value;
      this.setState({
        size: value.length > 0 ? parseInt(value) : 0,
        sum: 0,
      });
  }

  onCalculate(different) {
    this.setState((prevState) => {
      return {
        sum: prevState.sum + different,
      };
    });
  }

  render() {
    let counters = this.initArray(this.state.size);
    return (
      <div>
        <form>
          <label>Generate &nbsp;&nbsp;</label>
          <input onChange={this.onChange} type="text" value={this.state.size} size="5" maxLength="3"/>
          <label>&nbsp;&nbsp;Counters</label>
          <label><br></br>Sum of all counters = {this.state.sum}</label>
        </form>
        { 
          counters.map((value) =>(
            <Counter 
            key = {value} 
            size={this.state.size}
            onCalculate = {this.onCalculate}
            />
          ))}
      </div>
    );
  }
}

export default CounterGroup;