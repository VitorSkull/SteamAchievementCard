<script setup>
import { onMounted } from 'vue';
import { useUserStore } from '../stores/userStore';
import axios from 'axios';

const user = useUserStore()
console.log(user.steamInput)
onMounted (async () => {
    const res = await axios.get('http://localhost:8080/Games', {
        params: {steamid: user.steamInput}
    })
    user.data = res.data
    console.log(user.data)
})
</script>

<template>
    <h1>teste</h1>
</template>

<style lang="scss">

</style>