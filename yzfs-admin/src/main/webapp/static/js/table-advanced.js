var TableAdvanced = function () {

    var initTable1 = function() {

        /* Formating function for row details */

        /*
         * Insert a 'details' column to the table
         */

         

         
        /*
         * Initialse DataTables, with no sorting on the 'details' column
         */
    
        var oTable = $('#sample_1').dataTable( {




            "iDisplayLength": 5,
            "sDom": "<'row-fluid'<'span6'><'span6'>r>t<'row-fluid'<'span6'><'span6'p>>",
            /*l*/                                  /**/
            "sPaginationType": "full_numbers",
            "oLanguage": {
                "sLengthMenu": "_MENU_",/* records per page*/
                "oPaginate": {
                    "sPrevious": "上一页",
                    "sNext": "下一页",
                    "sFirst": "首页",
                    "sLast": "尾页"
                }
            },  
            "aoColumnDefs": [{ "bSortable": false, "aTargets": [5]}],
            "aaSorting": [[6, "desc"]]
           
        });

        jQuery('#sample_1_wrapper .dataTables_filter input').addClass("m-wrap small"); // modify table search input
        jQuery('#sample_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
        jQuery('#sample_1_wrapper .dataTables_length select').select2(); // initialzie select2 dropdown
         
        /* Add event listener for opening and closing details
         * Note that the indicator for showing which row is open is not controlled by DataTables,
         * rather it is done here
         */
        $('#sample_1').on('click', ' tbody td .row-details', function () {
            var nTr = $(this).parents('tr')[0];
            if ( oTable.fnIsOpen(nTr) )
            {
                /* This row is already open - close it */
                $(this).addClass("row-details-close").removeClass("row-details-open");
                oTable.fnClose( nTr );
            }
            else
            {
                /* Open this row */
                $(this).addClass("row-details-open").removeClass("row-details-close");
                oTable.fnOpen( nTr, fnFormatDetails(oTable, nTr), 'details' );
            }
        });
    }

     var initTable2 = function() {
         var oTable = $('#sample_2').dataTable( {
             "iDisplayLength": 5,
             "sDom": "<'row-fluid'<'span6'><'span6'>r>t<'row-fluid'<'span6'><'span6'p>>",
             /*l*/                                  /**/
             "sPaginationType": "bootstrap",
             "oLanguage": {
                 "sLengthMenu": "_MENU_",/* records per page*/
                 "oPaginate": {
                     "sPrevious": "上一页",
                     "sNext": "下一页"
                 }
             },
             "aoColumnDefs": [{
                 'bSortable':false,
                 'aTargets': [5]
             }
             ]
         });


        jQuery('#sample_2_wrapper .dataTables_filter input').addClass("m-wrap small"); // modify table search input
        jQuery('#sample_2_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
        jQuery('#sample_2_wrapper .dataTables_length select').select2(); // initialzie select2 dropdown

        $('#sample_2_column_toggler input[type="checkbox"]').change(function(){
            /* Get the DataTables object again - this is not a recreation, just a get of the object */
            var iCol = parseInt($(this).attr("data-column"));
            var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
            oTable.fnSetColumnVis(iCol, (bVis ? false : true));
        });
    }

    return {

        //main function to initiate the module
        init: function () {
            
            if (!jQuery().dataTable) {
                return;
            }

            initTable1();
            initTable2();
        }

    };

}();