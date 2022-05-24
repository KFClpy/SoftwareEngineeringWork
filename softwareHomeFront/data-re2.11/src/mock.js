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
// Mock.mock(RegExp("/api/info/addInfo*"), "post", () => {
//   return Result;
// });
//
// // Mock.mock(RegExp("/api/info/deleteInfo*"), "post", () => {
// //   return Result;
// // });
//
// Mock.mock(RegExp("/api/info/updataInfo*"), "post", () => {
//   return Result;
// });
//
// Mock.mock(RegExp("/api/info/fillTable?mid=*"), "post", () => {
//   return Result;
// });
//
// Mock.mock(RegExp("/api/info/table*"), "post", () => {
//   Result.data = {
//     table: [
//       {
//         id: 1,
//         name: "孟庆鑫",
//         prizenum: 1,
//         details: "好好好",
//         imageurl: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
//       },
//       {
//         id: 520,
//         name: "乃琳",
//         prizenum: 1,
//         details: "好好好",
//         imageurl: "https://img2.baidu.com/it/u=355089164,524391608&fm=253&fmt=auto&app=138&f=JPEG?w=708&h=500",
//       },
//       {
//         id: 521,
//         name: "嘉然",
//         prizenum: 1,
//         details: "好好好",
//         imageurl: "https://img1.baidu.com/it/u=152576508,2736311163&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=329",
//       },
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
