import Vue from "vue"
import Vuetify from "vuetify";

import App from "pages/App.vue"

import "@babel/polyfill"
import 'vuetify/dist/vuetify.min.css'
import router from "router/router"

const vuetifyOptions = { }


Vue.use(Vuetify)

new Vue({
    el: '#app',
    vuetify: new Vuetify(vuetifyOptions),
    router,
    render: a => a(App)
})