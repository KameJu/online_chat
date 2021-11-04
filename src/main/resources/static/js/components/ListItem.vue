<template>
    <v-col
        cols="6"
        class="py-2"
        align="center"
    >
        <strong class="d-flex flex-start">{{itemName}}</strong>

        <v-btn-toggle
            v-model.lazy="text"
            tile
            group
            v-for="(item, i) in items"
            :key="i"
            class="d-flex flex-column"
        >
            <v-btn
                dark="dark"
                elevation="3"
                :value="item.text">
                {{item.text}}
            </v-btn>
        </v-btn-toggle>
    </v-col>
</template>

<script>
export default {
    name: "ListItem",
    props: ['itemName' , 'items'],
    data(){
        return{
            text: {}
        }
    },

}
</script>

<style scoped>

.v-btn-toggle--group>.v-btn.v-btn {
    background-color: transparent !important;
    margin: 4px;
    min-width: auto;
}

.v-btn:before{
    background-color: #651FFF;
}

.theme--dark.v-btn--active:before, .theme--dark.v-btn--active:hover:before {
    opacity: 0.8;
}
</style>