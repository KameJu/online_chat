import SockJS from 'sockjs-client'
import {Stomp} from '@stomp/stompjs'

let stompClient= null
const handlers = []

export function connect() {
    const socket = new SockJS('http://localhost:8081/socket')
    stompClient = Stomp.over(socket)
    stompClient.debug = () => {}
    stompClient.connect({}, frame => {
        // console.log('Connected: ' + frame)
        stompClient.subscribe('/chat', message => {
            console.log("subscribe")
            if (message.body) {
                console.log("messaged")
                document.getElementById('chat').append("test message")
            }
        })
    })
}

export function addHandler(handler) {
    handlers.push(handler)
}

export function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect()
    }
    console.log("Disconnected")
}

export function sendMessage(message) {
    stompClient.send("/app/send/message", {}, message)
}