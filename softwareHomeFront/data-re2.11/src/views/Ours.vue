<template>
  <div class="main">
    <el-row>
      <el-col :span="8"
      ><el-card shadow="hover" class="card"
      ><div class="grid-content bg-purple">

        <i class="el-icon-s-promotion"></i>
        <h3 style="color:#409EFF">愿景</h3>
        <p style="color:#5151A2">成为当前最优秀的一体化网络抽奖平台</p>

      </div></el-card
      ></el-col
      >
      <el-col :span="8"
      ><el-card shadow="hover" class="card"
      ><div class="grid-content bg-purple-light">

        <i class="el-icon-s-check"></i>
        <h3 style="color:#409EFF">使命</h3>
        <p style="color:#5151A2">好好抽奖，好好生活</p>

      </div></el-card
      ></el-col
      >
      <el-col :span="8"
      ><el-card shadow="hover" class="card"
      ><div class="grid-content bg-purple">

        <i class="el-icon-s-opportunity"></i>
        <h3 style="color:#409EFF">核心价值</h3>
        <p style="color:#5151A2">
          德能并进 勇毅翔远<br />自强不息 知行合一<br />创造分享 共同成长
        </p>

      </div></el-card
      ></el-col
      >
    </el-row>
  </div>

</template>

<script>
export default {
  name: "Ours",
  data() {
    return {
      value: null,
      colors: ["#99A9BF", "#F7BA2A", "#FF9900"],
    };
  },
};
</script>

<style scoped>
.card {
  height: 390px;
  margin-right: 30px;
  margin-left: 30px;
  margin-top: 70px;
  box-shadow: #409eff 3px 1000px 3px 3px;
}
.el-icon-s-promotion {
  font-size: 70px;
  color: #FFA500;
}
.el-icon-s-check {
  font-size: 70px;
  color: #FFA500;
}
.el-icon-s-opportunity {
  font-size: 70px;
  color: #FFA500;
}
.main{
  height: 81.9vh;
}
</style>
