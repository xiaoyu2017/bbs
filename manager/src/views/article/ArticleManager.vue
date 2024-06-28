<script>
import {Message, MessageBox} from "element-ui"
import {deleteArticleByid, getArticlesByPage} from "@/api/article";

export default {
  name: "ArticleManager",
  data() {
    return {
      tableData: [],
      search: '',
      currentPage: 1,
      pageSize: 10,
      total: 0
    }
  },
  methods: {
    handleEdit(index, row) {
      this.$router.push({name: 'ArticleEditor', params: {article: row}})
    },
    handleDelete(index, row) {
      MessageBox.confirm('此操作将永久删除该文章, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteArticleByid(row.id).then(() => {
          Message({
            type: 'success',
            message: '删除成功!'
          });
          this.updateTableData(this.currentPage, this.pageSize)
        }).catch(() => {
          Message({
            type: 'error',
            message: '删除失败!'
          })
        })
      }).catch(() => {
        Message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    handleSizeChange(val) {
      this.pageSize = val
      this.updateTableData(this.currentPage, this.pageSize)
    },
    handleCurrentChange(val) {
      this.currentPage = val
      this.updateTableData(this.currentPage, this.pageSize)
    },
    addArticle() {
      this.$router.push('/article/ArticleEditor')
    },
    updateTableData(page, num) {
      // 获得用户信息
      getArticlesByPage(page, num).then(response => {
        this.tableData = response.data.data
        this.total = response.data.total
        this.currentPage = page
      })
    },
  },
  created() {
    this.updateTableData(1, 10)
  },

}
</script>

<template>
  <el-row class="box">
    <el-col class="table-box">
      <el-table
          :data="tableData"
          border
          stripe
          height="100%"
          max-height="100%">
        <el-table-column>
          <template slot="header" slot-scope="scope">
            <el-row>
              <el-col :span="2">
                <el-button style="float: left" type="primary" @click="addArticle">新增文章</el-button>
              </el-col>
              <el-col :span="16" style="padding: 0 10px">
                <el-alert
                    title="表格当前显示数据条件"
                    type="warning"
                    show-icon
                    :closable="false">
                </el-alert>
              </el-col>
              <el-col :span="6">
                <el-input style="float: right;height: 40px;" type="text" placeholder="输入关键字搜索" v-model="search">
                  <el-button slot="append" icon="el-icon-search"></el-button>
                </el-input>
              </el-col>
            </el-row>
          </template>

          <el-table-column prop="id" label="ID" width="150"></el-table-column>
          <el-table-column prop="title" label="标题" width="200" :show-overflow-tooltip="true"></el-table-column>
          <el-table-column prop="value" label="内容值" :show-overflow-tooltip="true"></el-table-column>
          <el-table-column prop="html" label="内容html" width="200" :show-overflow-tooltip="true"></el-table-column>

          <el-table-column label="操作" width="120">
            <template slot-scope="scope">
              <el-button type="primary"
                         icon="el-icon-edit"
                         @click="handleEdit(scope.$index, scope.row)"
                         circle>
              </el-button>
              <el-button
                  type="danger"
                  icon="el-icon-delete"
                  circle
                  @click="handleDelete(scope.$index, scope.row)">
              </el-button>
            </template>
          </el-table-column>
        </el-table-column>
      </el-table>
    </el-col>
    <el-col class="table-page-box">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[10, 15, 20, 30]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </el-col>
    <common-dialog/>
  </el-row>
</template>

<style scoped>
.box {
  height: 100%;
  position: relative;
}

.table-box {
  top: 0;
  bottom: 35px;
  position: absolute;
}

el-table {
  width: 100%;
}

.table-page-box {
  height: 35px;
  width: 100%;
  bottom: 0;
  position: absolute;
  border: 1px solid #EBEEF5;
  background-color: #FFF;
  text-align: center;
  line-height: 35px;
}
</style>