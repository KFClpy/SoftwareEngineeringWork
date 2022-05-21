<template>
  <div class="tabs">
    <el-tag
      v-for="(tag,index) in tags"
      :key="tag.name"
      size="small"
      :closable="tag.name !== 'Index'"
      :effect="$route.name === tag.name ? 'dark' : 'plain'"
      @click="changeMenu(tag)"
      @close="handleClose(tag, index)"
    >
      {{ tag.label }}
    </el-tag>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";

export default {
  computed: {
    ...mapState({
      tags: (state) => state.tab.tabsList,
    }),
  },
  methods: {
    ...mapMutations({
      close: "closeTag",
    }),
    changeMenu(item) {
      this.$router.push({ name: item.name });
      this.$store.commit("selectMenu", item);
    },
    handleClose(tag, index) {
      let length = this.tags.length - 1;
      this.close(tag);
      if (tag.name !== this.$route.name) {
        return;
      }
      if (index === length) {
        //向左
        this.$router.push({
          name: this.tags[index - 1].name,
        });
        this.$store.commit("selectMenu", this.tags[index-1]);
      } else {
        //向右
        this.$router.push({
          name: this.tags[index].name,
        });
        this.$store.commit("selectMenu", this.tags[index]);
      }
    },
  },
};
</script>
<style lang="scss">
.tabs {
  padding: 20px;
  .el-tag {
    margin-right: 15px;
    cursor: pointer;
  }
}
</style>
