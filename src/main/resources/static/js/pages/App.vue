<template>
    <v-app class="app-main">
        <v-app-bar app>
            <v-toolbar-title class="mr-1">Online Chat</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn icon href="/logout">
                <v-icon>exit_to_app</v-icon>
            </v-btn>
        </v-app-bar>
        <v-main>
            <router-view></router-view>
        </v-main>
    </v-app>
</template>

<script>

</script>

<style>

</style>