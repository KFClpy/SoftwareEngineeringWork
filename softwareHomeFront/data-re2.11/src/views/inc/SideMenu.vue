<template>
  <el-menu
    class="el-menu-vertical-demo"
    @open="handleOpen"
    @close="handleClose"
    :collapse="isCollapse"
    :collapse-transition="true"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
  >
    <h3 v-show="!isCollapse">数据修复系统</h3>
    <h3 v-show="isCollapse">功能</h3>
    <el-menu-item
      :index="item.path"
      v-for="item in noChildren"
      :key="item.path"
      @click="clickMenu(item)"
    >
      <i :class="'el-icon-' + item.icon"></i>
      <span slot="title">{{ item.label }}</span> </el-menu-item
    ><el-submenu
      :index="item.label"
      v-for="item in hasChildren"
      :key="item.path"
    >
      <template slot="title">
        <i :class="'el-icon-' + item.icon"></i>
        <span slot="title">{{ item.label }}</span>
      </template>
      <el-menu-item-group>
        <el-menu-item
          :index="subItem.path"
          v-for="(subItem, subIndex) in item.children"
          :key="subIndex"
          @click="clickMenu(subItem)"
        >
          <i :class="'el-icon-' + subItem.icon"></i>
          <span slot="title">{{ subItem.label }}</span>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  data() {
    return {
      menu: [
        {
          path: "/index",
          name: "Index",
          label: "主页",
          icon: "s-home",
        },
        {
          path: "/sys/user",
          name: "SysUser",
          label: "用户信息",
          icon: "user",
        },
        {
          label: "其他",
          icon: "s-unfold",
          children: [
            {
              path: "sys/help",
              name: "SysHelp",
              label: "帮助",
              icon: "tickets",
            },
            {
              path: "sys/ours",
              name: "SysOurs",
              label: "关于我们",
              icon: "user-solid",
            },
          ],
        },
      ],
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    clickMenu(item) {
      this.$router.push({ name: item.name });
      this.$store.commit("selectMenu", item);
    },
  },
  computed: {
    noChildren() {
      return this.menu.filter((item) => !item.children);
    },
    hasChildren() {
      return this.menu.filter((item) => item.children);
    },
    isCollapse() {
      return this.$store.state.tab.isCollapse;
    },
  },
};
</script>

<style lang="scss" scoped>
//侧边栏动画速度
.horizontal-collapse-transition {
  transition: 0.25s width ease-in-out, 0.25s padding-left ease-in-out,
    0.25s padding-right ease-in-out;
}
.el-menu {
  height: 100vh;
  border: none;
  h3 {
    color: #ffffff;
    text-align: center;
    line-height: 48px;
  }
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
  height:100%;
}
</style>