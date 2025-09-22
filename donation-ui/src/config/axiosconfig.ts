import axios from "axios";


const apiGateway = axios.create({
  baseURL: 'http://localhost:8080'
});

export default apiGateway;
