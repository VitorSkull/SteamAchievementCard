<script setup>
import { onMounted, reactive } from 'vue';
import { useUserStore } from '../stores/userStore';
import axios from 'axios';

const user = useUserStore()
const userData = reactive({
    steamid: '',
    personaname: '',
    profileurl: '',
    avatar: '',
})
const fetchUser = async () => {
    const res = await axios.get('http://localhost:8080/Games', {
        params: {steamid: user.steamInput}
    })
    const data = res.data
    Object.assign(userData, res.data)
    console.log(userData)
}
console.log(user.steamInput)
onMounted(fetchUser)
</script>

<template>
    <h1>teste</h1>
</template>

<style lang="scss">

</style>