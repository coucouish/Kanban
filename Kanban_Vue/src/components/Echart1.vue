<template>
  <div class="echart_1">
    <div class="tit">学院学生基础信息</div>
    <div class="boxnav" id="echart1"></div>
  </div>
</template>

<script>
import * as echarts from "echarts";
import axios from "axios";
export default {
  data() {
    return {
      s_data: [5, 20],
    };
  },
  mounted() {
    this.chart = echarts.init(document.getElementById("echart1"));
    axios
      .get(`${this.Global.API_URL}data1`)
      .then((response) => {
        console.log(response.data);
        this.s_data = response.data.data;
        let chartData = {
          legend: {
            //orient: 'vertical',
            top: "20",
            left: "center",
            itemWidth: 10,
            itemHeight: 10,
            data: ["男生", "女生"],
            textStyle: {
              color: "#daf9ff",
              fontSize: "12",
            },
          },
          tooltip: {
            trigger: "item",
            formatter: "{b} : {c} ({d}%)",
          },

          visualMap: {
            show: false,
            min: 500,
            max: 600,
            inRange: {
              //colorLightness: [0, 1]
            },
          },
          series: [
            {
              name: "分布",
              type: "pie",
              radius: ["30%", "60%"],
              center: ["50%", "60%"],
              color: [
                "#0086e5",
                "#30c5ed",
                "#9fe7b8",
                "#fedb5b",
                "#ff9f7d",
                "#fb7293",
                "#e7bcf2",
              ], //'#FBFE27','rgb(11,228,96)','#FE5050'
              data: [
                {
                  value: this.s_data[0],
                  name: "男生",
                },
                {
                  value: this.s_data[1],
                  name: "女生",
                },
              ].sort(function (a, b) {
                return a.value - b.value;
              }),
              roseType: "radius",

              label: {
                normal: {
                  formatter: ["{d|{d}%}", "{b|{b}}"].join("\n"),
                  rich: {
                    d: {
                      color: "#daf9ff",
                      fontSize: 14,
                      fontWeight: "bold",
                    },
                    b: {
                      color: "#daf9ff",
                      fontSize: 12,
                    },
                  },
                },
              },
              labelLine: {
                normal: {
                  lineStyle: {
                    color: "rgb(98,137,169)",
                  },
                  smooth: 0.2,
                  length: 5,
                  length2: 9,
                },
              },
              itemStyle: {
                normal: {
                  shadowColor: "rgba(0, 0, 0, 0.1)",
                  shadowBlur: 50,
                },
              },
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
