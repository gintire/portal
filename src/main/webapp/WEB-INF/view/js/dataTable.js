//Plug-in to fetch page data 
  jQuery.fn.dataTableExt.oApi.fnPagingInfo = function ( oSettings )
  {
    return {
      "iStart":         oSettings._iDisplayStart,
      "iEnd":           oSettings.fnDisplayEnd(),
      "iLength":        oSettings._iDisplayLength,
      "iTotal":         oSettings.fnRecordsTotal(),
      "iFilteredTotal": oSettings.fnRecordsDisplay(),
      "iPage":          oSettings._iDisplayLength === -1 ?
        0 : Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ),
      "iTotalPages":    oSettings._iDisplayLength === -1 ?
        0 : Math.ceil( oSettings.fnRecordsDisplay() / oSettings._iDisplayLength )
    };
  };
  $(document).ready(function($) {
      $(document).ready(function() {
            $('#dataTable').DataTable({
                responsive: true
                ,ordering: true
                ,"bAutoWidth": true
                ,"serverSide":true
                ,"ajax":"dataTable.do"
               ,"processing":true
                ,"fnDrawCallback": function () {
                   alert("Current page number: "+this.fnPagingInfo().iPage);    
                 }
                ,"columns":[
                    {"data":"drwNo"},
                    {"data":"drwNoDate"},
                    {"data":"drwtNo1"},
                    {"data":"drwtNo2"},
                    {"data":"drwtNo3"},
                    {"data":"drwtNo4"},
                    {"data":"drwtNo5"},
                    {"data":"drwtNo6"},
                    {"data":"firstWinamnt"}
                  ]
                ,"columnDefs": [
                                 { "orderable": false, "targets": 0 }
                               ]
            });
        });
    });