import Vue from "vue";
import App from "./App.vue";
import global_ from "./components/Global";

Vue.config.productionTip = false;
Vue.prototype.Global = global_;

new Vue({
  render: (h) => h(App),
}).$mount("#app");
