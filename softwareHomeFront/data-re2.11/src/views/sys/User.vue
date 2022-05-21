<template>
  <el-row class="Center" :gutter="10">
    <el-col :span="12" style="margin-top: 0px; margin-left: 25%">
      <el-card shadow="hover" class="left-card">
        <div style="text-align: center">
          <div class="el-upload">
            <h2>修改密码</h2>
          </div>
          <el-form
            :model="passForm"
            status-icon
            :rules="rules"
            ref="passForm"
            label-width="100px"
          >
            <el-form-item label="旧密码" prop="currentPass">
              <el-input
                type="password"
                v-model.trim="passForm.currentPass"
                autocomplete="off"
              ></el-input>
            </el-form-item>
            <el-form-item label="新密码" prop="password">
              <el-input
                type="password"
                v-model.trim="passForm.password"
                autocomplete="off"
              ></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input
                type="password"
                v-model.trim="passForm.checkPass"
                autocomplete="off"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('passForm')"
                >提交</el-button
              >
              <el-button @click="resetForm('passForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<script>
import Element, { Message } from "element-ui";
export default {
  name: "Login",
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.passForm.password) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    var validatePass1 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入新密码"));
      } else if (value === this.passForm.currentPass) {
        callback(new Error("请勿与原密码一致!"));
      } else {
        callback();
      }
    };
    return {
      // userInfo: {},
      passForm: {
        password: "",
        checkPass: "",
        currentPass: "",
      },
      rules: {
        password: [
          { required: true, validator: validatePass1, trigger: "blur" },
          {
            min: 6,
            max: 12,
            message: "长度在 6 到 12 个字符",
            trigger: "blur",
          },
        ],
        checkPass: [
          { required: true, validator: validatePass, trigger: "blur" },
        ],
        currentPass: [
          { required: true, message: "请输入当前密码", trigger: "blur" },
        ],
      },
    };
  },
  // created() {
  //   this.getUserInfo();
  // },
  methods: {
    // getUserInfo() {
    //   this.$axios.get("/sys/userInfo").then((res) => {
    //     this.userInfo = res.data.data;
    //   });
    // },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const _this = this;
          //提交表单
          this.$axios({
            url: "/users/password/change",
            method: "post",
            params: {
              oldPassword: this.passForm.currentPass,
              newPassword: this.passForm.password,
            },
          }).then((res) => {
            // _this.$alert(res.data.msg, "提示", {
            //   confirmButtonText: "确定",
            //   callback: (action) => {
            //     this.$refs[formName].resetFields();
            //   },
            // });
            if (res.data.state === 2000) {
              localStorage.clear();
              sessionStorage.clear();
              this.$store.commit("resetState");
              this.$router.push("/login");
            } else if (res.data.state === 7000) {
              Element.Message.error("数据更新错误,请稍后重试");
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
.el-form {
  width: 420px;
  margin: 50px auto;
}
.left-card {
  height: 590px;
}
.Center {
  width: 100%;
  height: 100%;
}
</style>