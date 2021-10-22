<template>
    <v-app class="app-main">
        <v-app-bar class="header" app>
            <v-toolbar-title class="mr-1">Online Chat</v-toolbar-title>
<!--            <v-spacer></v-spacer>-->
<!--            <v-btn icon href="/logout">-->
<!--                <v-icon>exit_to_app</v-icon>-->
<!--            </v-btn>-->
        </v-app-bar>
        <v-main class="body">
            <router-view></router-view>
        </v-main>
    </v-app>
</template>

<script>

</script>

<style>
.header{
    background-color: #171717 !important;
    -webkit-text-fill-color: #d7d7d7;
}

.body{
    background-color: #151414;
    -webkit-text-fill-color: #d7d7d7;
}
.app-main{
    overflow: scroll;
    overflow-x: hidden; /* Hide vertical scrollbar */
    overflow-y: hidden;
}
</style>