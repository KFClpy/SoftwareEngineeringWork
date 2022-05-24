<template>
  <div class="main">
    <el-form :inline="true">
      <el-form-item>
        <el-input v-model="searchForm.name" placeholder="用户名" clearable>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="searchUser">搜索</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="dialogVisible = true">新增</el-button>
      </el-form-item>
      <el-form-item>
        <el-popconfirm title="确定批量删除吗？" @confirm="delHandle(null)">
          <el-button type="danger" slot="reference" :disabled="delBtlStatu"
            >批量删除</el-button
          >
        </el-popconfirm>
      </el-form-item>
    </el-form>

    <el-table
      ref="multipleTable"
      :data="newData"
      tooltip-effect="dark"
      style="width: 100%"
      border
      stripe
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="num" label="序号" width="100">
        <template slot-scope="scope">
            {{(scope.$index+1)+(current-1)*size}}
          </template>
      </el-table-column>
      <el-table-column prop="name" label="用户名" width="190">
      </el-table-column>
      <el-table-column prop="gender" label="性别" width="110">
        <template slot-scope="scope">
          <el-tag size="big" v-if="scope.row.gender === 1" type="">男</el-tag>
          <el-tag size="big" v-else-if="scope.row.gender === 2" type="danger"
            >女</el-tag
          >
        </template>
      </el-table-column>
      <el-table-column prop="phone" label="手机号" width="240">
      </el-table-column>
      <el-table-column prop="email" label="邮箱" width="380"> </el-table-column>
      <el-table-column prop="icon" label="操作">
        <template slot-scope="scope">
          <el-button type="text" @click="editHandle(scope.row.id)"
            >编辑</el-button
          >
          <el-divider direction="vertical"></el-divider>
          <template>
            <el-popconfirm
              title="确定删除这位用户吗？"
              @confirm="delHandle(scope.row.id)"
            >
              <el-button type="text" slot="reference">删除</el-button>
            </el-popconfirm>
          </template>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      layout="total, sizes, prev, pager, next, jumper"
      :page-sizes="pageSizes"
      :current-page="current"
      :page-size="size"
      :total="total"
    >
    </el-pagination>

    <el-dialog
      title="新增用户"
      :visible.sync="dialogVisible"
      width="600px"
      :before-close="handleClose"
    >
      <el-form :model="editForm" :rules="editFormRules" ref="editForm">
        <el-form-item label="用户名" prop="name" label-width="100px">
          <el-input v-model="editForm.name" auto-complete="on"></el-input>
        </el-form-item>

        <el-form-item label="性别" prop="gender" label-width="100px">
          <el-radio-group v-model="editForm.gender" auto-complete="on" style="margin-right:300px">
            <el-radio :label="1">男</el-radio>
            <el-radio :label="2">女</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="手机号" prop="phone" label-width="100px">
          <el-input v-model="editForm.phone" auto-complete="on"></el-input>
          <el-alert
            title="手机号码将用于联系发放奖品"
            :closable="false"
            type="info"
            style="line-height: 12px"
          ></el-alert>
        </el-form-item>

        <el-form-item label="邮箱" prop="email" label-width="100px">
          <el-input v-model="editForm.email" auto-complete="on"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="resetForm('editForm')">取 消</el-button>
        <el-button type="primary" @click="submitForm('editForm')"
          >确 定</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "People",
  data() {
    return {

      searchForm: {},
      delBtlStatu: true, //批量删除
      pageSize:10,
      total: 0,
      size: 10,
      current: 1,
      pageSizes:[10,20,50,100],
      dialogVisible: false, //弹窗显示
      editForm: {
      },

      tableData: [{
      }],

      newData:[{

      }],

      editFormRules: {
        name: [{ required: true, message: "请输入用户名称", trigger: "blur" }],
        gender: [{ required: true, message: "请选择性别", trigger: "blur" }],
        phone: [{ required: true, message: "请输入手机号码", trigger: "blur" }],
        email: [{ required: true, message: "请输入邮箱", trigger: "blur" }],
      },

      multipleSelection: [],

      treeCheckedKeys: [],
      checkStrictly: true,
    };
  },
  created() {
    this.getUserList();
  },
  methods: {
    toggleSelection(rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      console.log("勾选");
      console.log(val);
      this.multipleSelection = val;

      this.delBtlStatu = val.length == 0;
    },
    cutPage(){
      var list = (this.current-1)*this.size;
      this.newData = this.tableData.slice(list,list+this.size);
      console.log("run1");
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.size = val;
      this.current=1;
      this.cutPage();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.current = val;
      this.cutPage();
    },

    resetForm(formName) {
      //表单清空
      this.$refs[formName].resetFields();
      this.dialogVisible = false;
      this.editForm = {};
    },
    handleClose() {
      //关闭弹窗
      this.resetForm("editForm");
    },

    getUserList() {
      this.$axios
        .post("/info/table", {
          params: {

          },
        })
        .then((res) => {
          console.log("run");
          this.tableData = res.data.table;
          console.log(res.data.table);
          this.total=res.data.table.length;
          this.cutPage();
        });
    },
    searchUser() {
      this.$axios
        .post("/info/searchInfo?name="+this.searchForm.name)
        .then((res) => {
          console.log("run");
          this.tableData = res.data.table;
          this.total=res.data.table.length;
          this.cutPage();
        });
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios
            .post(
              "/info/" + (this.editForm.id ? "updateInfo" : "addInfo"),
              this.editForm
            )
            .then((res) => {
              this.getUserList();
              this.$message({
                showClose: true,
                message: "恭喜你，操作成功",
                type: "success",
              });

              this.dialogVisible = false;
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    editHandle(id) {
      //编辑
      this.$axios.post("/info/fillTable?mid="+id).then((res) => {
        console.log(res.data.table)
        this.editForm = res.data.table;

        this.dialogVisible = true;
      });
    },
    delHandle(id) {
      var ids = [];

      if (id) {
        ids.push(id);
      } else {
        this.multipleSelection.forEach((row) => {
          ids.push(row.id);
        });
      }

      console.log(ids);
      this.$axios.post("/info/deleteInfo?mid="+ids).then((res) => {
        this.getUserList();
        this.$message({
          showClose: true,
          message: "恭喜你，操作成功",
          type: "success",
        });
      });
    },
  },
};
</script>

<style scoped>
.el-pagination {
  /* float: right; */
  margin-top: 20px;
  margin-bottom: 20px;
}
.main{
  height: 81.9vh;
}
</style>
