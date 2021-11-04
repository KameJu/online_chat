<template>
    <v-container>
        <v-row class="mt-8">

          <list-item ref="mySex" item-name="Your sex:" class="mb-auto p-2 bd-highlight"
                     :items="[ {text: 'male'},  {text: 'female'},  ]"></list-item>

          <list-item ref="opSex" item-name="Opponent sex:"  :items="sexes"></list-item>

        </v-row>

        <v-row class="mt-5">

            <list-item ref="myAge" item-name="Your age:" :items="ages"></list-item>

            <list-item ref="opAge" item-name="Opponent age:" id="opponentAge" :items="ages"></list-item>

        </v-row>

        <v-row>
                <v-btn class="mt-8" dark="dark" @click="start">Start chat</v-btn>
        </v-row>
        <a href="/chat">websocket_chat</a>
      <div>
      </div>
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


          // const requestOptions = {
          //   method: "POST",
          //   headers: { "Content-Type": "application/json" },
          //   body: JSON.stringify({
          //     mySex: this.$refs.mySex.$data.text,
          //     opSex: this.$refs.opSex.$data.text,
          //     myAge: this.$refs.myAge.$data.text,
          //     opAge: this.$refs.opAge.$data.text,
          //   })
          // }

          const joinRequest = {
            method: "GET",
            headers: {
              "Content-Type": "application/json",
              "User-Data": JSON.stringify({
                mySex: this.$refs.mySex.$data.text,
                opSex: this.$refs.opSex.$data.text,
                myAge: this.$refs.myAge.$data.text,
                opAge: this.$refs.opAge.$data.text,
              })
            }
          }

        // fetch("/join.data", requestOptions)
        fetch("/join", joinRequest)

            // .then(response => response.json())
            // .then(data => ({text: "some text"}));

      },
    },
    data() {
      return {
        sex: "",
        toggle_exclusive: 1,
        sexes: [
          {text: "Male"},
          {text: "Female"},
          {text: "Somebody"},
        ],
        ages: [
          {text: "Under 17"},
          {text: "From 18 to 21"},
          {text: "From 22 to 25"},
          {text: "From 26 to 35"},
          {text: "Older then 36"},
        ],
        outputData: {},
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
