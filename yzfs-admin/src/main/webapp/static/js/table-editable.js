var TableEditable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }

                oTable.fnDraw();

            }

            function edit_goodsRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" class="m-wrap small" value="' + aData[0] + '">';
                jqTds[1].innerHTML = '<input type="text" class="m-wrap small" value="' + aData[1] + '">';
                jqTds[2].innerHTML = '<input type="text" class="m-wrap small" value="' + aData[2] + '">';
                jqTds[3].innerHTML = '<a class="edit" href="">编辑</a> <a class="cancel" href="">取消</a>';
            }
            function save_goodsRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate('<a class="edit" href="">编辑</a><a class="delete" id="delete_store" href="">删除</a>', nRow,3, false)
            }
            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate('<a class="edit" href="">编辑</a>', nRow, 4, false);
                oTable.fnDraw();
            }
            $("table tbody tr td").css({"textAlign":"center"});
            $("thead th").css({"textAlign":"center"});
            var oTable = $('#sample_editable_1').dataTable({
                "bSort": false,
                // set the initial value
                "iDisplayLength": 15,
                "sDom": "<'row'<'col-md-6 col-sm-12'><'col-md-3 col-sm-3'>r>t<'row'<'col-md-5 col-sm-12' p ><'col-md-7 col-sm-12'l>>",
                "sPaginationType": "full_numbers",
                 "aLengthMenu": [[30,25, 20, 15,10,5], [30,25, 20, 15,10,5]],
                "oLanguage": {
                    "sLengthMenu": "_MENU_",
                    "oPaginate": {
                        "sPrevious": "上一页",
                        "sNext": "下一页",
                        "sFirst":"首页" 	,
                        "sLast":"尾页" 	
                    },
                    "oGoPage":{
                        "prefix":"跳转到第",
                        "suffix":"页",
                        "inputName":"",
                        "oClasses":"full_numbers_gopage"
                    }
                },
                "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0]
                    }
                ]
            });


            jQuery('#sample_editable_1_wrapper .dataTables_filter input').addClass("m-wrap medium"); // modify table search input
            jQuery('#sample_editable_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
//            jQuery('#sample_editable_1_wrapper .dataTables_length select').select2({
//                showSearchInput : false //hide search box with special css class
//            }); // initialzie select2 dropdown

            var nEditing = null;

            $('#sample_editable_1_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '',
                        '<a class="edit" href="">编辑</a>', '<a class="cancel" data-mode="new" href="">删除</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
            });
/*           $('#sample_editable_1 a.delete').live('click', function (e) {
                   var This=$(this)
                    $("#Delete_S_sure").unbind("click").click(function(e) {

                      var nRow = This.parents('tr')[0];
                       oTable.fnDeleteRow(nRow);


                    })


                //alert("Deleted! Do not forget to do some ajax to sync with backend :)");
            });*/
            $('#sample_editable_1 a.cancel').live('click', function (e) {
                e.preventDefault();
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#sample_editable_1 a.edit').live('click', function (e) {

                e.preventDefault();

            });
            function edit_addstorerow(oTable, nRow) {
                var store_NumVal=$("#store_Num")[0].value;
                var store_NameVal=$("#store_Name")[0].value
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML =store_NumVal;
                jqTds[1].innerHTML =store_NameVal;
                jqTds[2].innerHTML = '';
                jqTds[3].innerHTML = '';
                jqTds[4].innerHTML = '';
                jqTds[5].innerHTML = '';
                jqTds[6].innerHTML = '';
                jqTds[7].innerHTML = '';
                jqTds[8].innerHTML = ""
                jqTds[9].innerHTML = '<img src="media/image/bingo.png" class="bingo">';
                jqTds[10].innerHTML = '<a class=" btn blue btn-large Delete_btn Password_Reset" data-toggle="modal" href="#long">密码重置</a><a class=" btn blue delete Delete_btn" data-toggle="modal" href="#static">删除</a>';

                check();
            }
            function Normal(){
                var aiNew = oTable.fnAddData(['', '', '', '','','','','','','','','','',
                    '<a class="edit" href="">编辑</a>', '<a class="cancel" data-mode="" href="">删除</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                $("table tbody tr td").css({"textAlign": "center"});
                $("thead th").css({"textAlign": "center"});
                edit_addstorerow(oTable, nRow);
            }
            function Norma(){
                var aiNew = oTable.fnAddData(['', '', '', '','','',
                    '<a class="edit" href="">编辑</a>', '<a class="cancel" data-mode="" href="">删除</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);

                edrow(oTable, nRow);
            }
            function Normal_user(){
                var aiNew = oTable.fnAddData(['', '', '', '','','','','','','','','','',
                    '<a class="edit" href="">编辑</a>', '<a class="cancel" data-mode="" href="">删除</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);

                edit_userrow(oTable, nRow);
            }

                     $("#Sure").unbind("click").click(function(e){
                        if($("#store_Num")[0].value!="" && $("#store_Name")[0].value!="") {
                            Normal();

                        }

            })

            function editrow(oTable, nRow) {
                var store_NumVal=$("#store_Num")[0].value;
                var store_NameVal=$("#store_Name")[0].value
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML =store_NumVal;
                jqTds[1].innerHTML =store_NameVal;
                jqTds[2].innerHTML = '';
                jqTds[3].innerHTML = '';
                jqTds[4].innerHTML = '';
                jqTds[5].innerHTML = '';
                jqTds[6].innerHTML = '';
                jqTds[7].innerHTML = '';
                jqTds[8].innerHTML = '<span  class="state">未出账</span>';
                jqTds[9].innerHTML = '';
                jqTds[10].innerHTML = '';
                jqTds[11].innerHTML = '';
                jqTds[12].innerHTML = '<a href="javascript:;" class="">订单详情</a>';
                check();
            }
            function check(){
                for(var l=0;l<$(".state").length;l++) {
                    console.log(l)
                    if ($(".state")[l].innerHTML == "已出账") {
                        $(".state").eq(l).css({"color":"#ccc"})
                    } else {
                        $(".state").eq(l).css({"color":"#cc0000"})
                    }
                }
                //$(".state").click(function(){
                //    if($(this)[0].innerHTML=="已出账"){
                //        $(this)[0].innerHTML="未出账"
                //        $(this).css({"color":"#cc0000"})
                //    }else{
                //        $(this)[0].innerHTML="已出账"
                //        $(this).css({"color":"#ccc"})
                //    }
                //})
            }

            function edi_pricetrow(oTable, nRow) {
                var Add_price_nameVal=$("#Add_price_name")[0].value;
                var Add_price_oneVal=$("#Add_price_one")[0].value
                var Add_price_twoVal=$("#Add_price_two")[0].value;
                var Start_time=$("#Start_time")[0].value
                var over_time=$("#over_time")[0].value;
                var Add_price_num=$("#Add_price_num")[0].value
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML =Add_price_nameVal;
                jqTds[1].innerHTML ="满"+Add_price_nameVal+"减"+Add_price_twoVal;
                jqTds[2].innerHTML = '';
                jqTds[3].innerHTML = Start_time+"至"+over_time;
                jqTds[4].innerHTML =Add_price_num;
                jqTds[5].innerHTML = '';
                jqTds[6].innerHTML = '';
                jqTds[7].innerHTML = '<img src="media/image/error.png" class="bingo">';
                jqTds[8].innerHTML = '<a class=" btn blue delete Delete_btn" data-toggle="modal" href="#static">删除</a>';
            }
            function Norma_price(){
                var aiNew = oTable.fnAddData(['', '', '', '','','',"","",""

                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);

                edi_pricetrow(oTable, nRow);

            }
            function edrow(oTable, nRow) {
                var goods_twoVal= $("#goods_two")[0].value
                var goods_oneVal=$("#goods_one")[0].value
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML =goods_twoVal;
                jqTds[1].innerHTML =goods_oneVal;
                jqTds[2].innerHTML = '<img src="" class="goods_IMG">';
                jqTds[3].innerHTML = '<a class="edit  btn blue Delete_btn" data-toggle="modal" href="#full-width"  id="">编辑</a><a class=" btn blue delete Delete_btn" data-toggle="modal" href="#static">删除</a>';
                $("table tbody tr td").css({"textAlign":"center"});
            }



            function edit_jueserrow(oTable, nRow) {
                var user_jueVal=$("#user_jue_name")[0].value;
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML =user_jueVal;
                jqTds[1].innerHTML = '<a href="#ful-width" data-toggle="modal" id="edit_btn" class="edit  blue btn Delete_btn">编辑</a><a class=" btn blue delete Delete_btn" data-toggle="modal" href="#static">删除</a>';
            }
            function Norma_juese(){
                var aiNew = oTable.fnAddData(['', ''

                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);

                edit_jueserrow(oTable, nRow);

            }
            function edit_userrow(oTable, nRow) {
                var user_nameVal=$("#user_name")[0].value;
                var user_oneVal=$("#user_one")[0].value
                var User_twoVal=$("#User_two")[0].value
                var user_phoneVal=$("#user_phone")[0].value
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML =user_nameVal;
                jqTds[1].innerHTML =user_oneVal;
                jqTds[2].innerHTML = User_twoVal;
                jqTds[3].innerHTML = '';
                jqTds[4].innerHTML = user_phoneVal;
                jqTds[5].innerHTML = '<a href="#ful-width" data-toggle="modal" id="edit_btn" class="edit  blue btn Delete_btn">编辑</a><a class=" btn blue delete Delete_btn" data-toggle="modal" href="#static">删除</a>';
            }
            /*密码重置*/
            $("#sample_editable_1 a.Password_Reset").live('click', function (e) {

            })

            check();

            /*添加商品*/
            $("#sample_editable_1_goods").click(function(){
                $(".ADD_GOODS h3").html("添加商品")
                $("#goods_two")[0].value="";
                $("#goods_one")[0].value="";
                $("#goods_sure").unbind("click").click(function(e){
                    if($("#goods_two")[0].value!="") {
                        $("table tbody tr td").css({"textAlign":"center"});
                        $("thead th").css({"textAlign":"center"});
                            Norma();

                            $(".edit").addClass("bianji")
                        }
                })

            })

            /*上下架切换*/
            $("#sample_editable_1 .bingo").live('click', function (e){
                var URl=$(this).attr("src");
                if(URl=="media/image/error.png"){
                    URl="media/image/bingo.png";
                    $(this).attr({"src":URl});
                }else{
                    URl="media/image/error.png";
                    $(this).attr({"src":URl});
                }
            })

      /*   for(var i=0;i<$("tr td").length;i++){
            if($("tr td")[i].innerHTML=="没有数据可获取"){
            	alert()
            }
         }*/

            /*商品分类的编辑*/
            $("#sample_editable_1 a.edit").live('click',function(){
                $(".ADD_GOODS h3").html("商品编辑")
                This=$(this)
                $("#goods_sure").unbind("click").click(function(e){
                    if($("#goods_two")[0].value!="") {
                    //&& $("#goodsImg")[0].value!=""
                            var Edit_TR=This.parents("tr").children("td");
                            $(Edit_TR)[0].innerHTML=$("#goods_two")[0].value;
                            $(Edit_TR)[1].innerHTML=$("#goods_one")[0].value;
                            //var IMGSRC=$("#goodsImg").attr("src")
                            $(Edit_TR).eq(2).innerHTML="<img src=''>"
                    }
                })
            })
            /*上架商品与下架商品的切换*/
            $(".Added_jia").change(function(){
            if($(this).find("option:selected").text()=="上架") {
                for (var j = 0; j < $(".bingo").length; j++) {
                    if ($(".bingo").eq(j).attr("src") == "media/image/bingo.png") {
                        $(".bingo").eq(j).parents("tr").addClass("block")
                    }
                }
                $(".block").css({"display":""})
                $("#sample_editable_1 tbody").children(":not(.block)").css({"display":"none"})
            }else if($(this).find("option:selected").text()=="下架"){
                for (var j = 0; j < $(".bingo").length; j++) {
                    if ($(".bingo").eq(j).attr("src") == "media/image/error.png") {
                        $(".bingo").eq(j).parents("tr").addClass("None")
                    }
                }
                $(".None").css({"display":""})
                $("#sample_editable_1 tbody").children(":not(.None)").css({"display":"none"})
            }else{
                for (var j = 0; j < $(".bingo").length; j++) {
                        $(".bingo").eq(j).parents("tr").css({"display": ""})
                }
            }
            })

            /*商品首页轮播图上传图片*/

            /*账单查询*/


            /*订单管理*/
            for(var i=0;i<$(".shop_state").length;i++) {
                if ($(".shop_state")[i].innerHTML =="代付款"){
                    $(".shop_state").eq(i).css({"color":"#4b8df8"})
                }if($(".shop_state")[i].innerHTML =="代发货"){
                    $(".shop_state").eq(i).css({"color":"#cc0000"})
                }if($(".shop_state")[i].innerHTML =="代收货"){
                    $(".shop_state").eq(i).css({"color":"#10a062"})
                }if($(".shop_state")[i].innerHTML =="交易完成"){
                    $(".shop_state").eq(i).css({"color":"#ccc"})
                }
             }
            /*商品管理添加商品*/
            $("#sample_editable_1_goodsrow").click(function(){
                $("#Add_goods").css({"display":"block"})
            })
            // $("#Add_goods_Sure").click(function(){
            //      window.location.href="self_goods.jsp"
            // })
            /*商品管理是否允许编辑商品*/
         for(var n=0;n<$(".Cen").length;n++) {
             if ($(".Cen")[n].innerHTML == "代理") {
                 $(".Cen").eq(n).siblings().find(".edit").css({"color": "#ccc"})
             }
         };





            /*发货*/
            $(".deliver_goods").click(function(){
                    $(".deliver").css({"display":"block"});

            })
            $("#company_Sure").click(function(){
                $(".deliver").css({"display":"none"});
            })
            $("#company_can_cel").click(function(){
                $(".deliver").css({"display":"none"});
            })



            $("#self_company_sure").click(function(){
                $(".deliver").css({"display":"none"});
            })
            $("#self_company_cancel").click(function(){
                $(".deliver").css({"display":"none"});
            })

            /*修改手机号*/
          $(".recompose_phone").each(function(i){
              $(this).live('click',function(){
                  that=$(this)
                  $("#new_phone_sure").live('click',function() {

                      var Phone = that.parents("tr").children("td");
                      $(Phone).eq(1).html($("#phone_value")[0].value)
                  })
              })
          })

            ///*手机号 姓名搜索*/
            //$("#find_User").click(function(){
            //    var find_User_tr=$("#sample_editable_1 tbody tr");
            //    for(var m=0;m<find_User_tr.length;m++){
            //        if($(find_User_tr).eq(m).children("td")[1].innerHTML==$(".find_phone")[0].value){
            //            $(find_User_tr).eq(m).css({"display":""}).siblings().css({"display":"none"})
            //        }
            //        if($(find_User_tr).eq(m).children("td")[2].innerHTML==$(".find_name")[0].value){
            //            $(find_User_tr).eq(m).css({"display":""}).siblings().css({"display":"none"})
            //        }
            //
            //    }
            //})
            ///*店铺搜索*/
            //$("#find_store").click(function(){
            //    var find_User_tr=$("#sample_editable_1 tbody tr");
            //    for(var m=0;m<find_User_tr.length;m++){
            //        if($(find_User_tr).eq(m).children("td")[0].innerHTML==$(".find_store_num")[0].value){
            //            $(find_User_tr).eq(m).css({"display":""}).siblings().css({"display":"none"})
            //        }
            //        if($(find_User_tr).eq(m).children("td")[1].innerHTML==$(".find_store_name")[0].value){
            //            $(find_User_tr).eq(m).css({"display":""}).siblings().css({"display":"none"})
            //        }
            //
            //    }
            //})
            ///*商品管理搜索*/
            //$("#find_store_manage").click(function(){
            //    var find_store_manage=$("#sample_edi_1 tbody tr");
            //        for (var k = 0; k < $(find_store_manage).length; k++) {
            //            if($(find_store_manage).eq(k).children("td")[5].innerHTML==$(".find_store_address")[0].value) {
            //                $(find_store_manage).eq(k).addClass("block")
            //            }
            //        }
            //        $(".block").css({"display":""})
            //        $("#sample_editable_1 tbody").children(":not(.block)").css({"display":"none"})
            //    for (var n = 0; n < $(find_store_manage).length; n++) {
            //        if($(find_store_manage).eq(n).children("td")[1].innerHTML==$(".find_goods_name")[0].value) {
            //            $(find_store_manage).eq(n).addClass("block")
            //        }
            //    }
            //    $(".block").css({"display":""})
            //    $("# tbody").children(":not(.block)").css({"display":"none"})
            //
            //})
            //
            ///*店铺查询*/
            //$("#find_store_con").click(function(){
            //    var find_store_con=$("#sample_editable_1 tbody tr");
            //    for(var m=0;m<find_store_con.length;m++){
            //        if($(find_store_con).eq(m).children("td")[6].innerHTML==$(".find_store_name")[0].value){
            //            $(find_store_con).eq(m).css({"display":""}).siblings().css({"display":"none"})
            //        }
            //    }
            //
            //    for (var m = 0; m < $(find_store_con).length; m++) {
            //        if($(find_store_con).eq(m).children("td")[1].innerHTML==$(".find_store_nu")[0].value) {
            //            $(find_store_con).eq(m).addClass("block")
            //        }
            //    }
            //    $(".block").css({"display":""})
            //    $("#sample_editable_1 tbody").children(":not(.block)").css({"display":"none"})
            //
            //
            //    for (var m = 0; m < $(find_store_con).length; m++) {
            //        var fimd_time=$(".find_store_s_time")[0].value+("-")+$(".find_store_e_time")[0].value;
            //        if($(find_store_con).eq(m).children("td")[0].innerHTML==fimd_time) {
            //            $(find_store_con).eq(m).addClass("block")
            //        }
            //    }
            //    $(".block").css({"display":""})
            //    $("#sample_editable_1 tbody").children(":not(.block)").css({"display":"none"})
            //})
            //
            //

            /*修改提现微信号*/

            /*添加优惠券*/
            // $("#sample_editable_1_You").live('click',function(){
            //     $("#Add_price_cancel").unbind("click").click(function(e){
            //
            //         Norma_price();
            //         $("table tbody tr td").css({"textAlign": "center"});
            //
            //     })
            //
            // })
           //用户添加和编辑
            $("#edit_btn").live('click',function(){
                $("#ful-width .modal-header h3")[0].innerHTML="用户编辑"
                that=$(this)
//                $("#User_Usure").unbind("click").click(function(e) {
//                	alert("table.js");
//                    var user_nameVal = $("#user_name").val();
//                    var user_oneVal=$("#user_one").val();
//                    var User_two=$("#User_two").val();
//                    var user_phone=$("#user_phone").val();
//                    var Edit_tr=that.parents("tr").children("td");
//                    if ($("#user_name")[0].value != "" && $("#user_phone")[0].value != "") {
//                        $(Edit_tr).eq(0).html(user_nameVal);
//                        $(Edit_tr).eq(1).html(user_oneVal)
//                        $(Edit_tr).eq(2).html(User_two)
//                        $(Edit_tr).eq(4).html(user_phone)
//                    }
//                })
//                $("#user_name")[0].value= "";
//                $("#user_phone")[0].value= ""
            })
            //角色添加
            $("#add_M_juese").click(function(){
                $("#ful-width .modal-header h3")[0].innerHTML="添加角色";
                $("#User_Msure").live("click",function(){
                    Norma_juese();
                    $("table tbody tr td").css({"textAlign": "center"});
                    $("#detail-tab td").css("textAlign","left");
                    
                })

            })
            
            
            $("#Edit").live("click",function(){
                $("#ful-width .modal-header h3")[0].innerHTML="角色编辑";
            })
            $("#go_shop").change(function(){
                if($(this).find("option:selected").text()=="到店自提"){
                     $("#go_store").css({"display":"block"});
                     $("#kuaidi").css({"display":"none"});
                }else{
                    $("#go_store").css({"display":"none"});
                    $("#kuaidi").css({"display":"block"});
                }
             })
             
           
             $(".dataTables_empty").html("数据疯狂加载中...");
            
            $("#Exit_denglu").click(function(){
            
                if($("#userlogout")[0] == null)
					$(document.body).append("<div id=\"userlogout\" class=\"modal fade\"  role=\"dialog\"></div>");
              	 var $this = $(this);
              	 var basePath = $this.attr("basepath");
              	 $.ajax({
              		 url:basePath+"/admin/exitLogin",
              		 type:"get",
              		 success:function(resp){
              			 $("#userlogout").html(resp);
              		 }
              	 });
          	 
          	 
           });
             
			$("#change_pass").click(function(){
				if($("#userchangepwd")[0] == null)
					$(document.body).append("<div id=\"userchangepwd\" class=\"modal fade\"  role=\"base\"></div>");
				var $this = $(this);
				var basePath = $this.attr("basepath");
				$.ajax({
					url:basePath+"/admin/changepwd",
					type:"get",
					success:function(resp){
					$("#userchangepwd").html(resp);
					}
				});
			});
        
        }

    };
  

    /*table_edittable*/

}();