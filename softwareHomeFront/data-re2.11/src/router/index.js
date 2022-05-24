import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Index from "../views/Index.vue";
import Setting from "../views/Setting.vue";
import History from "../views/History.vue";
import User from "../views/User.vue";
import Help from "../views/Help.vue";
import Ours from "../views/Ours.vue";
import Prize from "../views/Prize.vue";
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
        path: "Prize",
        name: "SysPrize",
        meta: {
          requireAuth: true,
        },
        component: Prize
      },
      {
        path: "setting",
        name: "SysSetting",
        meta: {
          requireAuth: true,
        },
        component: Setting,
      },
      {
        path: "history",
        name: "SysHistory",
        meta: {
          requireAuth: true,
        },
        component: History,
      },
      {
        path: "user",
        name: "SysUser",
        meta: {
          requireAuth: true,
        },
        component: User,
      },
      {
        path: "help",
        name: "SysHelp",
        meta: {
          requireAuth: true,
        },
        component: Help,
      },
      {
        path: "ours",
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
