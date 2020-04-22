import axios from 'axios';

class CounterApi {
  static getCounterSize() {
    const COUNTER_GET_API_URL = "https://5e9ed3a0fb467500166c47b3.mockapi.io/counters";
    return axios.get(COUNTER_GET_API_URL);
  }

  static putCounterSize(size) {
    const COUNTER_PUT_API_URL = "https://5e9ed3a0fb467500166c47b3.mockapi.io/counters/1";
    return axios.put(COUNTER_PUT_API_URL, {size: size});
  }
}

export default CounterApi;