import Vue from "vue";
import store from "./store";
import axios from "axios";
import Element from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import App from "./App.vue";
import router from "./router";
axios.defaults.baseURL = "/api"
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (localStorage.token) {
      console.log("token存在");
      next();
    } else {
      console.log("token不存在");
      next({
        path: "/login",
        query: { redirect: to.fullPath },
      });
    }
  } else {
    next();
  }
});

Vue.prototype.$axios = axios;
Vue.config.productionTip = false;
axios.interceptors.request.use(
  (config) => {
    let token = localStorage.getItem('token');//这个是登录时存进本地环境的token
    console.log(token);
    console.log(!token);
    if(typeof(token)!='undefined')config.headers.token=token;
    return config
  },
)
require("./mock.js");

Vue.use(Element);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
