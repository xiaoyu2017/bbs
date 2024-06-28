<template>
  <el-row class="box">
    <el-col class="header-box">
      <el-input style="float: left;" size="small" type="text" placeholder="请输入文章标题" v-model="title">
        <el-button slot="append" @click="submitArticle">提交</el-button>
      </el-input>
    </el-col>
    <el-col class="editor-box">
      <markdown-editor ref="editor"/>
    </el-col>
  </el-row>
</template>

<script>
import markdownEditor from "@/components/MarkdownEditor/index.vue";
import request from "@/utils/request";

export default {
  name: 'ArticleEditor',
  components: {markdownEditor},
  data() {
    return {
      title: '',
      id: ''
    }
  },
  mounted() {
    const article = this.$route.params.article
    if (article.id) {
      this.id = article.id
    }
    if (article.title) {
      this.title = article.title
    }
    if (article.html) {
      this.$refs.editor.setHtmlData(article.html)
    }
    if (article.value) {
      this.$refs.editor.setValue(article.value)
    }
  },
  methods: {
    submitArticle() {
      let articleData = {}
      articleData.html = this.$refs.editor.getHtml()
      articleData.value = this.$refs.editor.getValue()
      articleData.title = this.title
      request({
        url: '/v1/api/article',
        method: 'post',
        data: articleData
      }).then(response => {
        console.log(JSON.stringify(response))
      })
    },
  },
};
</script>
<style scoped>
.box {
  height: 100%;
  position: relative;
}

.header-box {
  top: 0;
  height: 35px;
  line-height: 35px;
  position: absolute;
}

.editor-box {
  top: 35px;
  width: 100%;
  bottom: 0;
  position: absolute;
}
</style>