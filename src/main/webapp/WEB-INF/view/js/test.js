/* <script src="http://phuonghuynh.github.io/js/bower_components/jquery/dist/jquery.min.js"></script>
  <script src="http://phuonghuynh.github.io/js/bower_components/d3/d3.min.js"></script>
  <script src="http://phuonghuynh.github.io/js/bower_components/d3-transform/src/d3-transform.js"></script>
  <script src="http://phuonghuynh.github.io/js/bower_components/cafej/src/extarray.js"></script>
  <script src="http://phuonghuynh.github.io/js/bower_components/cafej/src/misc.js"></script>
  <script src="http://phuonghuynh.github.io/js/bower_components/cafej/src/micro-observer.js"></script>
  <script src="http://phuonghuynh.github.io/js/bower_components/microplugin/src/microplugin.js"></script>
  <script src="http://phuonghuynh.github.io/js/bower_components/bubble-chart/src/bubble-chart.js"></script>
  <script src="http://phuonghuynh.github.io/js/bower_components/bubble-chart/src/plugins/central-click/central-click.js"></script>
  <script src="http://phuonghuynh.github.io/js/bower_components/bubble-chart/src/plugins/lines/lines.js"></script>

    
 function fn(item) {
	  var bubblechart = new d3.svg.BubbleChart({
	    supportResponsive: true,
	    //container: => use @default
	    size: 600,
	    //viewBoxSize: => use @default
	    innerRadius: 600 / 3.5,
	    //outerRadius: => use @default
	    radiusMin: 50,
	    //radiusMax: use @default
	    //intersectDelta: use @default
	    //intersectInc: use @default
	    //circleColor: use @default
	    
	    data: {
	      items: item,
	      eval: function (item) {return item.count;},
	      classed: function (item) {return item.text.split(" ").join("");}
	    },
	    plugins: [
	      {
	        name: "central-click",
	        options: {
	          text: "(See more detail)",
	          style: {
	            "font-size": "12px",
	            "font-style": "italic",
	            "font-family": "Source Sans Pro, sans-serif",
	            //"font-weight": "700",
	            "text-anchor": "middle",
	            "fill": "white"
	          },
	          attr: {dy: "65px"}
	        }
	      },
	      {
	        name: "lines",
	        options: {
	          format: [
	            {// Line #0
	              textField: "count",
	              classed: {count: true},
	              style: {
	                "font-size": "28px",
	                "font-family": "Source Sans Pro, sans-serif",
	                "text-anchor": "middle",
	                fill: "white"
	              },
	              attr: {
	                dy: "0px",
	                x: function (d) {return d.cx;},
	                y: function (d) {return d.cy;}
	              }
	            },
	            {// Line #1
	              textField: "text",
	              classed: {text: true},
	              style: {
	                "font-size": "14px",
	                "font-family": "Source Sans Pro, sans-serif",
	                "text-anchor": "middle",
	                fill: "white"
	              },
	              attr: {
	                dy: "20px",
	                x: function (d) {return d.cx;},
	                y: function (d) {return d.cy;}
	              }
	            }
	          ],
	          centralFormat: [
	            {// Line #0
	              style: {"font-size": "50px"},
	              attr: {}
	            },
	            {// Line #1
	              style: {"font-size": "30px"},
	              attr: {dy: "40px"}
	            }
	          ]
	        }
	      }]
	  });
	};
	$(document).ready(function(){
		  $.getJSON("test.do",function(json){
			console.log(json)
		  fn(json);
		  })
		})

*/