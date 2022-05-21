import axios from "axios";
import router from "./router";
import Element, { Message } from "element-ui";

axios.defaults.baseURL = "http://127.0.0.1:8083";

const request = axios.create({
  timeout: 5000,
  headers: {
    "Content-Type": "application/json; charset=utf-8",
  },
});

// request.interceptors.request.use(config => {
// 	// config.headers['Authorization'] = localStorage.getItem("token")
// 	// return config
// 	const token =localStorage.getItem('token')
// 	if (token)
// 		config.headers.Authorization =token;
// 	  return config;
// },
// err => {
//     return Promise.reject(err);
//   }
// )

request.interceptors.response.use(
  response => {
    // // console.log("response ->" + response);
    // const res = response.data;
    // if (res.state === 2000) {
    //   return res;
    // }else {
    //   Element.Message.error("系统异常");
    //   return Promise.reject(new Error ("Error"));
    // }
  },
  error => {
  	console.log(error)
  	if (error.response.data) {
  		error.massage = error.response.data.msg
  	}
  	if (error.response.status === 401) {
      Element.Message.error("401");
  	}
  	Element.Message.error(error.massage, {duration: 3000})
  	return Promise.reject(error)
  }
);

// request.interceptors.response.use(
// 	(response) =>response,
// 	(error) =>{
//     console.dir(error)
//     return Promise.reject(error)
//   }
//   );
export default request;
