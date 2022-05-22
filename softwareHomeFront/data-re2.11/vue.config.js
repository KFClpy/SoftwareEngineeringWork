module.exports = {
  lintOnSave: false
}

// module.exports = {
//   productionSourceMap: false,
//   devServer: {
//     // 跨域
//     proxy: {
//       '/api': {
//         target: 'http://127.0.0.1:8083', // 路径指向本地主机地址及端口号
//         changeOrigin: true, // 准许跨域
//         // 路径重写
//         pathRewrite: {
//           // 重写路径，当我们在浏览器中看到请求的地址为：
//           // http://localhost:8080/api/frontend/experts/getlist 时
//           // 实际上访问的地址是：
//           // http://localhost:8081/dong-guan-project/tp6-dgjx/public/index.php/frontend/experts/getlist
//           // 因为重写了 /api
//           '^/api': '' // 路径转发代理
//         }
//       }
//     }
//   },
//   configureWebpack: config => {
//     // 为生产环境修改配置...
//     if (process.env.NODE_ENV === 'production') {
//       config.mode = 'production'
//       // 打包文件大小配置
//       config.performance = {
//         maxEntrypointSize: 10000000,
//         maxAssetSize: 30000000
//       }
//     }
//   }
// }
