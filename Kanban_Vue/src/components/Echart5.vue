<template>
  <div class="echart_5">
    <div class="tit">学院毕业生去向</div>
    <div class="boxnav" id="echart5"></div>
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
    this.chart = echarts.init(document.getElementById("echart5"));
    axios
      .get(`${this.Global.API_URL}data5`)
      .then((response) => {
        console.log(response.data);
        this.s_data = [
          response.data.obj1,
          response.data.obj2,
          response.data.obj3,
          response.data.obj4,
        ];
        let chartData = {
          tooltip: {
            trigger: "item",
          },
          legend: {
            top: "5%",
            left: "center",
            textStyle: {
              color: "#daf9ff",
            },
            // doesn't perfectly work with our tricks, disable it

            data: ["升学", "单位就业", "创业", "自由职业"],
          },
          series: [
            {
              name: "Access From",
              type: "pie",
              radius: ["40%", "70%"],
              center: ["50%", "70%"],
              // adjust the start angle
              startAngle: 180,
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
                  length: 10,
                  length2: 9,
                },
              },
              itemStyle: {
                normal: {
                  shadowColor: "rgba(0, 0, 0, 0.1)",
                  shadowBlur: 50,
                },
              },

              data: [
                this.s_data[0],
                this.s_data[1],
                this.s_data[2],
                this.s_data[3],
                {
                  // make an record to fill the bottom 50%
                  value:
                    Number(this.s_data[0].value) +
                    Number(this.s_data[1].value) +
                    Number(this.s_data[2].value) +
                    Number(this.s_data[3].value),
                  itemStyle: {
                    // stop the chart from rendering this piece
                    color: "none",
                    decal: {
                      symbol: "none",
                    },
                  },
                  label: {
                    show: false,
                  },
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
