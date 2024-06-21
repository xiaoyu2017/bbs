<script>
import AppAsideItem from "@/layout/components/AppAside/AppAsideItem.vue";
import {routes} from '@/router'

export default {
  name: "Aside",
  components: {AppAsideItem},
  data() {
    return {
      menus: routes
    }
  },
  mounted() {
  }
}
</script>

<template>
  <el-menu
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
    <app-aside-item v-for="menu in menus" :key="menu.path" :menu="menu" :base-path="menu.path"/>
  </el-menu>
</template>

<style scoped>

</style>