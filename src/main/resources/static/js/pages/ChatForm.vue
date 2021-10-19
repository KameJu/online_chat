<template>
    <v-container class="mt-12">
        <v-row align="center mt-5">

            <ListItem class="mb-auto p-2 bd-highlight" item-name="Your sex:" :items="[ {text: 'male'},  {text: 'female'},  ]"></ListItem>

            <ListItem item-name="Opponent sex:" :items="sexes"></ListItem>

        </v-row>

        <v-row align="center mt-5">

            <list-item item-name="Your age:" :items="ages"></list-item>

            <list-item item-name="opponent age:" :items="ages"></list-item>

        </v-row>
    </v-container>
</template>

<script>
import ListItem from "../components/ListItem.vue";

export default {
    name: "ChatForm",
    components: {
        ListItem,
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

</style>
