import Vue from 'vue'
import App from './App.vue'
import router from './router'

import vuetify from './plugins/vuetify'
import 'vuetify/dist/vuetify.min.css'


import 'highlight.js/styles/atom-one-dark.css'
import highlightJS from 'highlight.js'

Vue.use(highlightJS)

Vue.config.productionTip = false

new Vue({
    router,
    vuetify,
    render: h => h(App)
}).$mount('#app')