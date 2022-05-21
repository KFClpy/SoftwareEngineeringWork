import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Index from "../views/Index.vue";
import Setting from "../views/sys/Setting.vue";
import History from "../views/sys/History.vue";
import User from "../views/sys/User.vue";
import Help from "../views/sys/Help.vue";
import Ours from "../views/sys/Ours.vue";
import Register from "../views/Register.vue";
const originPush = VueRouter.prototype.push
VueRouter.prototype.push=function push (location){
  return originPush.call(this,location).catch(err=>err)
}
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    meta: {
      requireAuth: true, 
    },
    component: Home,
    children: [
      {
        path: "/index",
        name: "Index",
        meta: {
          requireAuth: true, 
        },
        component: Index,
      },
      {
        path: "/userCenter",
        name: "UserCenter",
        meta: {
          requireAuth: true, 
        },
        component: () => import("../views/UserCenter.vue"),
      },
      {
        path: "sys/setting",
        name: "SysSetting",
        meta: {
          requireAuth: true, 
        },
        component: Setting,
      },
      {
        path: "sys/history",
        name: "SysHistory",
        meta: {
          requireAuth: true, 
        },
        component: History,
      },
      {
        path: "sys/user",
        name: "SysUser",
        meta: {
          requireAuth: true, 
        },
        component: User,
      },
      {
        path: "sys/help",
        name: "SysHelp",
        meta: {
          requireAuth: true, 
        },
        component: Help,
      },
      {
        path: "sys/ours",
        name: "SysOurs",
        meta: {
          requireAuth: true, 
        },
        component: Ours,
      },
    ],
  },

  {
    path: "/login",
    name: "Login",
    component: () => import("../views/Login.vue"),
  },

  {
    path: "/register",
    name: "Register",
    component: () => import("../views/Register.vue"),
  },

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
