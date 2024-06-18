<script>
export default {
  name: "Main"
}
</script>

<template>
  <el-main>
    <transition name="fade-transform" mode="out-in">
      <keep-alive>
        <router-view/>
      </keep-alive>
    </transition>
  </el-main>
</template>

<style scoped>

</style>