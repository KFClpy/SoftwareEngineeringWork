<template>
  <el-row class="Center" :gutter="10">
    <el-col :span="12" style="margin-top: 0px; margin-left: 25%">
      <el-card shadow="hover" class="left-card">
        <div class="icon-order">
          <i class="el-icon-s-order"></i>
          <span class="icon-word">个人信息</span>
        </div>
        <el-divider></el-divider>
        <div>
          <my-upload
            @crop-success="cropSuccess"
            @crop-upload-success="cropUploadSuccess"
            @crop-upload-fail="cropUploadFail"
            :modelValue.sync="show"
            :width="200"
            :height="200"
            img-format="png"
            :size="size"
            langType="zh"
            :headers="headers"
            :noRotate="false"
            field="file"
            url="/api/users/updateAvatar"
            method="POST"
            :withCredentials="true"
          ></my-upload>
          <img
            v-if="userInfo.avatar === ''"
            src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
            @click="toggleShow"
            alt="点击上传头像"
            class="content"
          />
          <img
            v-if="userInfo.avatar != ''"
            :src="userInfo.avatar"
            @click="toggleShow"
            alt="点击上传头像"
            class="content"
          />
        </div>
        <el-descriptions class="margin-top" :column="3" border>
          <template slot="extra">
            <el-button type="primary" size="small" @click="modify"
              >编辑</el-button
            >
            <el-dialog
              :visible.sync="dialogFormVisible"
              style="width: 1100px; margin-left: 20%; margin-top: 0%"
            >
              <div class="icon-order">
                <i class="el-icon-s-order"></i>
                <span class="icon-word">修改信息</span>
              </div>
              <el-divider></el-divider>
              <el-form
                :model="userForm"
                ref="userForm"
                :rules="rules"
                label-position="left"
                label-width="80px"
              >
                <el-form-item
                  label="昵称"
                  prop="name"
                  style="width: 320px; margin-left: auto; margin-right: auto"
                >
                  <el-input
                    v-model="userForm.name"
                    style="width: 250px"
                    autocomplete="off"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="手机号码"
                  prop="tel"
                  style="width: 320px; margin-left: auto; margin-right: auto"
                >
                  <el-input
                    v-model="userForm.tel"
                    style="width: 250px"
                  ></el-input>
                </el-form-item>
                <el-form-item
                  label="性别"
                  prop="sex"
                  style="width: 320px; margin-left: auto; margin-right: auto"
                >
                  <template>
                    <el-select
                      v-model="userForm.sex"
                      clearable
                      placeholder="请选择性别"
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
                  label="备注"
                  prop="other"
                  style="width: 320px; margin-left: auto; margin-right: auto"
                >
                  <template>
                    <el-select
                      v-model="userForm.other"
                      clearable
                      placeholder="请选择备注"
                    >
                      <el-option
                        v-for="item in options2"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                      >
                      </el-option>
                    </el-select>
                  </template>
                </el-form-item>
                <el-form-item
                  label="电子邮箱"
                  prop="email"
                  style="width: 320px; margin-left: auto; margin-right: auto"
                >
                  <el-input
                    v-model="userForm.email"
                    style="width: 250px"
                  ></el-input>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="resetForm('userForm')">重 置</el-button>
                <el-button type="primary" @click="confirmAddUser(userForm)"
                  >确 定</el-button
                >
              </div>
            </el-dialog>
          </template>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-user"></i>
              昵称
            </template>
            <p v-if="userInfo.name == ''">未知</p>
            {{ userInfo.name }}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-mobile-phone"></i>
              手机号码
            </template>
            <p v-if="userInfo.tel == ''">未知</p>
            {{ userInfo.tel }}
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-male"></i>
              性别
              <i class="el-icon-female"></i>
            </template>
            <p v-if="userInfo.sex == ''">未知</p>
            <p v-if="userInfo.sex == 1">男</p>
            <p v-if="userInfo.sex == 2">女</p>
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-tickets"></i>
              备注
            </template>
            <el-tag size="small" v-if="userInfo.other == ''"> 未知 </el-tag>
            <el-tag size="small" v-if="userInfo.other == '1'">学生</el-tag>
            <el-tag size="small" v-if="userInfo.other == '2'">教师</el-tag>
            <el-tag size="small" v-if="userInfo.other == '3'">其他</el-tag>
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-office-building"></i>
              电子邮箱
            </template>
            <p v-if="userInfo.email == ''">未知</p>
            {{ userInfo.email }}
          </el-descriptions-item>
        </el-descriptions>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
import Element, { Message } from "element-ui";
import "babel-polyfill"; // es6 shim
import myUpload from "vue-image-crop-upload";
export default {
  name: "UserCenter",
  data() {
    return {
      headers: {
        token: localStorage.getItem("token"),
      },
      show: false,
      size: 2.1,
      userInfo: {
        avatar: "",
        name: "",
        tel: "",
        sex: "",
        other: "",
        email: "",
      },
      userForm: {
        name: "",
        tel: "",
        sex: "",
        other: "",
        email: "",
      },
      dialogFormVisible: false,
      rules: {
        //表单验证
        name: [{ required: true, message: "请输入昵称", trigger: "blur" }],
        tel: [{ required: true, message: "请输入手机号码", trigger: "blur" }],
        sex: [{ required: true, message: "请选择用户性别", trigger: "blur" }],
        other: [{ required: true, message: "请选择用户备注", trigger: "blur" }],
        email: [{ required: true, message: "请输入电子邮箱", trigger: "blur" }],
      },
      options: [
        //下拉框选项
        {
          value: "1",
          label: "男",
        },
        {
          value: "2",
          label: "女",
        },
      ],
      options2: [
        //下拉框选项
        {
          value: "1",
          label: "学生",
        },
        {
          value: "2",
          label: "教师",
        },
        {
          value: "3",
          label: "其他",
        },
      ],
    };
  },
  components: {
    "my-upload": myUpload,
  },
  created() {
    this.getUserInfo();
  },
  methods: {
    toggleShow() {
      this.show = !this.show;
    },
    cropSuccess(imgDataUrl, field) {
      this.userInfo.avatar = imgDataUrl;
      console.log("-------- crop success --------", imgDataUrl, field);
    },
    //上传成功回调
    cropUploadSuccess(jsonData, field) {
      console.log("-------- upload success --------");
      this.imgDataUrl = jsonData.files.Avatar1;
      console.log(jsonData);
      console.log("field: " + field);
    },
    //上传失败回调
    cropUploadFail(status, field) {
      console.log("-------- upload fail --------");
      console.log("上传失败状态" + status);
      console.log("field: " + field);
    },
    getUserInfo() {
      this.$axios.get("/users/userInfo").then((res) => {
        this.userInfo = res.data;
        console.log(res, this.userInfo);
      });
    },
    modify() {
      this.dialogFormVisible = true;
    },
    resetForm(userForm) {
      this.$refs[userForm].resetFields();
    },
    confirmAddUser(form) {
      this.$refs.userForm.validate((valid) => {
        if (valid) {
          //表单验证通过
          console.log(form); //form就是form表单对象
          this.loading = true;
          this.$axios.post("/users/information", this.userForm).then((res) => {
            if (res.data.state === 2000) {
              this.loading = false;
              this.dialogFormVisible = false;
              this.getUserInfo(); //重新调用渲染列表的方法
              this.$message({ message: "添加成功", type: "success" });
            } else {
              Element.Message.error("出现了一些意料之外的错误,请稍后再试");
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
/* .el-form {
  width: 420px;
  margin: 50px auto;
} */
.left-card {
  height: 590px;
}
.Center {
  width: 100%;
  height: 100%;
}
.el-icon-s-order {
  font-size: 30px;
  color: #409eff;
}
.icon-word {
  font-weight: bold;
  color: #409eff;
  font-size: 30px;
}
.content {
  width: 160px;
  height: 160px;
  border-radius: 5px;
  box-shadow: #409eff 0 2px 5px 0px;
}
</style>