import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'
import helloWorld from '@/components/helloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/helloWorld',
      name: 'helloWorld',
      component: helloWorld
    }
  ]
})
