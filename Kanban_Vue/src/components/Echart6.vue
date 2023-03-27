<template>
  <div class="echart_6">
    <div class="tit">学院图书馆借阅情况</div>
    <div class="boxnav" id="echart6"></div>
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
    this.chart = echarts.init(document.getElementById("echart6"));
    axios
      .get(`${this.Global.API_URL}data6`)
      .then((response) => {
        console.log(response.data);
        this.s_data = response.data.data;
        let chartData = {
          legend: {
            data: ["Allocated Budget", "Actual Spending"],
          },
          radar: {
            // shape: 'circle',
            indicator: [
              { name: "文学类书籍", max: 3000 },
              { name: "休闲娱乐类书籍", max: 3000 },
              { name: "经典古籍", max: 3000 },
              { name: "专业类书籍", max: 3000 },
              { name: "其它类别书籍", max: 3000 },
            ],
            name: {
              //修改indicator文字的颜色
              textStyle: {
                color: "#daf9ff",
              },
            },
          },

          series: [
            {
              type: "radar",
              color: "#00FFC3",

              data: [
                {
                  value: this.s_data,
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
