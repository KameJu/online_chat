<template>
<v-container>
<v-btn @click="send" dark="dark">Send Message</v-btn><br><br>
    <div id="chat">ChatMessages: </div>
</v-container>
</template>

<script>
import {connect, sendMessage} from "../util/ws";

connect()

export default {
    name: "ChatRoom",
    methods: {
        send() {
            sendMessage()
        }
    }
}
</script>

<style scoped>

</style>