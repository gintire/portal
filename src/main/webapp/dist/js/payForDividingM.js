//숫자 up down
$(function() {
    var action;
    $(".number-spinner button").on("vmousedown", function () {
        btn = $(this);
        input = btn.closest('.number-spinner').find('input');
        btn.closest('.number-spinner').find('button').prop("disabled", false);

    	if (btn.attr('data-dir') == 'up') {
            action = setInterval(function(){
                if ( input.attr('max') == undefined || parseInt(input.val()) < parseInt(input.attr('max')) ) {
                    input.val(parseInt(input.val())+1);
                }else{
                    btn.prop("disabled", true);
                    clearInterval(action);
                }
                $.calc();
            }, 50);
    	} else {
            action = setInterval(function(){
                if ( input.attr('min') == undefined || parseInt(input.val()) > parseInt(input.attr('min')) ) {
                    input.val(parseInt(input.val())-1);
                }else{
                    btn.prop("disabled", true);
                    clearInterval(action);
                }
                $.calc();
            }, 50);
    	}
    }).on("vmouseup",function(){
        clearInterval(action);
    });
});

$.calc = function() {
	  var totAmount = parseInt($('#totAmount').val());
	  var p0 = parseInt($('#P0').val());
	  var p1 = parseInt($('#P1').val());
	  var p2 = parseInt($('#P2').val());
	  var p3 = parseInt($('#P3').val());
	  var p4 = parseInt($('#P4').val());
	  var p5 = parseInt($('#P5').val());
	  var p6 = parseInt($('#P6').val());
	  var p7 = parseInt($('#P7').val());
	  var p8 = parseInt($('#P8').val());
	  
	  var totPerAmount = p0 + p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 ;
	  
	  $('#M0').html(Math.round(totAmount / totPerAmount * p0));
	  $('#M1').html(Math.round(totAmount / totPerAmount * p1));
	  $('#M2').html(Math.round(totAmount / totPerAmount * p2));
	  $('#M3').html(Math.round(totAmount / totPerAmount * p3));
	  $('#M4').html(Math.round(totAmount / totPerAmount * p4));
	  $('#M5').html(Math.round(totAmount / totPerAmount * p5));
	  $('#M6').html(Math.round(totAmount / totPerAmount * p6));
	  $('#M7').html(Math.round(totAmount / totPerAmount * p7));
	  $('#M8').html(Math.round(totAmount / totPerAmount * p8));
};