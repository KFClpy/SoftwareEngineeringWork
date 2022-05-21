<template>
  <el-row class="main" :gutter="20">
    <!-- <el-col :span="8" style="margin-top: 80px">
      <el-card shadow="hover" class="left-card">
        <div class="picture">
          <img :src="ourImg" />
          <div class="welcome">
            <p class="welcome1">欢迎使用!</p>
          </div>
        </div>
        <div class="useSimple">
          <p>首先请上传您需要修复的文件</p>
          <p>点击开始修复，您会看到相应折线图</p>
        </div>
      </el-card>
    </el-col> -->
    <el-col :span="20">
      <el-card shadow="hover" class="center-card1" style="height: 260px">
        <div
          id="main"
          style="width: 1000px; height: 260px; overflow: visible"
        ></div>
      </el-card>
    </el-col>
    <el-col :span="2">
      <el-card shadow="hover" class="right-card1">
        <el-button type="primary" @click="handleUpdate"
          >上传文件<i class="el-icon-upload el-icon--right"></i
        ></el-button>
        <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
          <span>
            <el-upload
              class="upload-demo"
              ref="upload"
              drag
              action="/api/data/upload"
              multiple
              :headers="headers"
              accept=".csv"
              :auto-upload="false"
              :limit="1"
              method="get"
              :on-success="handleFilUploadSuccess"
              :on-remove="handleRemove"
            >
              <i class="el-icon-upload"></i>
              <div class="el-upload__text">
                将文件拖到此处，或<em>点击上传</em>
              </div>
              <div class="el-upload__tip" slot="tip">只能上传 .csv 文件</div>
            </el-upload>
          </span>
          <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="handleUpload">确 定</el-button>
          </span>
        </el-dialog>
      </el-card>
    </el-col>
    <el-col :span="20">
      <el-card
        shadow="hover"
        class="center-card2"
        style="height: 300px; margin-top: 20px"
      >
        <div
          id="main1"
          style="width: 1000px; height: 260px; overflow: visible"
        ></div>
      </el-card>
    </el-col>
    <el-col :span="2">
      <el-card shadow="hover" class="right-card2">
        <el-button type="success" @click="startChange"
          >开始修复<i class="el-icon-s-opportunity el-icon--right"></i
        ></el-button>
        <el-dialog
          :visible.sync="dialogFormVisible"
          style="width: 1100px; margin-left: 20%; margin-top: 0%"
        >
          <div class="icon-order">
            <i class="el-icon-star-on"></i>
            <span class="icon-word">在开始修复之前请您设置部分重要参数</span>
          </div>
          <el-divider></el-divider>
          <el-form
            :model="settingForm"
            ref="settingForm"
            :rules="rules"
            label-position="left"
            label-width="110px"
          >
            <el-form-item
              label="阶数"
              prop="p"
              style="width: 320px; margin-left: auto; margin-right: auto"
            >
              <template>
                <el-select
                  v-model="settingForm.p"
                  clearable
                  placeholder="请选择阶数"
                >
                  <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                  >
                  </el-option>
                </el-select>
              </template>
            </el-form-item>
            <el-form-item
              label="接受阈值"
              prop="delta"
              style="width: 320px; margin-left: auto; margin-right: auto"
            >
              <el-input
                placeholder="请输入接受阈值，范围0~1"
                v-model="settingForm.delta"
                style="width: 250px"
              ></el-input>
            </el-form-item>
            <el-form-item
              label="最大迭代次数"
              prop="maxNumIterations"
              style="width: 320px; margin-left: auto; margin-right: auto"
            >
              <el-input
                placeholder="请输入最大迭代次数，需为正整数"
                v-model="settingForm.maxNumIterations"
                style="width: 250px"
                autocomplete="off"
              ></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="resetForm('settingForm')">重 置</el-button>
            <el-button type="primary" @click="confirmAddUser(settingForm)"
              >确 定</el-button
            >
          </div>
        </el-dialog>
      </el-card>
    </el-col>
    <el-col :span="4">
      <el-card shadow="hover" class="right-card3">
        <el-button type="warning" @click="getSomething"
          >获取文件<i class="el-icon-download el-icon--right"></i
        ></el-button>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
import Element, { Message } from "element-ui";
import * as echarts from "echarts";
export default {
  name: "Index",

  data() {
    return {
      str: {},
      str1: {},
      headers: {
        token: localStorage.getItem("token"),
      },
      settingForm: {
        p: "",
        delta: "",
        maxNumIterations: "",
      },
      dialogFormVisible: false,
      rules: {
        //表单验证
        p: [{ required: true, message: "请选择阶数", trigger: "blur" }],
        delta: [
          { required: true, message: "请输入接受阈值", trigger: "blur" },
          { validator: this.deltaRule, trigger: "blur" },
        ],
        maxNumIterations: [
          { required: true, message: "请输入最大迭代次数", trigger: "blur" },
        ],
      },
      options: [
        //下拉框选项
        {
          value: "1",
          label: "1",
        },
        {
          value: "2",
          label: "2",
        },
        {
          value: "3",
          label: "3",
        },
        {
          value: "4",
          label: "4",
        },
        {
          value: "5",
          label: "5",
        },
      ],
      ourImg: require("@/assets/logo.png"),
      dialogVisible: false,
      echartsData: {},
    };
  },
  methods: {
    deltaRule(rule, value, callback) {
      if (value) {
        if (value >= 1) {
          callback(new Error("接受阈值请控制在0-1之间"));
        } else if (value <= 0) {
          callback(new Error("接受阈值请控制在0-1之间"));
        } else {
          callback();
        }
      }
      callback();
    },
    startChange() {
      this.dialogFormVisible = true;
    },
    resetForm(settingForm) {
      this.$refs[settingForm].resetFields();
    },
    getSomething() {
      this.$axios({
        url: "/data/download",
        method: "post",
        responseType: "blob",
        params: {},
      })
        .then((res) => {
          if (!res || !res.data) {
            this.$message({
              type: "error",
              message: "导出失败！",
            });
            return;
          }
          let blob = new Blob([res.data]); //response.data为后端传的流文件
          let downloadFilename = "download" + ".csv"; //设置导出的文件名
          if (window.navigator && window.navigator.msSaveOrOpenBlob) {
            //兼容ie浏览器
            window.navigator.msSaveOrOpenBlob(blob, downloadFilename);
          } else {
            //谷歌,火狐等浏览器
            let url = window.URL.createObjectURL(blob);
            let downloadElement = document.createElement("a");
            downloadElement.style.display = "none";
            downloadElement.href = url;
            downloadElement.download = downloadFilename;
            document.body.appendChild(downloadElement);
            downloadElement.click();
            document.body.removeChild(downloadElement);
            window.URL.revokeObjectURL(url);
          }
          this.$message({ type: "success", message: "导出成功！" });
        })
        .catch((err) => {
          this.$message({
            type: "error",
            message: "导出失败！",
          });
        });
    },
    confirmAddUser(form) {
      this.$refs.settingForm.validate((valid) => {
        if (valid) {
          //表单验证通过
          console.log(form); //form就是form表单对象
          this.loading = true;
          this.$axios({
            url: "/data/repair",
            method: "post",
            params: {
              p: this.settingForm.p,
              delta: this.settingForm.delta,
              maxNumIterations: this.settingForm.maxNumIterations,
            },
          }).then((res) => {
            if (res.data.state === 2000) {
              this.loading = false;
              this.dialogFormVisible = false;
              this.$message({ message: "设置成功", type: "success" });
              var myChart = echarts.init(document.getElementById("main"));
              myChart.showLoading();
              setTimeout(() => {
                this.str = res.data;
                console.log(this.str);
                var obj = JSON.parse(JSON.stringify(this.str));
                console.log(obj);
                var timeSeries = obj.timeSeries;
                var timeSeries1 = obj.timeSeries1;
                var timeseries = timeSeries.timeseries;
                var timeseries1 = timeSeries1.timeseries;
                var timestamp = [];
                var data = [];
                var timestamp1 = [];
                var data1 = [];
                for (let i = 0; i < timeseries1.length; i++) {
                  timestamp1.push(timeseries1[i].timestamp);
                  data1.push(timeseries1[i].val);
                  timestamp.push(timeseries[i].timestamp);
                  data.push(timeseries[i].val);
                }
                var option = {
                  aria: {
                    show: true,
                  },
                  tooltip: {
                    show: true, // 是否显示
                    trigger: "axis", // 触发类型  'item'图形触发：散点图，饼图等无类目轴的图表中使用； 'axis'坐标轴触发；'none'：什么都不触发。
                    axisPointer: {
                      // 坐标轴指示器配置项。
                      type: "shadow", // 'line' 直线指示器  'shadow' 阴影指示器  'none' 无指示器  'cross' 十字准星指示器。
                      axis: "auto", // 指示器的坐标轴。
                      snap: true, // 坐标轴指示器是否自动吸附到点上
                    },
                    // showContent: true, //是否显示提示框浮层，默认显示。
                    // triggerOn: 'mouseover', // 触发时机  'mouseover'鼠标移动时触发。     'click'鼠标点击时触发。  'mousemove|click'同时鼠标移动和点击时触发。
                    // enterable: false, // 鼠标是否可进入提示框浮层中，默认为false，如需详情内交互，如添加链接，按钮，可设置为 true。
                    renderMode: "html", // 浮层的渲染模式，默认以 'html 即额外的 DOM 节点展示 tooltip；
                    backgroundColor: "rgba(50,50,50,0.7)", // 提示框浮层的背景颜色。
                    borderColor: "#333", // 提示框浮层的边框颜色。
                    borderWidth: 0, // 提示框浮层的边框宽。
                    padding: 5, // 提示框浮层内边距，
                    textStyle: {
                      // 提示框浮层的文本样式。
                      color: "#fff",
                      fontStyle: "normal",
                      fontWeight: "normal",
                      fontFamily: "sans-serif",
                      fontSize: 14,
                      align: "left",
                    },
                    extraCssText: "box-shadow: 0 0 3px rgba(0, 0, 0, 0.3);", // 额外附加到浮层的 css 样式
                    confine: true, // 是否将 tooltip 框限制在图表的区域内。
                  },
                  legend: {
                    textStyle: {
                      fontSize: 15,
                      color: "#000",
                    },
                    top: 30,
                    data: ["原数据", "修复数据"],
                  },
                  xAxis: {
                    name: "时\n间",
                    nameTextStyle: { fontSize: 18 },
                    scale: true,
                    type: "category",
                    data: timestamp,
                  },
                  yAxis: {
                    name: "值",
                    type: "value",
                    nameTextStyle: { fontSize: 18 },
                    scale: true,
                  },
                  series: [
                    {
                      name: "原数据",
                      type: "line",
                      data: data,
                    },
                    {
                      name: "修复数据",
                      type: "line",
                      data: data1,
                    },
                  ],
                };
                myChart.hideLoading();
                myChart.setOption(option);
              }, 1000);
              var myChart1 = echarts.init(document.getElementById("main1"));
              myChart1.showLoading();
              setTimeout(() => {
                this.str1 = res.data;
                var obj1 = JSON.parse(JSON.stringify(this.str1));
                var index = [];
                var wronglist = [];
                console.log(obj1);
                for (let i = 0; i < obj1.timeSeries1.wrongList.length; i++) {
                  index.push(i);
                  wronglist.push(obj1.timeSeries1.wrongList[i]);
                }
                var option1 = {
                  tooltip: {
                    show: true, // 是否显示
                    trigger: "axis", // 触发类型  'item'图形触发：散点图，饼图等无类目轴的图表中使用； 'axis'坐标轴触发；'none'：什么都不触发。
                    axisPointer: {
                      // 坐标轴指示器配置项。
                      type: "shadow", // 'line' 直线指示器  'shadow' 阴影指示器  'none' 无指示器  'cross' 十字准星指示器。
                      axis: "auto", // 指示器的坐标轴。
                      snap: true, // 坐标轴指示器是否自动吸附到点上
                    },
                    // showContent: true, //是否显示提示框浮层，默认显示。
                    // triggerOn: 'mouseover', // 触发时机  'mouseover'鼠标移动时触发。     'click'鼠标点击时触发。  'mousemove|click'同时鼠标移动和点击时触发。
                    // enterable: false, // 鼠标是否可进入提示框浮层中，默认为false，如需详情内交互，如添加链接，按钮，可设置为 true。
                    renderMode: "html", // 浮层的渲染模式，默认以 'html 即额外的 DOM 节点展示 tooltip；
                    backgroundColor: "rgba(50,50,50,0.7)", // 提示框浮层的背景颜色。
                    borderColor: "#333", // 提示框浮层的边框颜色。
                    borderWidth: 0, // 提示框浮层的边框宽。
                    padding: 5, // 提示框浮层内边距，
                    textStyle: {
                      // 提示框浮层的文本样式。
                      color: "#fff",
                      fontStyle: "normal",
                      fontWeight: "normal",
                      fontFamily: "sans-serif",
                      fontSize: 14,
                      align: "left",
                    },
                    extraCssText: "box-shadow: 0 0 3px rgba(0, 0, 0, 0.3);", // 额外附加到浮层的 css 样式
                    confine: true, // 是否将 tooltip 框限制在图表的区域内。
                  },
                  legend: {
                    textStyle: {
                      fontSize: 15,
                      color: "#000",
                    },
                    orent: "herizontal",
                    top: 30,
                    data: ["异常点数量"],
                  },
                  xAxis: {
                    name: "迭\n代\n次\n数\n",
                    nameTextStyle: { fontSize: 18 },
                    data: index,
                  },
                  yAxis: {
                    name: "数量",
                    nameTextStyle: { fontSize: 18 },
                  },
                  series: [
                    {
                      name: "异常点数量",
                      type: "line",
                      data: wronglist,
                    },
                  ],
                };
                myChart1.hideLoading();
                myChart1.setOption(option1);
              }, 1000);
            }else{
              Element.Message.error("出现了一些意料之外的错误,请稍后再试");
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    // 文件上传成功时的函数
    handleFilUploadSuccess(res) {
      console.log(res);
      this.$message.success("上传成功");
      var myChart = echarts.init(document.getElementById("main"));
      myChart.showLoading();
      setTimeout(() => {
        //需要延迟的代码 :3秒后延迟跳转到首页，可以加提示什么的
        this.str = res;
        console.log(this.str);
        var obj = JSON.parse(JSON.stringify(this.str));
        console.log(obj);
        var timeSeries = obj.timeSeries;
        console.log(timeSeries);
        var timeseries = timeSeries.timeseries;
        console.log(timeseries);
        var timestamp = [];
        var data = [];
        for (let i = 0; i < timeseries.length; i++) {
          timestamp.push(timeseries[i].timestamp);
          data.push(timeseries[i].val);
        }
        var option = {
          aria: {
            show: true,
          },
          tooltip: {
            show: true, // 是否显示
            trigger: "axis", // 触发类型  'item'图形触发：散点图，饼图等无类目轴的图表中使用； 'axis'坐标轴触发；'none'：什么都不触发。
            axisPointer: {
              // 坐标轴指示器配置项。
              type: "shadow", // 'line' 直线指示器  'shadow' 阴影指示器  'none' 无指示器  'cross' 十字准星指示器。
              axis: "auto", // 指示器的坐标轴。
              snap: true, // 坐标轴指示器是否自动吸附到点上
            },
            // showContent: true, //是否显示提示框浮层，默认显示。
            // triggerOn: 'mouseover', // 触发时机  'mouseover'鼠标移动时触发。     'click'鼠标点击时触发。  'mousemove|click'同时鼠标移动和点击时触发。
            // enterable: false, // 鼠标是否可进入提示框浮层中，默认为false，如需详情内交互，如添加链接，按钮，可设置为 true。
            renderMode: "html", // 浮层的渲染模式，默认以 'html 即额外的 DOM 节点展示 tooltip；
            backgroundColor: "rgba(50,50,50,0.7)", // 提示框浮层的背景颜色。
            borderColor: "#333", // 提示框浮层的边框颜色。
            borderWidth: 0, // 提示框浮层的边框宽。
            padding: 5, // 提示框浮层内边距，
            textStyle: {
              // 提示框浮层的文本样式。
              color: "#fff",
              fontStyle: "normal",
              fontWeight: "normal",
              fontFamily: "sans-serif",
              fontSize: 14,
              align: "left",
            },
            extraCssText: "box-shadow: 0 0 3px rgba(0, 0, 0, 0.3);", // 额外附加到浮层的 css 样式
            confine: true, // 是否将 tooltip 框限制在图表的区域内。
          },
          legend: {
            textStyle: {
              fontSize: 15,
              color: "#000",
            },
            top: 30,
            data: ["原数据", "修复数据"],
          },
          xAxis: {
            name: "时\n间",
            nameTextStyle: { fontSize: 18 },
            scale: true,
            type: "category",
            data: timestamp,
          },
          yAxis: {
            name: "值",
            type: "value",
            nameTextStyle: { fontSize: 18 },
            scale: true,
          },
          series: [
            {
              name: "原数据",
              type: "line",
              data: data,
            },
          ],
        };
        myChart.hideLoading();
        myChart.setOption(option);
        //延迟时间：2秒
      }, 1000);
    },
    handleUpdate() {
      this.dialogVisible = true;
    },
    // 处理文件上传的函数
    handleUpload() {
      // console.log(res,file)
      this.submitUpload();
      this.dialogVisible = false;
    },
  },
};
</script>

<style scoped>
.icon-word {
  font-weight: bold;
  color: #409eff;
  font-size: 20px;
}
.el-icon-star-on {
  font-size: 30px;
  color: red;
}
.picture {
  display: flex;
  align-items: center;
  padding-bottom: 20px;
  margin-bottom: 20px;
  border-bottom: 1px solid #ccc;
}
.welcome {
  font-size: 32px;
  margin-bottom: 10px;
  color: #999999;
}
.useSimple {
  color: #999999;
}
.right-card1 {
  width: 160px;
  height: 80px;
  margin-top: 120px;
  align-items: center;
}
.right-card2 {
  width: 160px;
  height: 80px;
  margin-top: 0px;
  align-items: center;
}
.right-card3 {
  width: 160px;
  height: 80px;
  margin-top: 60px;
  align-items: center;
}
.main {
  width: 100%;
  height: 100%;
}
</style>