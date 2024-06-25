<script>
/**
 * 通用Dialog
 *
 * formMetaData-Meta
 *    name:字段名
 *    label:标签名
 *    category:输入框类型(以element-ui输入框类型为准)
 *    type:原生input type
 *    placeholder:提示文本
 *    activeText:switch的选择显示文本
 *    inactiveText:switch的未选择显示文本
 *    hidden:是否显示，不显示使用原始input隐藏
 *
 * @author xiaoyu
 */
import bus from '@/utils/EventBus'
import {Message} from 'element-ui'
import request from "@/utils/request";
import {openDialog} from "@/components/CommonDialog/modules/CommonDialogData";

export default {
  created() {
    bus.$on('openCommonDialog', (key, oldData) => {
      let meta = openDialog(key)
      this.dialogTitle = meta.dialogTitle
      this.dialogVisible = meta.dialogVisible
      this.formMetaData = meta.formMetaData
      this.requestUrl = meta.requestUrl
      this.requestMethod = meta.requestMethod
      if (oldData !== null && oldData !== undefined) {
        this.formData = oldData
      }
    })
  },
  data() {
    return {
      // dialog标题
      dialogTitle: '',
      // 是否可见
      dialogVisible: false,
      // 表单原数据
      formMetaData: [],
      // 表单数据
      formData: {},
      // 请求Url
      requestUrl: '',
      // 请求Method
      requestMethod: '',
    }
  },
  methods: {
    submitData() {
      const result = request({
        url: this.requestUrl,
        method: this.requestMethod,
        data: this.formData
      })
      result.then(response => {
        const {data} = response
        if (data.error === 0) {
          Message.info(data.message)
          this.dialogVisible = false
        } else {
          Message.error(data.message);
        }
      })
    },
  }
}
</script>

<template>
  <el-dialog :visible.sync="dialogVisible" :title="dialogTitle">
    <el-form :model="formData" label-width="80px" label-position="left">
      <div v-for="meta in formMetaData">
        <input v-if="meta.hidden" v-model="formData[meta.name]" :name="meta.name" type="hidden"/>
        <el-form-item v-else :label="meta.label">
          <el-input v-if="meta.category==='input'" :type="meta.type" v-model="formData[meta.name]"
                    :placeholder="meta.placeholder"/>
          <el-switch v-else-if="meta.category==='switch'" active-color="#13ce66" inactive-color="#ff4949"
                     :active-text="meta.activeText" :inactive-text="meta.inactiveText"
                     v-model="formData[meta.name]">
          </el-switch>
        </el-form-item>
      </div>
    </el-form>

    <div style="text-align:right;">
      <el-button type="danger" @click="dialogVisible=false">关闭</el-button>
      <el-button type="primary" @click="submitData">提交</el-button>
    </div>
  </el-dialog>
</template>
