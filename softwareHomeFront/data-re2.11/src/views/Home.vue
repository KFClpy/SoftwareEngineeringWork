<template>
  <el-container style="height: 100%">
    <el-aside width="auto">
      <side-menu></side-menu>
    </el-aside>
    <el-container>
      <el-header style="height: 65px">
        <div class="l-content">
          <el-button
            plain
            icon="el-icon-menu"
            size="mini"
            @click="headleMenu"
          ></el-button>
          <el-breadcrumb>
            <el-breadcrumb-item :to="{ path: '/index' }">主页</el-breadcrumb-item>
            <el-breadcrumb-item :to="current.path" v-if="current"><a style="color:#ffd04b">{{current.label}}</a></el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <div class="r-content">
          <el-avatar :src="userInfo.avatar"></el-avatar>
          <el-dropdown>
            <span class="el-dropdown-link">
              {{ userInfo.name
              }}
              <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>
                <router-link to="/userCenter">个人中心</router-link>
              </el-dropdown-item>
              <el-dropdown-item @click.native="logout">退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </el-header>
      <common-tag></common-tag>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import { mapState } from "vuex";
import SideMenu from "./inc/SideMenu.vue";
import CommonTag from "../components/CommonTag.vue";
export default {
  name: "Home",
  components: {
    SideMenu,CommonTag
  },
  data() {
    return {
      userInfo: {
        avatar: "",
        name: "",
        tel: "",
        sex: "",
        other: "",
        email: "",
      },
    };
  },
  created() {
    this.getUserInfo();
  },
  methods: {
    headleMenu() {
      this.$store.commit("collapseMenu");
    },
    getUserInfo() {
      this.$axios.get("/users/userInfo").then((res) => {
        this.userInfo = res.data;
        console.log(res,this.userInfo)
      });
    },
    logout() {
      this.$axios.post("/users/logout").then((res) => {
        localStorage.clear();
        sessionStorage.clear();

        this.$store.commit("resetState");

        this.$router.push("/login");
      });
    },
  },
  computed: {
    ...mapState({
      current: (state) => state.tab.currentMenu,
    }),
  },
};
</script>

<style scoped>
.el-container {
  padding: 0;
  margin: 0;
  height: 100%;
}
.el-dropdown-link {
  cursor: pointer;
}
.el-header {
  background-color: #333;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  line-height: 200px;
}

.el-main {
  color: #333;
  text-align: center;
  padding: 0px;
}
header {
  display: flex;
  height: 100%;
  align-items: center;
  justify-content: space-between;
}
.l-content {
  display: flex;
  align-items: center;
}
.el-button {
  margin-right: 20px;
}
.r-content {
  float: right;
  width: 130px;
  display: flex;
  justify-content: space-around;
  align-items: center;
}
.el-dropdown-link {
  cursor: pointer;
  color: #fff;
}
a {
  text-decoration: none;
}
.el-breadcrumb  /deep/  .el-breadcrumb__inner 
      {
        color:white !important;	
    }

</style>
