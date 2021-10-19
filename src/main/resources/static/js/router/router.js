import Vue from "vue"
import VueRouter from "vue-router"
import ChatForm from "pages/ChatForm.vue";

Vue.use(VueRouter)

const routes= [
    { path: '/', component: ChatForm },

]

export default new VueRouter({
    mode: "history",
    routes
})