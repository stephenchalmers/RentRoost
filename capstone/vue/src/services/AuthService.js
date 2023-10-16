import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8080/'
export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  }

}
