import { createRouter, createWebHistory } from 'vue-router'
import Main from '../components/Main.vue'
import Games from '../components/Games.vue'

const routes = [
  { path: '/', component: Main },
  { path: '/Games', component: Games }
]

export default createRouter({
  history: createWebHistory(),
  routes
})
