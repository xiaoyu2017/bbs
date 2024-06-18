<script>
export default {
  name: "Header",
  data() {
    return {
      tags: [
        {name: '标签一', type: ''},
        {name: '标签二', type: 'success'},
        {name: '标签三', type: 'info'},
        {name: '标签四', type: 'warning'},
        {name: '标签五', type: 'danger'}
      ]
    };
  }
}
</script>

<template>
  <el-row style="text-align: right;">
    <el-dropdown>
      <div style="line-height: 60px;">
        <img style="float:left;margin-right:5px;margin-top: 10px;border-radius: 4px;" width="40" height="40"
             src="https://img1.baidu.com/it/u=3705960668,3190998153&fm=253&fmt=auto&app=138&f=JPEG?w=760&h=304" alt="">
        <i class="el-icon-caret-bottom">
          <el-badge is-dot class="item"></el-badge>
        </i>
      </div>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item disabled>蚵仔煎</el-dropdown-item>
        <el-dropdown-item divided>
          消息
          <el-badge :value="12" class="item"/>
        </el-dropdown-item>
        <el-dropdown-item>信息</el-dropdown-item>
        <el-dropdown-item>帮助</el-dropdown-item>
        <el-dropdown-item>退出</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </el-row>
</template>

<style scoped>
</style>