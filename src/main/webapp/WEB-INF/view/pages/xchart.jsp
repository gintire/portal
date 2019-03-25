<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://d3js.org/d3.v4.min.js"></script>
<style>
   .bubbleChart {
      min-width: 100px;
      max-width: 700px;
      height: 700px;
      margin: 0 auto;
    }
    .bubbleChart svg{
      background: white;
    }
</style>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">전체 데이터 분석</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
    <!-- /.col-lg-12 -->
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <i class="fa fa-bullseye fa-fw"></i>번호별 분석
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="d3bubblechart" align="center"></div>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
</div>
<!-- /#page-wrapper -->
<script>
var diameter = 450,
    format = d3.format(",d"),
    color = d3.scaleOrdinal(d3.schemeCategory20c);

var bubble = d3.pack()
    .size([diameter, diameter])
    .padding(1.5);

var svg = d3.select(".d3bubblechart").append("svg")
    .attr("width", diameter)
    .attr("height", diameter)
    .attr("class", "bubble");
d3.json("d3.do", function(error, data) {
  if (error) throw error;

  var root = d3.hierarchy(classes(data))
      .sum(function(d) { return d.value; })
      .sort(function(a, b) { return b.value - a.value; });

  bubble(root);
  var node = svg.selectAll(".node")
      .data(root.children)
    .enter().append("g")
      .attr("class", "node")
      .attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
  node.append("title")
      .text(function(d) { return d.data.className + ": " + format(d.value); });
  node.append("circle")
      .attr("r", function(d) { return d.r; })
      .on("mouseover", function(d) {
			  d3.select(this).attr("r", function(d) { return d.r*2; }).style("fill", function(d) { 
			        return color(d.data.packageName);
		      });
			})                  
			.on("mouseout", function(d) {
			  d3.select(this).attr("r", function(d) { return d.r; }).style("fill", function(d) { 
			        return color(d.data.packageName);
		      });
			})
      .style("fill", function(d) { 
        return color(d.data.packageName);
      });

  node.append("text")
      .attr("dy", ".3em")
      .style("text-anchor", "middle")
      .text(function(d) { return d.data.className.substring(0, d.r/3); });

  // update - This only applies to updating nodes

});

// Returns a flattened hierarchy containing all leaf nodes under the root.
function classes(root) {
  var classes = [];

  function recurse(name, node) {
    if (node.children) node.children.forEach(function(child) { recurse(node.name, child); });
    else classes.push({packageName: name, className: node.name, value: node.size});
  }

  recurse(null, root);
  return {children: classes};
}
d3.select(self.frameElement).style("height", diameter + "px");

</script>