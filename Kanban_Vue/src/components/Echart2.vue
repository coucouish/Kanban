<template>
  <div class="echart_2">
    <div class="tit">学院年级人数分布</div>
    <div class="boxnav" id="echart2"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import axios from "axios";
export default {
  data() {
    return {
      s_data: [5, 20, 36, 10],
    };
  },
  mounted() {
    this.chart = echarts.init(document.getElementById("echart2"));
    axios
      .get(`${this.Global.API_URL}data2`)
      .then((response) => {
        console.log(response.data);
        this.s_data = response.data.data;
        let chartData = {
          xAxis: {
            type: "category",
            data: ["大一", "大二", "大三", "大四"],
          },
          yAxis: {
            type: "value",
          },
          axisLabel: {
            margin: 10,
            color: "#daf9ff",
            fontSize: 16,
          },
          series: [
            {
              data: this.s_data,
              type: "bar",
              showBackground: true,
              color: "#1196ad",
            },
          ],
        };
        this.chart.setOption(chartData);
        window.addEventListener("resize", function () {
          this.chart.resize();
        });
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
</script>

<style>
.tit {
  color: #daf9ff;
  padding: 10px 10px 10px 25px;
  border-bottom: 1px solid rgba(7, 118, 181, 0.7);

  font-size: 20px;
  font-weight: 500;
  position: relative;
}
.tit:before {
  position: absolute;
  content: "";
  width: 6px;
  height: 6px;
  background: rgba(22, 214, 255, 0.9);
  box-shadow: 0 0 5px rgba(22, 214, 255, 0.9);
  border-radius: 10px;
  left: 10px;
  top: 18px;
}
.boxnav {
  padding: 10px;
  height: 390px;
}
</style>
