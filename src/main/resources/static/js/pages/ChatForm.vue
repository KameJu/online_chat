<template>
    <v-container>
        <v-row align="center mt-8">

            <ListItem item-name="Your sex:" id="yourSex" class="mb-auto p-2 bd-highlight"
                      :items="[ {text: 'male'},  {text: 'female'},  ]"></ListItem>

            <ListItem item-name="Opponent sex:" id="opponentSex" :items="sexes"></ListItem>

        </v-row>

        <v-row align="center mt-5">

            <list-item item-name="Your age:" id="yourAge" :items="ages"></list-item>

            <list-item item-name="Opponent age:" id="opponentAge" :items="ages"></list-item>

        </v-row>

        <v-row>
                <v-btn class="mt-8" dark="dark" @click="start">Start chat</v-btn>
        </v-row>
        <a href="/chat">websocket_chat</a>
    </v-container>
</template>

<script>
import ListItem from "../components/ListItem.vue";

export default {
    name: "ChatForm",
    components: {
        ListItem,
    },
    methods:{
        start(){

      }
    },
    data() {
        return {
            toggle_exclusive: 1,
            sexes: [
                {text: "Male"},
                {text: "Female"},
                {text: "Somebody"},
            ],
            ages:[
                {text: "Under 17"},
                {text: "From 18 to 21"},
                {text: "From 22 to 25"},
                {text: "From 26 to 35"},
                {text: "Older then 36"},
            ]

        }
    },
}
</script>

<style scoped>

.v-btn {
    margin: 0px auto;
    width: 50%;
    background-color: transparent !important;
    border-radius: 0px;
    -webkit-text-fill-color: yellowgreen;
    border: 2px solid yellowgreen;
}

.v-btn:before{
    background-color: #151414;
}

.theme--dark.v-btn {
     color: yellowgreen;
}
</style>
