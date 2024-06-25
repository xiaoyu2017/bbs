<script>
import bus from '@/utils/EventBus'
import {getUsers} from "@/api/user";
import {MessageBox} from 'element-ui';

export default {
  name: "index",
  data() {
    return {
      tableData: [],
      search: '',
      currentPage: 4
    }
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
    addUser() {
      bus.$emit('openCommonDialog', 'userAdd')
    },
    colInfo(row, type) {
      console.log(JSON.stringify(row))
      console.log(JSON.stringify(type))
    },
  },
  created() {
    getUsers().then(response => {
      this.tableData = response.data
    })
  },

}
</script>

<template>
  <el-row class="box">
    <el-col class="table-box">
      <el-table
          :data="tableData"
          @expand-change="colInfo"
          border
          stripe
          height="100%"
          max-height="100%">
        <el-table-column>
          <template slot="header" slot-scope="scope">
            <el-row>
              <el-col :span="2">
                <el-button style="float: left" type="primary" @click="addUser">新增用户</el-button>
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

          <el-table-column type="expand" label="详情" width="50">
            <template slot-scope="props">
              <el-form label-position="left" inline class="demo-table-expand">
                <el-form-item label="商品名称">
                  <span>{{ props.row.name }}</span>
                </el-form-item>
                <el-form-item label="所属店铺">
                  <span>{{ props.row.shop }}</span>
                </el-form-item>
                <el-form-item label="商品 ID">
                  <span>{{ props.row.id }}</span>
                </el-form-item>
                <el-form-item label="店铺 ID">
                  <span>{{ props.row.shopId }}</span>
                </el-form-item>
                <el-form-item label="商品分类">
                  <span>{{ props.row.category }}</span>
                </el-form-item>
                <el-form-item label="店铺地址">
                  <span>{{ props.row.address }}</span>
                </el-form-item>
                <el-form-item label="商品描述">
                  <span>{{ props.row.desc }}</span>
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>

          <el-table-column prop="uid" label="UID" width="300"></el-table-column>
          <el-table-column prop="userName" label="用户名" width="200"></el-table-column>
          <el-table-column prop="nickName" label="名称" width="200"></el-table-column>
          <el-table-column prop="email" label="邮箱"></el-table-column>

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
          :page-sizes="[100, 200, 300, 400]"
          :page-size="100"
          layout="total, sizes, prev, pager, next, jumper"
          :total="400">
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