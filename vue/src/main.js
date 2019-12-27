import Vue from 'vue'
import App from './components/Home.vue'
import router from './router'
import vueRouter from 'vue-router'
import axios from 'axios'
import vuex from 'vuex'
import 'es6-promise/auto'
// import VueElementLoading from 'vue-element-loading'
import {store} from './store'
Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
  render: h => h(App),
  router,
  vueRouter,
  axios,
  vuex,
  store
  // VueElementLoading
}).$mount('#app')