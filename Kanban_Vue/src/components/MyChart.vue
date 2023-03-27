<template>
  <div id="chart" style="width: 600px; height: 400px"></div>
</template>

<script>
import * as echarts from "echarts";
import axios from "axios";
export default {
  data() {
    return {
      s_data: [5, 20, 36, 10, 10, 20, 5],
    };
  },
  mounted() {
    this.chart = echarts.init(document.getElementById("chart"));
    axios
      .get("https://mock.apifox.cn/m1/2428381-0-default/echart/data01")
      .then((response) => {
        console.log(response.data);
        this.s_data = response.data.e_data;
        let chartData = {
          title: {
            text: "销售数据统计",
          },
          tooltip: {},
          legend: {
            data: ["销售额"],
          },
          xAxis: {
            data: ["周一", "周二", "周三", "周四", "周五", "周六", "周日"],
          },
          yAxis: {},
          series: [
            {
              name: "销售额",
              type: "bar",
              data: this.s_data,
            },
          ],
        };
        this.chart.setOption(chartData);
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
</script>
