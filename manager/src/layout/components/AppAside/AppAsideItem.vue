<script>

export default {
  name: "AppAsideItem",
  props: {
    menu: {
      type: Object,
      required: true
    },
    basePath: {
      type: String,
      default: ''
    },
    isNest: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    addPath(routePath) {
      if (this.isNest) {
        return this.basePath + '/' + routePath;
      } else {
        return routePath;
      }
    },
  },
  mounted() {
  }
}
</script>

<template>
  <div v-if="!menu.hidden">
    <template v-if="!menu.hasChildren">
      <router-link :to="addPath(menu.path)">
        <el-menu-item :index="menu.path">
          <i :class="menu.meta.icon"></i>
          <span slot="title" v-text="menu.meta.title"></span>
        </el-menu-item>
      </router-link>
    </template>
    <el-submenu v-else :index="menu.path">
      <template slot="title">
        <i :class="menu.meta.icon"></i>
        <span slot="title" v-text="menu.meta.title"></span>
      </template>
      <app-aside-item
          v-for="child in menu.children"
          :key="child.path"
          :is-nest="true"
          :menu="child"
          :base-path="menu.path"/>
    </el-submenu>
  </div>
</template>

<style scoped>

</style>