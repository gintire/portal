/**
 * central-click.js
 */
d3.svg.BubbleChart.define("central-click", function (options) {
  var self = this;

  self.setup = (function (node) {
    var original = self.setup;
    return function (node) {
      var fn = original.apply(this, arguments);
      self.event.on("click", function(node) {
        if (node.selectAll("text.central-click")[0].length === 1) {
        	//console.log(options.param[1]["list"]);
        	//console.log(options.page[0][0]);
        	var thisNode = node[0][0].classList[1];
        	options.page[0][0].innerHTML="";
        	if(thisNode == "0~9"){
        		options.obj(options.param, 1);	
        	}
        	if(thisNode == "10~19"){
        		options.obj(options.param, 2);	
        	}
        	if(thisNode == "20~29"){
        		options.obj(options.param, 3);	
        	}
        	if(thisNode == "30~39"){
        		options.obj(options.param, 4);	
        	}
        	if(thisNode == "40~45"){
        		options.obj(options.param, 5);	
        	}
        	if(thisNode == "처음으로") {
        		options.obj(options.param, 0);
        	}
        	
        	
        	//options.page.data(options.param[1]["list"]);
        }
      });
      return fn;
    };
  })();

  self.reset = (function (node) {
    var original = self.reset;
    return function (node) {
      var fn = original.apply(this, arguments);
      node.select("text.central-click").remove();
      return fn;
    };
  })();

  self.moveToCentral = (function (node) {
    var original = self.moveToCentral;
    return function (node) {
      var fn = original.apply(this, arguments);
      var transition = self.getTransition().centralNode;
      transition.each("end", function() {
        node.append("text").classed({"central-click": true})
          .attr(options.attr)
          .style(options.style)
          .attr("x", function (d) {return d.cx;})
          .attr("y", function (d) {return d.cy;})
          .text(options.text)
          .style("opacity", 0).transition().duration(self.getOptions().transitDuration / 2).style("opacity", "0.8");
      });
      return fn;
    };
  })();
});