$(function() {
  // Create a function that will handle AJAX requests
  $(function(){
	  $.getJSON("/morrisBarChart.do", function (json) { // callback function which gets called when your request completes. 
  		Morris.Bar({
  	        element: 'morris-bar-chart',
  	        data : json,
  	        xkey: 'num',
  	        ykeys: ['freq'],
  	        labels: ['freq'],
  	        hideHover: 'auto',
  	        resize: true,
  	        gridTextColor : '#333'
  	    });
      });
	  $.getJSON("/morrisDonutChart.do", function (json) { // callback function which gets called when your request completes. 
	  Morris.Donut({
        element: 'morris-donut-chart',
        data: json,
        resize: true
	    });
	  })
	  $.getJSON("/morrisLineChart.do", function (json) { // callback function which gets called when your request completes.
		  Morris.Line({
	  		  element: 'morris-line-chart',
	  		  data: json,
	  		  xkey: 'year',
	  		  ykeys: ['num1Freq','num2Freq','num3Freq','num4Freq','num5Freq','num6Freq','num7Freq','num8Freq','num9Freq','num10Freq','num11Freq','num12Freq','num13Freq','num14Freq','num15Freq','num16Freq','num17Freq','num18Freq','num19Freq','num20Freq','num21Freq','num22Freq','num23Freq','num24Freq','num25Freq','num26Freq','num27Freq','num28Freq','num29Freq','num30Freq','num31Freq','num32Freq','num33Freq','num34Freq','num35Freq','num36Freq','num37Freq','num38Freq','num39Freq','num40Freq','num41Freq','num42Freq','num43Freq','num44Freq','num45Freq'],
	  		  labels: ['1번','2번','3번','4번','5번','6번','7번','8번','9번','10번','11번','12번','13번','14번','15번','16번','17번','18번','19번','20번','21번','22번','23번','24번','25번','26번','27번','28번','29번','30번','31번','32번','33번','34번','35번','36번','37번','38번','39번','40번','41번','42번','43번','44번','45번'],
	  		  hideHover: 'auto',
	  		  resize: true,
	  		});
	 		 Morris.Area({
	   	        element: 'morris-area-chart',
	   	        data: json,
	   	        xkey: 'year',
	   	        ykeys: ['num1Freq','num2Freq','num3Freq','num4Freq','num5Freq','num6Freq','num7Freq','num8Freq','num9Freq','num10Freq','num11Freq','num12Freq','num13Freq','num14Freq','num15Freq','num16Freq','num17Freq','num18Freq','num19Freq','num20Freq','num21Freq','num22Freq','num23Freq','num24Freq','num25Freq','num26Freq','num27Freq','num28Freq','num29Freq','num30Freq','num31Freq','num32Freq','num33Freq','num34Freq','num35Freq','num36Freq','num37Freq','num38Freq','num39Freq','num40Freq','num41Freq','num42Freq','num43Freq','num44Freq','num45Freq'],
	  		    labels: ['1번','2번','3번','4번','5번','6번','7번','8번','9번','10번','11번','12번','13번','14번','15번','16번','17번','18번','19번','20번','21번','22번','23번','24번','25번','26번','27번','28번','29번','30번','31번','32번','33번','34번','35번','36번','37번','38번','39번','40번','41번','42번','43번','44번','45번'],
	   	        pointSize: 3,
	   	        hideHover: 'auto',
	   	        resize: true,
	   	        behaveLikeLine : 'true'
	   	    });
	  })
  });
});
