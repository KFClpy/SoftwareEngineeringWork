<template>
  <el-row type="flex" class="row-bg" justify="center">
    <el-col :xl="6" :lg="7">
      <h2>欢迎来到数据修复系统</h2>
      <el-image
        :src="require('@/assets/logo.png')"
        style="height: 200px; width: 200px"
      ></el-image>
      <p>我们的不懈努力</p>
      <p>致力于保证您的数据质量</p>
    </el-col>
    <el-col :span="1">
      <el-divider direction="vertical"></el-divider>
    </el-col>
    <el-col :xl="6" :lg="7">
      <el-form
        :model="loginForm"
        :rules="rules"
        ref="loginForm"
        label-width="80px"
        class="demo-loginForm"
      >
        <el-form-item label="用户名" prop="username" style="width: 380px">
          <el-input v-model.trim="loginForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" style="width: 380px">
          <el-input
            type="password"
            v-model.trim="loginForm.password"
            show-password
          ></el-input>
        </el-form-item>
        <!-- <el-form-item label="验证码" prop="code" style="width: 380px">
          <el-input
            v-model="loginForm.code"
            style="width: 172px; float: left"
          ></el-input>
          <el-image :src="captchaImg" class="captchaImg"></el-image>
        </el-form-item> -->
        <el-form-item>
          <div class="button">
            <el-button type="primary" @click="submitForm('loginForm')"
              >登录</el-button
            >

            <router-link to="/register">
              <el-button type="success">注册</el-button></router-link
            >
            <el-button @click="resetForm('loginForm')">重置</el-button>
          </div>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>
<script>
import Element, { Message } from 'element-ui'
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
        // code: "",
        // token: "",
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { validator: this.checkData, trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { validator: this.checkData2, trigger: 'blur' }
        ]
        // code: [
        //   { required: true, message: "请输入验证码", trigger: "blur" },
        //   { min: 5, max: 5, message: "长度为5个字符", trigger: "blur" },
        // ],
      },
      captchaImg: null
    }
  },
  methods: {
    checkData (rule, value, callback) {
      if (value) {
        if (/[\u4E00-\u9FA5]/g.test(value)) {
          callback(new Error('用户名请不要含有中文!'))
        } else {
          callback()
        }
      }
      callback()
    },
    checkData2 (rule, value, callback) {
      if (value) {
        if (/[\u4E00-\u9FA5]/g.test(value)) {
          callback(new Error('密码请不要含有中文!'))
        } else {
          callback()
        }
      }
      callback()
    },
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios({
            url: '/users/login',
            method: 'post',
            params: {
              username: this.loginForm.username,
              password: this.loginForm.password
            }
          }).then((res) => {
            // const jwt = res.headers["authorization"];
            // this.$store.commit("SET_TOKEN,jwt");
            // window.localStorage["token"] = JSON.stringify(res.data.data.token);
            console.log(res.data.token)
            if (res.data.state === 2000) {
              if (typeof res.data.token !== 'undefined') {
                window.localStorage.setItem('token', res.data.token)
              }
              this.$router.push('/index')
            } else if (res.data.state === 6000) {
              Element.Message.error('登陆失败,用户名或密码错误')
            } else if (res.data.state === 8000) {
              Element.Message.error('登陆失败,用户名或密码错误')
            } else {
              Element.Message.error('出现了一些意料之外的错误,请稍后再试')
            }
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
    // getCaptcha() {
    //   this.$axios.get("/captcha").then((res) => {
    //     console.log("/captcha");
    //     console.log(res);

    //     this.loginForm.token = res.data.data.token;
    //     this.captchaImg = res.data.data.captchaImg;
    //   });
    // },
  }
  // created() {
  //   this.getCaptcha();
  // },
}
</script>

<style scoped>
.el-row {
  background-color: #fafafa;
  height: 100vh;
  display: flex;
  align-items: center;
  text-align: center;
}

.el-divider {
  height: 200px;
}

.captchaImg {
  float: left;
  margin-left: 8px;
  border-radius: 4px;
}
.button {
  display: flex;
  justify-content: space-evenly;
  margin-right: 70px;
}
</style>
