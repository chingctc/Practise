import React, { Component } from 'react';
import Counter from './Counter';
import CounterApi from './../apis/CounterApi'
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
    const size = event.target.value.length > 0? parseInt(event.target.value) : 0;
    CounterApi.putCounterSize(size).then((response)=>{
      const value = response.data.size;
      this.setState({
        size: value,
        sum: 0,
      });
    })
  }

  onCalculate(different) {
    this.setState((prevState) => {
      return {
        sum: prevState.sum + different,
      };
    });
  }

  componentDidMount() {
    CounterApi.getCounterSize().then((response) => {
      const Counntersize = response.data.size;
      this.setState({ size: Counntersize });
    })
  }

  render() {
    let counters = this.initArray(this.state.size);
    return (
      <div>
        <form>
          <label>Generate &nbsp;&nbsp;</label>
          <input onChange={this.onChange} type="text" value={this.state.size} size="5" maxLength="3"/>
          <label>&nbsp;&nbsp;Counters</label>
          <label><br></br>Sum of all counters = </label>
          <span id="counterSum"> {this.state.sum} </span>
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