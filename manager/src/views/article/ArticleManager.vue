<template>
  <div>
    <MarkdownEditor ref="markdownEditor" v-model="content1" height="500px" />
  </div>
</template>

<script>
import MarkdownEditor from '@/components/MarkdownEditor';

const content = `
**This is test**

* vue
* element
* webpack
`
export default {
  name: "ArticleManager",
  components: {
    MarkdownEditor,
  },
  data() {
    return {
      html: '',
      value: '',
      content1: content,
    }
  },
  methods: {
    getHtml() {
      this.html = this.$refs.markdownEditor.getHtml();
      console.log(this.html);
    },
    getValue() {
      this.value = this.$refs.markdownEditor.getValue();
      console.log(this.value);
    },
  }
}
</script>

<style lang="scss" scoped>

</style>
