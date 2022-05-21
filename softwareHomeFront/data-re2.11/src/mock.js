// const Mock = require("mockjs");
//
// const Random = Mock.Random;
//
// let Result = {
//   state: 2000,
//   msg: "",
//   data: null,
// };
//
// Mock.mock(RegExp("/api/sys/user/save*"), "post", () => {
//   return Result;
// });
//
// Mock.mock(RegExp("/api/sys/user/updata*"), "post", () => {
//   return Result;
// });
//
// // Mock.mock(RegExp("/api/info/deleteInfo*"), "post", () => {
// //   return Result;
// // });
//
// Mock.mock(RegExp("/api/info/updataInfo"), "post", () => {
//   return Result;
// });
//
// Mock.mock(RegExp("/api/info/table*"), "post", () => {
//   Result.data = {
//     table: [
//       {
//         id: 1,
//
//         name: "孟庆鑫",
//         gender: 1,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 520,
//
//         name: "乃琳",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//       {
//         id: 521,
//
//         name: "嘉然",
//         gender: 2,
//         phone: "15754295425",
//         email: "jg79805425@sina.cn",
//       },
//
//     ],
//   };
//   return Result;
// });
//
// // // Mock.mock('/captcha','get',()=>{
// // //     Result.data ={
// // //         token:Random.string(32),
// // //         captchaImg:Random.dataImage('120x40', 'p7n5w')
// // //     }
// // //     return Result
// // // })
//
// // Mock.mock('/api/users/reg','post',() =>{
// //     Result.state=2000
// //     Result.msg="注册错误"
// //     return Result
// // })
//
// // Mock.mock('/api/users/login','post',() =>{
// //     Result.state=2000
// //     Result.msg="登录失败"
// //     return Result
// // })
//
// Mock.mock("/api/users/userInfo", "get", () => {
//   Result.data = {
//     avatar: "",
//     name: "",
//     tel: "",
//     gender: "",
//     other: "",
//     email: "",
//   };
//   return Result;
// });
//
// // Mock.mock('/api/data/repair','post',() =>{
// //     Result.code=200
// //     Result.msg=""
// //     return Result
// // })
// // // Mock.mock('/logout','post',() =>{
// // //     //退出测试
// // //     return Result
// // // })
//
// // //  import Mock from 'mock.js'
//
// // // Mock.mock('/index',{
//
// // // })
