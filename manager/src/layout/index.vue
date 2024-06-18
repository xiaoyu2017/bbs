<script>
import {AppAside, AppHeader, AppMain} from "./components";

export default {
  components: {AppAside, AppHeader, AppMain}
}
</script>

<template>
  <el-container style="height: 100%;">
    <el-aside width="250px">
      <AppAside/>
    </el-aside>
    <el-container>
      <el-header>
        <AppHeader/>
      </el-header>
      <el-main>
        <AppMain/>
      </el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </el-container>
</template>

<style scoped>
.el-aside {
  background-color: #545c64;
  height: 100%;
}

.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-footer {
  background-color: #B3C0D1;
  color: #333;
}

.el-main {
  color: #333;
  height: 100%;
  padding: 5px;
}
</style>