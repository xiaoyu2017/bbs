<script>
export default {
  name: "Main",
  computed: {
    key() {
      return this.$route.path
    }
  }
}
</script>

<template>
  <el-main>
    <transition name="fade-transform" mode="out-in">
<!--      <keep-alive>-->
        <router-view :key="key"/>
<!--      </keep-alive>-->
    </transition>
  </el-main>
</template>

<style scoped>

</style>