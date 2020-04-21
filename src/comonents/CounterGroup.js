import React, { Component } from 'react';
import Counter from './Counter';
import { INIT_COUNTER_SIZE } from "../constants/contants"
import './CounterGroup.css';

class CounterGroup extends Component {
  constructor(props) {
    super(props);

    this.onChange = this.onChange.bind(this);
    this.state = {
      size: INIT_COUNTER_SIZE,
    }
  }
  
  initArray(size) {
    return Array.from(Array(size).keys());
  }

  onChange(event) {
    const value = event.target.value;
      this.setState({
        size: value.length > 0 ? parseInt(value) : 0,
      });
  }


  render() {
    let counters = this.initArray(this.state.size);
    return (
      <div>
        <form>
          Number of counters:&nbsp;&nbsp;
          <input onChange={this.onChange} type="text" value={this.state.size} size="5" maxLength="3"/>
        </form>
        {
          counters.map((value) =>(
            <Counter key={value} />
          ))}
      </div>
    );
  }
}

export default CounterGroup;