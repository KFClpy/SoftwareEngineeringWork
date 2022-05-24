<template>
  <div class="main">
    <el-form :inline="true">
      <el-form-item>
        <el-input v-model="searchForm.aname" placeholder="名称" clearable>
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
          {{ scope.$index + 1 + (current - 1) * size }}
        </template>
      </el-table-column>
      <el-table-column prop="aname" label="名称" width="190"> </el-table-column>
      <el-table-column prop="picture" label="图片" width="110">
        <template slot-scope="scope">
          <img
            :src="scope.row.img"
            alt="请稍后加载"
            style="width: 90px; height: 90px"
          />
        </template>
      </el-table-column>
      <el-table-column prop="num" label="数目" sortable width="100">
      </el-table-column>
      <el-table-column prop="intro" label="详情" width="580">
      </el-table-column>
      <el-table-column prop="icon" label="操作">
        <template slot-scope="scope">
          <el-button type="text" @click="editHandle(scope.row.aid)"
            >编辑</el-button
          >
          <el-divider direction="vertical"></el-divider>
          <template>
            <el-popconfirm
              title="确定删除这个奖品吗？"
              @confirm="delHandle(scope.row.aid)"
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
      title="新增奖品"
      :visible.sync="dialogVisible"
      width="600px"
      :before-close="handleClose"
    >
      <el-form :model="editForm" :rules="editFormRules" ref="editForm">
        <el-form-item label="名称" prop="aname" label-width="100px">
          <el-input v-model="editForm.aname" auto-complete="on"></el-input>
        </el-form-item>

        <el-form-item label="数目" prop="num" label-width="100px">
          <el-input v-model="editForm.num" auto-complete="on"></el-input>
        </el-form-item>

        <el-form-item label="详情" prop="intro" label-width="100px">
          <el-input v-model="editForm.intro" auto-complete="on"></el-input>
          <el-alert
            title="可在此处完善奖品的具体信息"
            :closable="false"
            type="info"
            style="line-height: 12px"
          ></el-alert>
        </el-form-item>

        <el-form-item label="图片" prop="picture" label-width="100px">
          <el-upload
            class="upload-demo"
            action="#"
            list-type="picture"
            :on-remove="handleRemove"
            :before-remove="beforeRemove"
            :before-upload="beforeProductUpload"
            :multiple="false"
            :limit="1"
            :on-exceed="handleExceed"
            :file-list="fileList"
            :headers="headers"
            :on-change="onChange"
            accept=".jpg"
          >
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">
              只能上传jpg文件，且不超过2M
            </div>
          </el-upload>
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
      pageSize: 10,
      total: 0,
      size: 10,
      current: 1,
      pageSizes: [10, 20, 50, 100],
      dialogVisible: false, //弹窗显示
      ImgValid: false,
      editForm: {
        aname: "",
        num: "",
        intro: "",
        files:[]
      },

      tableData: [{}],
      headers:{
        'Content-Type':'multipart/form-data'
      }
      ,
      newData: [{}],

      editFormRules: {
        aname: [{ required: true, message: "请输入名称", trigger: "blur" }],
        num: [{ required: true, message: "请选择个数", trigger: "blur" }],
      },

      multipleSelection: [],

      treeCheckedKeys: [],
      checkStrictly: true,
      fileList: [],
    };
  },
  created() {
    this.getUserList();
  },
  methods: {
    handleRemove(file, fileList) {

      console.log(file, fileList);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`只能上传一张图片哦`);
    },
    beforeRemove(file, fileList) {
      if(this.ImgValid){
        let temp=this.$confirm(`确定移除 ${file.aname}？`)
      if(temp){
      this.editForm.files.pop()
      this.ImgValid=false;
      }
       return temp
      }
      else
      {
        this.ImgValid=false;
        return true;
      }
    },
    beforeProductUpload(file) {
       const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;
        this.ImgValid=isJPG&&isLt2M;
      if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
          this.editForm.files.pop()
          return false;
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
          this.editForm.files.pop()
          return false;
        }
      var _this = this;
      return new Promise(function (resolve, reject) {
        var reader = new FileReader();
        reader.readAsDataURL(file); // 这里是最关键的一步，转换成base64
        reader.onload = function (event) {
          // _this.editForm.imageurl.push(event.target.result); //定义参数获取图片路径
        };
      });

    },
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
    cutPage() {
      var list = (this.current - 1) * this.size;
      this.newData = this.tableData.slice(list, list + this.size);
      console.log("run1");
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.size = val;
      this.current = 1;
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
      this.fileList = [];
      this.dialogVisible = false;
      this.editForm = {
        files: []
      };
    },
    handleClose() {
      //关闭弹窗
      this.resetForm("editForm");
    },

    getUserList() {
      this.$axios
        .post("/award/table", {
          params: {},
        })
        .then((res) => {
          this.tableData = res.data.table;
          this.total = res.data.table.length;
          this.cutPage();
        });
    },
    searchUser() {
      this.$axios
        .post("/award/searchAward?aname=" + this.searchForm.aname)
        .then((res) => {
          this.tableData = res.data.table;
          this.total = res.data.table.length;
          this.cutPage();
        });
    },
    onChange(file)
    {
      this.editForm.files.push(file);
    }
    ,
    submitForm(formName) {
      let _this = this
      this.$refs[formName].validate((valid) => {
        let params=new FormData();
        params.append('aname',_this.editForm.aname);
        params.append('num',_this.editForm.num);
        params.append('intro',_this.editForm.intro);
        if(_this.editForm.aid)params.append('aid',this.editForm.aid)
        console.log(_this.editForm.files)
        console.log(_this.editForm.aname)
        console.log(_this.editForm.num)
        console.log(_this.editForm.intro)
        _this.editForm.files.map(item=>{
          params.append("file",item.raw)
        })
        if (valid&&_this.ImgValid) {
          _this.$axios
            .post(
              "/award/" + (_this.editForm.aid ? "updateAward" : "addAward"),
              params
            )
            .then((res) => {
              console.log(_this.editForm);
              _this.getUserList();
              _this.$message({
                showClose: true,
                message: "恭喜你，操作成功",
                type: "success",
              });

              _this.dialogVisible = false;
            });
        } else {
          console.log("error submit!!");
          _this.$message({
                showClose: true,
                message:"请上传图片",
                type: "error",
              });
        }
      });
    },
    editHandle(aid) {
      //编辑
      this.$axios.post("/award/fillTable?aid=" + aid).then((res) => {
        console.log(res.data.table);
        this.editForm.aid = res.data.table.aid;
        this.editForm.aname = res.data.table.aname;
        this.editForm.num = res.data.table.num;
        this.editForm.intro = res.data.table.intro;
        this.dialogVisible = true;
      });
    },
    delHandle(aid) {
      var ids = [];

      if (aid) {
        ids.push(aid);
      } else {
        this.multipleSelection.forEach((row) => {
          ids.push(row.aid);
        });
      }

      console.log(ids);
      this.$axios.post("/award/deleteAward?aid=" + ids).then((res) => {
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
.main {
  height: 81.9vh;
}
</style>
