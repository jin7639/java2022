
let jsonlist1;
let jsonlist2;
let jsonlist3;

$( function(){ 
	
	$.ajax({
		url : "/jspweb/admin/getchart",
		data :{"type" : 1},
		success : function( result ){
			console.log(result);
			jsonlist1 = result;

			///////////////////////////////////////// 에이엠 차트1 ////////////////////////////////////////////////////
			am5.ready(function() {
			
			// Create root element
			// https://www.amcharts.com/docs/v5/getting-started/#Root_element
			var root1 = am5.Root.new("chartdiv1");
			
			// Set themes
			// https://www.amcharts.com/docs/v5/concepts/themes/
			root1.setThemes([
			  am5themes_Animated.new(root1)
			]);
			
			
			// Create chart
			// https://www.amcharts.com/docs/v5/charts/xy-chart/
			var chart = root1.container.children.push(am5xy.XYChart.new(root1, {
			  panX: false,
			  panY: false,
			  wheelX: "panX",
			  wheelY: "zoomX"
			}));
			
			
			// Add cursor
			// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
			var cursor = chart.set("cursor", am5xy.XYCursor.new(root1, {
			  behavior: "zoomX"
			}));
			cursor.lineY.set("visible", false);
			
			//var date = new Date();
			//date.setHours(0, 0, 0, 0);
			//var value = 100;
			
			function generateData(i) {
				// 1. i번째 객체에서 값 가져오기
			  let value = parseInt(jsonlist1[i]["value"]);
			  //2. i 번째 객체에서 날짜 가져오기
			  	//날짜형식으로 변환(문자 -> date)
			  let date = new Date(jsonlist1[i]["date"]);
			  
			  date.setHours(0, 0, 0, 0);
			  am5.time.add(date, "day", 0); 
			  return {
			    date: date.getTime(),
			    value: value
			  };
			}
			
			function generateDatas(count) {
			  var data = [];
			  for (var i = 0; i < count; ++i) {
			    data.push(generateData(i));
			  }
			  return data;
			}
			
			
			// Create axes
			// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
			var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root1, {
			  maxDeviation: 0,
			  baseInterval: {
			    timeUnit: "day",
			    count: 1
			  },
			  renderer: am5xy.AxisRendererX.new(root1, {}),
			  tooltip: am5.Tooltip.new(root1, {})
			}));
			
			var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root1, {
			  renderer: am5xy.AxisRendererY.new(root1, {})
			}));
			
			
			// Add series
			// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
			var series = chart.series.push(am5xy.ColumnSeries.new(root1, {
			  name: "Series",
			  xAxis: xAxis,
			  yAxis: yAxis,
			  valueYField: "value",
			  valueXField: "date",
			  tooltip: am5.Tooltip.new(root1, {
			    labelText: "{valueY}"
			  })
			}));
			
			
			
			// Add scrollbar
			// https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
			chart.set("scrollbarX", am5.Scrollbar.new(root1, {
			  orientation: "horizontal"
			}));
			
			var data = generateDatas(jsonlist1.length); // 차트에 들어가는 데이터 [인수 : 객체수]
			series.data.setAll(data);
			
			
			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			series.appear(1000);
			chart.appear(1000, 100);
			
			}); // end am5.ready()
			///////////////////////////////////////// 에이엠 차트1 끝 ////////////////////////////////////////////////////
		
	$.ajax({
		url : "/jspweb/admin/getchart",
		data : { "type" : 2 } , 
		success : function( result ){
			jsonlist2 = result;
			///////////////////////////////////////// 에이엠 차트2  ////////////////////////////////////////////////////
			am5.ready(function() {

			// Create root element
			// https://www.amcharts.com/docs/v5/getting-started/#Root_element
			var root2 = am5.Root.new("chartdiv2");
			
			
			// Set themes
			// https://www.amcharts.com/docs/v5/concepts/themes/
			root2.setThemes([
			  am5themes_Animated.new(root2)
			]);
			
			
			// Create chart
			// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
			var chart = root2.container.children.push(am5percent.PieChart.new(root2, {
			  layout: root2.verticalLayout,
			  innerRadius: am5.percent(50)
			}));
			
			
			// Create series
			// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
			var series = chart.series.push(am5percent.PieSeries.new(root2, {
			  valueField: "value",
			  categoryField: "category",
			  alignLabels: false
			}));
			
			series.labels.template.setAll({
			  textType: "circular",
			  centerX: 0,
			  centerY: 0
			});
			
			
			// Set data
			// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Setting_data
			series.data.setAll(jsonlist2);
			
			
			// Create legend
			// https://www.amcharts.com/docs/v5/charts/percent-charts/legend-percent-series/
			var legend = chart.children.push(am5.Legend.new(root2, {
			  centerX: am5.percent(50),
			  x: am5.percent(50),
			  marginTop: 15,
			  marginBottom: 15,
			}));
			
			legend.data.setAll(series.dataItems);
			
			
			// Play initial series animation
			// https://www.amcharts.com/docs/v5/concepts/animations/#Animation_of_series
			series.appear(1000, 100);
			
			}); // end am5.ready()
			///////////////////////////////////////// 에이엠 차트2 끝 ////////////////////////////////////////////////////
		
		}
		});
	}
	});
});
function regetchart(){
	
}

function getchart(sno){
	alert(sno);
	$.ajax({
		url : "/jspweb/admin/getchart",
		data : {"type" : 3 , "value" : sno},
		success : function(result){
			console.log(result);
			jsonlist3 = result;
			console.log("jsonlist3 : "+ jsonlist3);
			
			am5.ready(function() {
				
				// Create root element
				// https://www.amcharts.com/docs/v5/getting-started/#Root_element
				var root3 = am5.Root.new("chartdiv3");
				
				
				// Set themes
				// https://www.amcharts.com/docs/v5/concepts/themes/
				root3.setThemes([
				  am5themes_Animated.new(root3)
				]);
				
				
				// Create chart
				// https://www.amcharts.com/docs/v5/charts/xy-chart/
				var chart = root3.container.children.push(am5xy.XYChart.new(root3, {
				  panX: true,
				  panY: true,
				  wheelX: "panX",
				  wheelY: "zoomX",
				  pinchZoomX:true
				}));
				
				
				// Add cursor
				// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
				var cursor = chart.set("cursor", am5xy.XYCursor.new(root3, {
				  behavior: "none"
				}));
				cursor.lineY.set("visible", false);
				
				
				// Generate random data
				//var date = new Date();
				//var value = 100;
				
				function generateData(i) {
				  let date = new Date(jsonlist3[i]["date"]);
				  let value = parseInt(jsonlist3[i]["value"]);
				  console.log("value : " + value);
				  date.setHours(0, 0, 0, 0);
				  am5.time.add(date, "day", 0);
				  return {
				    date: date.getTime(),
				    value: value
				  };
				}
				
				function generateDatas(count) {
				  var data = [];
				  for (var i = 0; i < count; ++i) {
				    data.push(generateData(i));
				  }
				  return data;
				}
				
				
				// Create axes
				// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
				var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root3, {
				  maxDeviation: 0.2,
				  baseInterval: {
				    timeUnit: "day",
				    count: 1
				  },
				  renderer: am5xy.AxisRendererX.new(root3, {}),
				  tooltip: am5.Tooltip.new(root3, {})
				}));
				
				var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root3, {
				  renderer: am5xy.AxisRendererY.new(root3, {})
				}));
				
				
				// Add series
				// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
				var series = chart.series.push(am5xy.LineSeries.new(root3, {
				  name: "Series",
				  xAxis: xAxis,
				  yAxis: yAxis,
				  valueYField: "value",
				  valueXField: "date",
				  tooltip: am5.Tooltip.new(root3, {
				    labelText: "{valueY}"
				  })
				}));
				
				
				// Add scrollbar
				// https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
				chart.set("scrollbarX", am5.Scrollbar.new(root3, {
				  orientation: "horizontal"
				}));
				
				
				// Set data
				var data = generateDatas(jsonlist3.length);
				series.data.setAll(data);
				
				// Make stuff animate on load
				// https://www.amcharts.com/docs/v5/concepts/animations/
				series.appear(1000);
				chart.appear(1000, 100);
				
				}); // end am5.ready()
		
		}
	});
	
}