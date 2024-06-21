import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import '@/style/index.css'

import './RouterInterceptor'
import CommonDialog from "@/components/CommonDialog/index.vue";

Vue.use(ElementUI)
Vue.component('CommonDialog', CommonDialog)

Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
