<template>
  <div class="echart_4">
    <div class="tit">学院学生课余活动调查</div>
    <div class="boxnav" id="echart4"></div>
  </div>
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
    this.chart = echarts.init(document.getElementById("echart4"));
    axios
      .get(`${this.Global.API_URL}data4`)
      .then((response) => {
        console.log(response.data);
        this.s_data = response.data.data;
        let chartData = {
          color: ["#1aa1ff", "#31c17b", "#ff6535"],
          tooltip: {
            trigger: "axis",
            axisPointer: {
              type: "shadow",
            },
          },
          grid: {
            left: "0%",
            top: "15px",
            right: "0%",
            bottom: "3%",
            containLabel: true,
          },
          xAxis: {
            data: [
              "体育锻炼",
              "上网冲浪",
              "看书学习",
              "补充睡眠",
              "参加活动",
              "其它",
            ],
            axisLine: { show: false },
            axisLabel: {
              color: "#daf9ff",
              fontSize: 12,
              interval: 0,
            },
          },
          yAxis: {
            name: "（人）",
            splitNumber: 4,
            nameTextStyle: {
              color: "#daf9ff",
              fontSize: 12,
            },
            axisLine: { show: false },
            axisLabel: {
              color: "#daf9ff",
              fontSize: 12,
            },
            splitLine: {
              lineStyle: {
                color: "#daf9ff",
                type: "dotted",
              },
            },
            //interval:100,
            //max:500
          },
          series: [
            {
              type: "bar",
              barWidth: "25%",
              itemStyle: {
                normal: {
                  barBorderRadius: 50,
                  color: function (params) {
                    var colorList = [
                      "#4591e3",
                      "#04b8e5",
                      "#04dde5",
                      "#04e5bd",
                      "#04e57e",
                      "#fedb5b",
                      "#e59e04",
                      "#ff632d",
                      "#ff639e",
                      "#ff82e9",
                      "#b562e4",
                    ];

                    return colorList[params.dataIndex];
                  },

                  label: {
                    show: true,
                    position: "top",
                    formatter: "{c}",
                    color: "#daf9ff",
                    fontSize: 12,
                  },
                },
              },

              data: this.s_data,
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
