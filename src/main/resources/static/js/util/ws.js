import SockJS from 'sockjs-client'
import {Stomp} from '@stomp/stompjs'

let stompClient= null
const handlers = []

let counter = 0;

export function connect() {
    const socket = new SockJS('/chat')

    stompClient = Stomp.over(socket)
    // stompClient.debug = () => {}

    stompClient.connect({}, frame => {

        stompClient.subscribe('/topic/chat', (message) => {
            // handlers.forEach(handler => handler(JSON.parse("test message")))
            //     console.log("messaged")
            document.getElementById('chat').append(JSON.parse(message.body))

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

export function sendMessage() {
    stompClient.send("/app/chat", {}, counter++)
}

