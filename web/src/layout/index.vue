<template>
  <v-app>

    <layout-bar/>

    <v-main class="grey lighten-3">
      <v-container>
        <router-view/>
      </v-container>
    </v-main>

    <layout-footer/>

  </v-app>
</template>

<script>
import LayoutBar from "@/layout/LayoutBar.vue";
import LayoutFooter from "@/layout/LayoutFooter.vue";

export default {
  components: {LayoutFooter, LayoutBar},
  data: () => ({

  }),
}
</script>
