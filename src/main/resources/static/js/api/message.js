import Vue from "vue"

const message = Vue.resource('/')

export default {
    message: message => Vue.http.get('/', {params: message})
}