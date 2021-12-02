<template>
  <div class="login" clearfix>
    <div class="login-wrap">
      <el-row type="flex" justify="center">
        <el-form ref="loginForm" :model="user" :rules="rules" status-icon label-width="80px">
          <h3>登录</h3>
          <hr>
          <el-form-item label="用户名">
            <el-input v-model="user.username" placeholder="请输入用户名" prefix-icon></el-input>
          </el-form-item>
          <el-form-item id="password" prop="password" label="密码">
            <el-input v-model="user.password" show-password placeholder="请输入密码"></el-input>
            </el-form-item>
            <router-link to="/">找回密码</router-link>
            <router-link to="/register">注册账号</router-link>
          <el-form-item>
            <el-button type="primary" icon="el-icon-upload" @click="doLogin()">登 录</el-button>
          </el-form-item>
          <hr>
        </el-form>
      </el-row>
    </div>
  </div>
</template>

<script>
import helloWorld from '@/components/helloWorld'

export default {
  name: 'login',
  data () {
    return {
      user: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    doLogin () {
      if (!this.user.username) {
        this.$message.error('请输入用户名 ')
      } else if (!this.user.password) {
        this.$message.error('请输入密码!')
      } else {
        // this.$router.push({ path: "/personal" });
        // this.$axios
        //   .post('/login/', {
        //     name: this.user.username,
        //     password: this.user.password
        //   })
        //   .then(res => {
        //     // console.log("输出response.data.status", res.data.status);
        //     if (res.data.status === 200) {
        //       this.$router.push({ path: '/personal' })
        //     } else {
        //       alert('您输入的用户名或密码错误！')
        //     }
        //   })
        if (this.user.username === 'root' && this.user.password === 'root') {
          this.$router.push({
            path: '/helloWorld',
            name: 'helloWorld',
            Comment: helloWorld
          })
        }
      }
    }
  }
}
</script>

<style scoped>
.login {
  width: 100%;
  height: 740px;
  background: url("../assets/images/1.png") no-repeat;
  background-size: cover;
  overflow: hidden;
}
.login-wrap {
  background: url("../assets/images/1.png") no-repeat;
  background-size: cover;
  width: 400px;
  height: 300px;
  margin: 215px auto;
  overflow: hidden;
  padding-top: 10px;
  line-height: 40px;
}
#password {
  margin-bottom: 5px;
}
h3 {
  color: #0babeab8;
  font-size: 24px;
}
hr {
  background-color: #444;
  margin: 20px auto;
}
a {
  text-decoration: none;
  color: #aaa;
  font-size: 15px;
}
a:hover {
  color: coral;
}
.el-button {
  width: 80%;
  margin-left: -50px;
}
</style>
