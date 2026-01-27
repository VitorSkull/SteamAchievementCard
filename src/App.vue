<script setup>
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <div class="Menu">
    <img src="../img/Steam_icon_logo.svg.png" class="SteamLogo">
    <h1 class="Title">Completed Steam games card creator</h1>
    <p class="subTitle">Custom made cards for your completed games!</p>
  </div>
  <div>
    <input type="Title" class="Search" placeholder="Enter your Steam profile URL or custom ID">
  </div>
  <button>Check your cards</button>
  <p>TESTE</p>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Assistant:wght@200..800&family=Chau+Philomene+One:ital@0;1&display=swap');

.SteamLogo{
  height: 8%;
  width: 8%;
}
.Title{
  font-family: 'Assistant', sans-serif;
  width: 40%;
  line-height: 1;
  /* background-color: blue; */
}
.subTitle{
  font-family: 'Assistant', sans-serif;
  margin-top: 0;
  width: 35%;
  font-size: large;
  /* background-color: blue; */
}
.Menu{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.Search{
  border-radius: 8px;
  background-color: white;
  font-size: large;
  width: 35%;
  color: black;

}
.Search::placeholder{
  color: grey;
  font-size: medium;
}
.teste{
  background-color: red;
}
.SearchButtom{
  
}
</style>
