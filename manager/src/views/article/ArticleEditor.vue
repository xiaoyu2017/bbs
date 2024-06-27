<template>
  <el-row class="box">
    <el-col class="header-box">
      <el-input style="float: left;" size="small" type="text" placeholder="请输入文章标题">
        <el-button slot="append" >提交</el-button>
      </el-input>
    </el-col>
    <el-col class="editor-box">
      <div id="editor" ref="editor"></div>
    </el-col>
  </el-row>

</template>

<script>
import '@toast-ui/editor/dist/toastui-editor.css';
// 工具栏显示中文
// import '@toast-ui/editor/dist/i18n/zh-cn.js';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';
// Toast UI Editor 配置文件
import codeSyntaxHighlight from '@toast-ui/editor-plugin-code-syntax-highlight';
import Editor from '@toast-ui/editor';

export default {
  name: 'markingRecord',
  data() {
    return {
      editor: null,
      markdown: `# Hello, World! :icon: ### 被告人谭某某，女，1974
          ##### 指定辩护人胡建和，广东瑞霆律师事务所律师。
        `,
    };
  },
  mounted() {
    this.initEditor();
    // 必须放mounted里面，放created里面会导致初始化没成功，编辑器不能正常使用
  },
  methods: {
    initEditor() {
      this.editor = new Editor({
        el: document.querySelector('#editor'),
        // 绑定到id为editor的节点
        previewStyle: 'vertical',
        // 编辑器的预览样式
        initialValue: this.markdown,
        // 编辑器的初始内容
        initialEditType: 'markdown',
        // 编辑器的模式，（编辑模式markdown/所见即所得模式wysiwyg）
        hideModeSwitch: true,
        // 是否隐藏上面的编辑器模式选项卡
        useCommandShortcut: true,
        // 是否使用键盘快捷键执行命令（默认是true）
        height: '100%',
        // 编辑器高度
        previewHighlight: false,
        // 是否高亮预览区域 (默认false)
        language: 'zh-CN',
        plugins: [codeSyntaxHighlight]

      });
      this.editor.on('change', () => {
        //这里是editor内容发生改变执行的方法
        //如果要监听内容变化并依据条件执行可以在这里写入触发方法
      });
      this.editor.on('load', () => {
        //设置editor的文本内容靠左（我用的时候是默认居中的，但我需要内容默认靠左所以需要加上这个）
        this.editor.exec('textAlign', 'left');
      });
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