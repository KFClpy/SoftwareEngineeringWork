<template>
<el-row class="Center" :gutter="10">
    <el-col :span="12" style="margin-top: 0px; margin-left: 25%">
  <el-card shadow="hover" class="left-card">
    <div style="text-align: center">
      <h3>注册账号</h3>
      <el-form
        :model="registerData"
        :rules="rules"
        ref="registerForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="账号" prop="username">
          <el-input v-model.trim="registerData.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model.trim="registerData.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="password2">
          <el-input
            type="password"
            v-model.trim="registerData.password2"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <div class="item-button">
          <el-button type="primary" @click="submitForm('registerForm')"
            >注册</el-button
          >
        </div>
      </el-form>
    </div>
  </el-card>
   </el-col>
  </el-row>
</template>

<script>
import Element, { Message } from 'element-ui'
export default {
  data () {
    var validatePass = (rule, value, callback) => {
      if (value !== this.registerData.password) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      registerData: {
        username: '',
        password: '',
        password2: ''
      },
      rules: {
        username: [
          {
            required: true,
            message: '用户名不能为空！',
            trigger: 'blur'
          },
          {
            min: 3,
            max: 12,
            message: '长度应在3~12之间',
            trigger: 'blur'
          },
          { validator: this.checkData, trigger: 'blur' }
        ],
        password: [
          {
            required: true,
            message: '密码不能为空！',
            trigger: 'blur'
          },
          {
            min: 6,
            max: 18,
            message: '长度应在6~18之间',
            trigger: 'blur'
          },
          { validator: this.checkData2, trigger: 'blur' }
        ],
        password2: [
          {
            required: true,
            message: '确认密码不能为空！',
            trigger: 'blur'
          },
          {
            min: 6,
            max: 18,
            message: '长度应在6~18之间',
            trigger: 'blur'
          },
          { validator: validatePass, trigger: 'blur' },
          { validator: this.checkData2, trigger: 'blur' }
        ]
      }
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
            url: '/users/reg',
            method: 'post',
            data: {
              username: this.registerData.username,
              password: this.registerData.password
            }
          }).then((res) => {
            if (res.data.state === 2000) {
              this.$message({
                type: 'success',
                message: '用户注册成功'
              })
              this.$router.push('/login')
            } else if (res.data.state === 4000) {
              Element.Message.error('注册失败,用户名已存在')
            } else if (res.data.state === 5000) {
              Element.Message.error('注册失败,数据插入错误')
            } else {
              Element.Message.error('出现了一些意料之外的错误,请稍后再试')
            }
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    }
  }
}
</script>

<style  scoped>
/* .box {
  width: 500px;
  height: 400px;
  margin: 100px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  box-shadow: 0 0 5px #eee;
} */
.Center {
  width: 100%;
  height: 100%;
}
.el-form {
  width: 420px;
  margin: 50px auto;
}
.left-card {
  width: 650px;
  height: 450px;
  margin-top: 80px;
  margin-left: auto;
  margin-right: auto;
}
h3 {
  text-align: center;
}
.el-input {
  width: 90%;
}
.item-button {
  display: flex;
  margin-top: 80px;
}
.item-button button {
  width: 120px;
  margin: 0 auto;
}
</style>
