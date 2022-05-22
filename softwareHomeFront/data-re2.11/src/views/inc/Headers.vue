<template>
  <header>
    <div class="l-content">
      <el-button
        plain
        icon="el-icon-menu"
        size="mini"
        @click="headleMenu"
      ></el-button>
      <h3 style="color: #fff">主页</h3>
    </div>
    <div class="r-content">
      <el-avatar
        src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
      ></el-avatar>
      <el-dropdown>
        <span class="el-dropdown-link">
          Admin<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item> 个人中心 </el-dropdown-item>
          <el-dropdown-item>退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </header>
</template>

<script>
export default {
  methods: {
    headleMenu () {
      this.$store.commit('collapseMenu')
    }
  }
}
</script>

<style lang="scss" scoped>
header {
  display: flex;
  height: 100%;
  align-items: center;
  justify-content: space-between;
}
.l-content {
  display: flex;
  align-items: center;
  .el-button {
    margin-right: 20px;
  }
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
</style>
