<template>
  <div class="echart_3">
    <div class="tit">学院室内温度监测</div>
    <div class="boxnav" id="echart3"></div>
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
    this.chart = echarts.init(document.getElementById("echart3"));
    axios
      .get(`${this.Global.API_URL}data3`)
      .then((response) => {
        console.log(response.data);
        this.s_data = response.data.data;
        let chartData = {
          series: [
            {
              type: "gauge",
              center: ["50%", "60%"],
              startAngle: 200,
              endAngle: -20,
              min: 0,
              max: 60,
              splitNumber: 12,
              itemStyle: {
                color: "#FFAB91",
              },
              progress: {
                show: true,
                width: 30,
              },
              pointer: {
                show: false,
              },
              axisLine: {
                lineStyle: {
                  width: 30,
                },
              },
              axisTick: {
                distance: -45,
                splitNumber: 5,
                lineStyle: {
                  width: 2,
                  color: "#999",
                },
              },
              splitLine: {
                distance: -52,
                length: 14,
                lineStyle: {
                  width: 3,
                  color: "#daf9ff",
                },
              },
              axisLabel: {
                distance: -40,
                color: "#daf9ff",
                fontSize: 20,
              },
              anchor: {
                show: false,
              },
              title: {
                show: false,
              },
              detail: {
                valueAnimation: true,
                width: "60%",
                lineHeight: 40,
                borderRadius: 8,
                offsetCenter: [0, "60%"],
                fontSize: 30,
                fontWeight: "bolder",
                formatter: "{value} °C",
                color: "#daf9ff",
              },
              data: [
                {
                  value: Math.trunc(Math.random() * 50 + 1),
                  name: "Grade Rating",
                },
              ],
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
