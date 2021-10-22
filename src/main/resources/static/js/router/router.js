import Vue from "vue"
import VueRouter from "vue-router"
import ChatForm from "pages/ChatForm.vue";
import ChatRoom from "pages/ChatRoom.vue";

Vue.use(VueRouter)

const routes= [
    { path: '/', component: ChatRoom },
    { path: '/chat', component: ChatForm},

]

export default new VueRouter({
    mode: "history",
    routes
})