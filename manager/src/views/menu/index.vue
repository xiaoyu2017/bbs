<script>
import bus from '@/utils/EventBus'
import {Message, MessageBox} from 'element-ui'
import {deleteMenuByUid, getMenu, getMenuChildren} from '@/api/menu'

export default {
  name: "index",
  data() {
    return {
      tableData: [],
      search: '',
    }
  },
  methods: {
    load(tree, treeNode, resolve) {
      getMenuChildren(tree.id).then(response => {
        resolve(response.data.data)
      })
    },
    handleEdit(index, row) {
      bus.$emit('openCommonDialog', 'menuEdit', row)
    },
    handleDelete(index, row) {
      MessageBox.confirm('此操作将永久删除该菜单, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteMenuByUid(row.id).then(() => {
          Message({
            type: 'success',
            message: '删除成功!'
          })
          this.updateMenuTableData()
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
        })
      })
    },
    addMenu() {
      bus.$emit('openCommonDialog', 'menuAdd')
    },
    updateMenuTableData() {
      getMenu().then((response) => {
        this.tableData = response.data.data
      });
    }
  },
  created() {
    this.updateMenuTableData()

  }
}
</script>

<template>
  <el-row class="box">
    <el-col class="table-box">
      <el-table height="100%" max-height="100%" border lazy
                :data="tableData" row-key="id" :tree-props="{children: 'children', hasChildren: 'isTree'}"
                :load="load">
        <el-table-column>
          <template slot="header">
            <el-row>
              <el-col :span="2">
                <el-button style="float: left" type="primary" @click="addMenu">新增菜单</el-button>
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

          <el-table-column prop="id" label="ID" width="100"></el-table-column>
          <el-table-column prop="path" label="路径" width="180"></el-table-column>
          <el-table-column prop="name" label="名称" width="180"></el-table-column>
          <el-table-column prop="componentPath" label="组件路径"></el-table-column>
          <el-table-column prop="redirect" label="重定向" width="180"></el-table-column>
          <el-table-column width="100" prop="isTree" label="树结构">
            <template slot-scope="scope">
              <i v-if="scope.row.isTree" class="el-icon-check"></i>
              <i v-else class="el-icon-close"></i>
            </template>
          </el-table-column>
          <el-table-column width="100" prop="hidden" label="隐藏">
            <template slot-scope="scope">
              <i v-if="scope.row.hidden" class="el-icon-check"></i>
              <i v-else class="el-icon-close"></i>
            </template>
          </el-table-column>
          <el-table-column width="100" prop="hasChildren" label="子菜单">
            <template slot-scope="scope">
              <i v-if="scope.row.hasChildren" class="el-icon-check"></i>
              <i v-else class="el-icon-close"></i>
            </template>
          </el-table-column>
          <el-table-column prop="parentId" label="父菜单" width="80"></el-table-column>

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