<template>
<v-container id="chat">
<v-btn @click="send" dark="dark">Send Message</v-btn>
</v-container>
</template>

<script>
import { connect } from "../util/ws";

export default {
    name: "ChatRoom",
    methods: {
        send() {
            connect()
        }
    }
}
</script>

<style scoped>

</style>