<template>
  <div class="echart_8">
    <div class="tit">学院教育研究成果</div>
    <div class="boxnav" id="echart8"></div>
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
    this.chart = echarts.init(document.getElementById("echart8"));
    axios
      .get(`${this.Global.API_URL}data8`)
      .then((response) => {
        console.log(response.data);
        this.s_data = [
          response.data.obj1,
          response.data.obj2,
          response.data.obj3,
        ];
        let chartData = {
          tooltip: {
            trigger: "item",
            formatter: "{a} <br/>{b} : {c}%",
          },

          legend: {
            textStyle: {
              color: "#daf9ff",
            },

            data: ["市级", "省级", "国家级"],
          },
          series: [
            {
              name: "Funnel",
              type: "funnel",
              left: "10%",
              top: 60,
              bottom: 60,
              width: "80%",
              min: 0,
              max: 100,
              minSize: "0%",
              maxSize: "100%",
              sort: "descending",
              gap: 2,

              label: {
                show: true,
                position: "outside",
                color: "#daf9ff",
                fontSize: 16,
                formatter: "{b|{b}}" + "{b|: }" + "{a|{c}}",
                rich: {
                  a: {
                    color: "#daf9ff",
                    fontSize: 14,
                  },
                  b: {
                    color: "#daf9ff",
                    fontSize: 14,
                  },
                },
              },
              labelLine: {
                length: 10,
                lineStyle: {
                  width: 1,
                  type: "solid",
                },
              },
              itemStyle: {
                borderColor: "#daf9ff",
                borderWidth: 1,
              },
              emphasis: {
                label: {
                  fontSize: 20,
                },
              },
              data: [this.s_data[0], this.s_data[1], this.s_data[2]],
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
