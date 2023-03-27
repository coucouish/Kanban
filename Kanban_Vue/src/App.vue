<template>
  <div id="app">
    <div class="head clearfix">
      <h1>智慧学院数据中心大屏</h1>
      <div class="time" id="showTime"></div>
      <timer></timer>
    </div>
    <div class="mainbox">
      <ul class="clearfix nav1">
        <li id="li1" style="width: 25%">
          <echart1 class="box"></echart1>
          <echart2 class="box"></echart2>
        </li>
        <li style="width: 25%">
          <echart3 class="box"></echart3>
          <echart4 class="box"></echart4>
        </li>
        <li style="width: 25%">
          <echart5 class="box"></echart5>
          <echart6 class="box"></echart6>
        </li>
        <li style="width: 25%">
          <echart7 class="box"></echart7>
          <echart8 class="box"></echart8>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
import MyChart from "./components/MyChart.vue";
import Echart1 from "./components/Echart1.vue";
import Echart2 from "./components/Echart2.vue";
import Echart3 from "./components/Echart3.vue";
import Echart4 from "./components/Echart4.vue";
import Echart5 from "./components/Echart5.vue";
import Echart6 from "./components/Echart6.vue";
import Echart7 from "./components/Echart7.vue";
import Echart8 from "./components/Echart8.vue";
import Timer from "./components/Timer.vue";

export default {
  name: "App",
  components: {
    HelloWorld,
    MyChart,
    Echart1,
    Echart2,
    Echart3,
    Echart4,
    Echart5,
    Echart6,
    Echart7,
    Echart8,
    Timer,
  },
};
</script>

<style>
* {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  padding: 0;
  margin: 0;
  /*背景颜色为径向渐变*/
  background: radial-gradient(#034f8e, #034987, #02366d, #002353);
  background: -webkit-radial-gradient(#034f8e, #034987, #02366d, #002353);
  background: -moz-radial-gradient(#034f8e, #034987, #02366d, #002353);
}
#app {
  color: #daf9ff; /*设置字体颜色*/
  font-size: 16px; /* 设置字体大小 */
  /*背景颜色为径向渐变*/
  min-height: 100%;
  background-size: cover;
}
.head {
  position: relative;
  height: 90px;
  margin: 0 15px;
  padding-right: 60px;
}

.head h1 {
  font-size: 30px;
  letter-spacing: -2px;
  text-align: center;
  line-height: 90px;
  padding-right: 55px;
  color: #daf9ff;
}

.clearfix {
  clear: both;
}

/* 设置时钟样式 */
.time {
  position: absolute;
  right: 0;
  line-height: 90px;
  top: 0;
}
.text {
  position: absolute;
  left: 0;
  line-height: 90px;
  top: 0;
}

.mainbox {
  padding: 0 10px;
}
li {
  list-style-type: none;
  padding: 0 6px;
  float: left;
}

.nav1 {
  margin-left: -6px;
  margin-right: -6px;
}

.box {
  border: 1px solid rgba(7, 118, 181, 0.5);
  box-shadow: inset 0 0 10px rgba(7, 118, 181, 0.4);
  margin-bottom: 12px;
  position: relative;
}
.box:before {
  width: 100%;
  height: 1px;
  content: "";
  position: absolute;
  left: 0;
  bottom: -1px;
  background: linear-gradient(to right, #076ead, #4ba6e0, #076ead);
  box-shadow: 0 0 5px rgba(131, 189, 227, 1);
  opacity: 0.6;
}
.boxnav {
  padding: 10px;
  height: 390px;
}
</style>
