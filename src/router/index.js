import { createRouter, createWebHistory } from 'vue-router'
import Main from '../views/Main.vue'
import Games from '../views/Games.vue'

const routes = [
  { path: '/', component: Main },
  { path: '/Games', component: Games }
]

export default createRouter({
  history: createWebHistory(),
  routes
})
