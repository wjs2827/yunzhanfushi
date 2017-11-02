/**
 * Created by Administrator on 14-12-01.
 * 模拟淘宝SKU添加组合
 * 页面注意事项：
 *      1、 .Father_Title      这个类作用是取到所有标题的值，赋给表格，如有改变JS也应相应改动
 *      2、 .Father_Item       这个类作用是取类型组数，有多少类型就添加相应的类名：如: Father_Item1、Father_Item2、Father_Item3 ...
 */



//$(function() {
	
	//领口SKU选择（当点击class=choose_config下的label标签时触发事件）
    $(document).on('change', '.choose_config label', function() {
    	//获取当前点击label标签的父节点
        var parent=$(this).parents('.Father_Item');
        var _this=$('.checkbox',this);
        // 是否全选
        $('.checkbox',parent).each(function() {
            var bCheck2=true;
            if (_this.hasClass('check_all')){
                if (_this.get(0).checked) {
                    bCheck2=true;
                    $('.check_item',parent).prop('checked', bCheck2);
                }else{
                    bCheck2=false;
                    $('.check_item',parent).prop('checked', bCheck2);
                }
                return false;
            }else{
                if ((!this.checked)&&(!$(this).hasClass('check_all'))) {
                    bCheck2 = false;
                    $('.check_all',parent).prop('checked', bCheck2);
                    return false;
                }
            }
            $('.check_all',parent).prop('checked', bCheck2);
        });
        step.Creat_Table();
    });
    var step = {
        // 信息组合
        Creat_Table: function() {
            step.hebingFunction();
            var SKUObj = $('.Father_Title');
            var arrayTile = new Array(); // 表格标题数组
            var arrayInfor = new Array(); // 盛放每组选中的CheckBox值的对象
            var arrayColumn = new Array(); // 指定列，用来合并哪些列
            var bCheck = true; // 是否全选，只有全选，表格才会生成
            var columnIndex = 0;
            $.each(SKUObj, function(i, item) {
                arrayColumn.push(columnIndex++);
                arrayTile.push(SKUObj.eq(i).text());
                var itemName = '.Father_Item' + i;
                var bCheck2 = true; // 是否全选

                // 获取选中的checkbox的值
                var order = new Array();
                $(itemName + ' .check_item:checked').each(function() {
                	var myid= $(this).data('myid');
                	console.log("myid:"+myid);
                    order.push($(this).val());
                });

                arrayInfor.push(order);
                if (order.join() == '') {
                    bCheck = false;
                }
            })
            // 开始生成表格
            if (bCheck) {
                $('#createTable').html('');
                var table = $('<table id="process" class="columnList"></table>');
                table.appendTo($('#createTable'));
                var thead = $('<thead></thead>');
                thead.appendTo(table);
                var trHead = $('<tr></tr>');
                trHead.appendTo(thead);
                // 创建表头
                var str = '';
                var sign=0;
                $.each(arrayTile, function(index, item) {
                    str += '<th width="100">' + item + '</th>';
                    str += '<input type="hidden" id="titleVal'+index+'" name="titleVal'+index+'" value="'+item+'"/>';
                    sign=Number(index+1);
                })
                str +='<th  width="200">加价</th>';
                str +='<input type="hidden" id="titleVal'+Number(sign)+'"  name="titleVal'+Number(sign)+'" value="加价"/>';	
                str +='<th width="100">衣服图片(120*108)</th>';
                str +='<input type="hidden" id="titleVal'+Number(sign+1)+'"  name="titleVal'+Number(sign+1)+'" value="衣服图片"/>';
                $("#neckTitleLength").val(sign);
                trHead.append(str);
                var tbody = $('<tbody></tbody>');
                tbody.appendTo(table);
                var zuheDate = step.doExchange(arrayInfor);
                if (zuheDate.length > 0) {
                    //创建行
                    $.each(zuheDate, function(index, item) {
                        var td_array = item.split(',');
                        var tr = $('<tr></tr>');
                        tr.appendTo(tbody);
                        var str = '';
                        $.each(td_array, function(i, values) {
                        	console.log(values)
                        	str += '<td>' + $("#"+values).val() + '</td>';
                            str += '<input type="hidden" id="neck'+i+'key'+index+'" name="neck'+i+'key'+index+'" value="'+values+'"/>';
                            str += '<input type="hidden" id="neck'+i+'val'+index+'" name="neck'+i+'val'+index+'" value="'+$("#"+values).val()+'"/>';
                            str += '<input type="hidden" id="neckPic'+i+'key'+index+'"  name="neckPic'+i+'key'+index+'" value="'+$("#"+values+"key").val()+'"/>';
                        });
                        str += '<td ><input  id="neck_price'+index+'" name="neck_price'+index+'" class="inpbox inpbox-mini" type="text" onkeyup="onBlurNeckSalePrice('+index+');" ><br/><span class="errorTitle"  id="errorTitle'+index+'"></span></td>';
                        str += '<td >';  
	                        str += '<div class="fileupload fileupload-new Add_Img"  style="float:center;margin-top:-.9rem" data-provides="fileupload">';
		                        str += '<div class="fileupload-new thumbnail" style="width: 64px; height: 64px;margin-top:2rem;margin-left:2rem;">';
			                        str += '<span class="btn btn-file"> ';
				                        str += '<span class="fileupload-new"> ';
				                        str += '<img id="neckimg-key'+index+'" src="/yzfs-admin/static/image/add.png"  style="width: 64px; height: 50px;" class="fileupload-new" />';
				                        str += '<input type="hidden" id="neckimg-keys'+index+'" name="neckimg-keys'+index+'"/>';
				                        str += '</span>';
			                        str += '</span>';
		                        str += '</div>';
	                        str += '</div>';
                        str += '</td>';
                        tr.append(str);
                        initQiniuNeckLineImg(index);
                        $("#neckLength").val(Number(index+1));
                    });
                    
                }

                //结束创建Table表
                arrayColumn.pop(); //删除数组中最后一项
                //合并单元格
                $(table).mergeCell({
                    // 目前只有cols这么一个配置项, 用数组表示列的索引,从0开始
                    cols: arrayColumn
                });
            } else {
                //未全选中,清除表格
                document.getElementById('createTable').innerHTML = "";
            }
        },
        hebingFunction: function() {
            $.fn.mergeCell = function(options) {
                return this.each(function() {
                    var cols = options.cols;
                    for (var i = cols.length - 1; cols[i] != undefined; i--) {
                        mergeCell($(this), cols[i]);
                    }
                    dispose($(this));
                })
            };

            function mergeCell($table, colIndex) {
                $table.data('col-content', ''); // 存放单元格内容
                $table.data('col-rowspan', 1); // 存放计算的rowspan值 默认为1
                $table.data('col-td', $()); // 存放发现的第一个与前一行比较结果不同td(jQuery封装过的), 默认一个"空"的jquery对象
                $table.data('trNum', $('tbody tr', $table).length); // 要处理表格的总行数, 用于最后一行做特殊处理时进行判断之用
                // 进行"扫面"处理 关键是定位col-td, 和其对应的rowspan
                $('tbody tr', $table).each(function(index) {
                    // td:eq中的colIndex即列索引
                    var $td = $('td:eq(' + colIndex + ')', this);
                    // 获取单元格的当前内容
                    var currentContent = $td.html();
                    // 第一次时走次分支
                    if ($table.data('col-content') == '') {
                        $table.data('col-content', currentContent);
                        $table.data('col-td', $td);
                    } else {
                        // 上一行与当前行内容相同
                        if ($table.data('col-content') == currentContent) {
                            // 上一行与当前行内容相同则col-rowspan累加, 保存新值
                            var rowspan = $table.data('col-rowspan') + 1;
                            $table.data('col-rowspan', rowspan);
                            // 值得注意的是 如果用了$td.remove()就会对其他列的处理造成影响
                            $td.hide();
                            // 最后一行的情况比较特殊一点
                            // 比如最后2行 td中的内容是一样的, 那么到最后一行就应该把此时的col-td里保存的td设置rowspan
                            // 最后一行不会向下判断是否有不同的内容
                            //if (++index == $table.data('trNum'))
                                $table.data('col-td').attr('rowspan', $table.data('col-rowspan'));
                        }
                        // 上一行与当前行内容不同
                        else {
                            // col-rowspan默认为1, 如果统计出的col-rowspan没有变化, 不处理
                            if ($table.data('col-rowspan') != 1) {
                                $table.data('col-td').attr('rowspan', $table.data('col-rowspan'));
                            }
                            // 保存第一次出现不同内容的td, 和其内容, 重置col-rowspan
                            $table.data('col-td', $td);
                            $table.data('col-content', $td.html());
                            $table.data('col-rowspan', 1);
                        }
                    }
                })
            }
            // 同样是个private函数 清理内存之用
            function dispose($table) {
                $table.removeData();
            }
        },
        doExchange: function(doubleArrays) {
            // 二维数组，最先两个数组组合成一个数组，与后边的数组组成新的数组，依次类推，知道二维数组变成以为数组，所有数据两两组合
            var len = doubleArrays.length;
            if (len >= 2) {
                var arr1 = doubleArrays[0];
                var arr2 = doubleArrays[1];
                var len1 = arr1.length;
                var len2 = arr2.length;
                var newLen = len1 * len2;
                var temp = new Array(newLen);
                var index = 0;
                for (var i = 0; i < len1; i++) {
                    for (var j = 0; j < len2; j++) {
                        temp[index++] = arr1[i] + ',' + arr2[j];
                    }
                }
                var newArray = new Array(len - 1);
                newArray[0] = temp;
                if (len > 2) {
                    var _count = 1;
                    for (var i = 2; i < len; i++) {
                        newArray[_count++] = doubleArrays[i];
                    }
                }
                return step.doExchange(newArray);
            } else {
                return doubleArrays[0];
            }
        }
    }
    
    
    
	//商品SKU选择（当点击class=choose_config下的label标签时触发事件）
    $(document).on('change', '.m-b input', function() {
        sku.Creat_Table();
    });
    
    var sku = {
            // 信息组合
            Creat_Table: function() {
                sku.hebingFunction();
                var SKUObj = $('.SkuFather_Title');
                var arrayTile = new Array(); // 表格标题数组
                var arrayInfor = new Array(); // 盛放每组选中的CheckBox值的对象
                var arrayColumn = new Array(); // 指定列，用来合并哪些列
                var bCheck = false; // 是否有选中属性
                var columnIndex = 0;
                $.each(SKUObj, function(i, item) {
                    arrayColumn.push(columnIndex++);
                    var skuItemIndex=0;
                    var itemName = '.input-s-sm' + i;
                    var bCheck2 = true; // 是否全选
                    // 获取选中的checkbox的值
                    var order = new Array();
                    $(itemName + ' .sku_check_item:checked').each(function() {
                      console.log("属性值："+$(this).val());
                      order.push($(this).val());
                      skuItemIndex++;
                    });
                    //只要父类下的子类选中一个 就将父类名称付给list集合
                    if(skuItemIndex>0){
                        console.log("标题值："+SKUObj.eq(i).text());
                        arrayTile.push(SKUObj.eq(i).text());
                        arrayInfor.push(order);
                        //如果没有选中，则不生成表格
                        bCheck = true;
                    }
                })
                // 开始生成表格
                console.log("是否生成表格："+bCheck);
                if (bCheck) {
                    $('#createSkuTable').html('');
                    var table = $('<table id="process" class="columnList"></table>');
                    table.appendTo($('#createSkuTable'));
                    var thead = $('<thead></thead>');
                    thead.appendTo(table);
                    var trHead = $('<tr></tr>');
                    trHead.appendTo(thead);
                    // 创建表头
                    var str = '';
                    var sign=0;
                    $.each(arrayTile, function(index, item) {
                        str += '<th width="100">' + item + '</th>';
                        str += '<input type="hidden" id="skuTitleVal'+index+'" name="skuTitleVal'+index+'" value="'+$("#sku"+item).data("id")+'"/>';
                        sign=Number(index+1);
                    })
                    str +='<th width="100">规格图片(120*108)</th>';
                    str +='<input type="hidden" id="skuTitleVal'+Number(sign)+'"  name="skuTitleVal'+Number(sign)+'" value="规格图片"/>';
                    str +='<th  width="200">销售价</th>';
                    str +='<input type="hidden" id="skuTitleVal'+Number(sign+1)+'"  name="skuTitleVal'+Number(sign+1)+'" value="销售价"/>';	
                    str +='<th  width="200">市场价</th>';
                    str +='<input type="hidden" id="skuTitleVal'+Number(sign+2)+'"  name="skuTitleVal'+Number(sign+2)+'" value="市场价"/>';
                    str +='<th  width="200">库存</th>';
                    str +='<input type="hidden" id="skuTitleVal'+Number(sign+3)+'"  name="skuTitleVal'+Number(sign+3)+'" value="库存"/>';
                    $("#skuTitleLength").val(sign);
                    trHead.append(str);
                    var tbody = $('<tbody></tbody>');
                    tbody.appendTo(table);
                    console.log("表头创建完成");
                    console.log("选中的子类他爸叫啥："+arrayTile);
                    console.log("选中的子类叫啥："+arrayInfor);
                    var zuheDate = sku.doExchange(arrayInfor);
                    console.log("行数数据："+zuheDate);
                    if (zuheDate.length > 0) {
                        //创建行
                        $.each(zuheDate, function(index, item) {
                            var td_array = item.split(',');
                            console.log("td_array:"+td_array);
                            var tr = $('<tr></tr>');
                            tr.appendTo(tbody);
                            var str = '';
                            $.each(td_array, function(i, values) {
                            	console.log(values)
                            	str += '<td>' + $("#"+values).val() + '</td>';
                                str += '<input type="hidden" id="sku'+i+'key'+index+'" name="sku'+i+'key'+index+'" value="'+values+'"/>';
                                str += '<input type="hidden" id="sku'+i+'val'+index+'" name="sku'+i+'val'+index+'" value="'+$("#"+values).val()+'"/>';
                            });
                            str += '<td >';  
	                        str += '<div class="fileupload fileupload-new Add_Img"  style="float:center;margin-top:-.9rem" data-provides="fileupload">';
		                        str += '<div class="fileupload-new thumbnail" style="width: 64px; height: 64px;margin-top:2rem;margin-left:2rem;">';
			                        str += '<span class="btn btn-file"> ';
				                        str += '<span class="fileupload-new"> ';
				                        str += '<img id="skuImg-key'+index+'" src="/yzfs-admin/static/image/add.png"  style="width: 64px; height: 50px;" class="fileupload-new" />';
				                        str += '<input type="hidden" id="skuImg-keys'+index+'" name="skuImg-keys'+index+'"/>';
				                        str += '</span>';
			                        str += '</span>';
		                        str += '</div>';
	                        str += '</div>';
                            str += '</td>';
                            str += '<td ><input  id="sku_price'+index+'" name="sku_price'+index+'" class="inpbox inpbox-mini" type="text" onkeyup="skuPriceOnkeyup('+index+');" ><br/><span class="skuErrorTitle"  id="skuErrorTitle'+index+'"></span></td>';
                            str += '<td ><input  id="sku_market'+index+'" name="sku_market'+index+'" class="inpbox inpbox-mini" type="text" onkeyup="skuMarketOnkeyup('+index+');" ><br/><span class="skuMarketTitle"  id="skuMarketTitle'+index+'"></span></td>';
                            str += '<td ><input  id="sku_stock'+index+'" name="sku_stock'+index+'" class="inpbox inpbox-mini" type="text" onkeyup="skuStockOnkeyup('+index+');" ><br/><span class="skuStockTitle"  id="skuStockTitle'+index+'"></span></td>';
                            console.log("最后内容："+str);
                            tr.append(str);
                            initQiniuSkuImg(index);
                            $("#skuLength").val(Number(index+1));
                        });
                        
                    }

                    //结束创建Table表
                    arrayColumn.pop(); //删除数组中最后一项
                    //合并单元格
                    $(table).mergeCell({
                        // 目前只有cols这么一个配置项, 用数组表示列的索引,从0开始
                        cols: arrayColumn
                    });
                }else {
                    //未全选中,清除表格
                    document.getElementById('createSkuTable').innerHTML = "";
                }
            },
            hebingFunction: function() {
                $.fn.mergeCell = function(options) {
                    return this.each(function() {
                        var cols = options.cols;
                        for (var i = cols.length - 1; cols[i] != undefined; i--) {
                            mergeCell($(this), cols[i]);
                        }
                        dispose($(this));
                    })
                };

                function mergeCell($table, colIndex) {
                    $table.data('col-content', ''); // 存放单元格内容
                    $table.data('col-rowspan', 1); // 存放计算的rowspan值 默认为1
                    $table.data('col-td', $()); // 存放发现的第一个与前一行比较结果不同td(jQuery封装过的), 默认一个"空"的jquery对象
                    $table.data('trNum', $('tbody tr', $table).length); // 要处理表格的总行数, 用于最后一行做特殊处理时进行判断之用
                    // 进行"扫面"处理 关键是定位col-td, 和其对应的rowspan
                    $('tbody tr', $table).each(function(index) {
                        // td:eq中的colIndex即列索引
                        var $td = $('td:eq(' + colIndex + ')', this);
                        // 获取单元格的当前内容
                        var currentContent = $td.html();
                        // 第一次时走次分支
                        if ($table.data('col-content') == '') {
                            $table.data('col-content', currentContent);
                            $table.data('col-td', $td);
                        } else {
                            // 上一行与当前行内容相同
                            if ($table.data('col-content') == currentContent) {
                                // 上一行与当前行内容相同则col-rowspan累加, 保存新值
                                var rowspan = $table.data('col-rowspan') + 1;
                                $table.data('col-rowspan', rowspan);
                                // 值得注意的是 如果用了$td.remove()就会对其他列的处理造成影响
                                $td.hide();
                                // 最后一行的情况比较特殊一点
                                // 比如最后2行 td中的内容是一样的, 那么到最后一行就应该把此时的col-td里保存的td设置rowspan
                                // 最后一行不会向下判断是否有不同的内容
                                if (++index == $table.data('trNum'))
                                    $table.data('col-td').attr('rowspan', $table.data('col-rowspan'));
                            }
                            // 上一行与当前行内容不同
                            else {
                                // col-rowspan默认为1, 如果统计出的col-rowspan没有变化, 不处理
                                if ($table.data('col-rowspan') != 1) {
                                    $table.data('col-td').attr('rowspan', $table.data('col-rowspan'));
                                }
                                // 保存第一次出现不同内容的td, 和其内容, 重置col-rowspan
                                $table.data('col-td', $td);
                                $table.data('col-content', $td.html());
                                $table.data('col-rowspan', 1);
                            }
                        }
                    })
                }
                // 同样是个private函数 清理内存之用
                function dispose($table) {
                    $table.removeData();
                }
            },
            doExchange: function(doubleArrays) {
                // 二维数组，最先两个数组组合成一个数组，与后边的数组组成新的数组，依次类推，知道二维数组变成以为数组，所有数据两两组合
                var len = doubleArrays.length;
                console.log("数组长度："+len);
                if (len >= 2) {
                    var arr1 = doubleArrays[0];
                    console.log("数组一："+arr1);
                    var arr2 = doubleArrays[1];
                    console.log("数组二："+arr2);
                    var len1 = arr1.length;
                    console.log("数组一的长度："+len1);
                    var len2 = arr2.length;
                    console.log("数组二的长度："+len2);
                    var newLen = len1 * len2;
                    console.log("数组一的长度*数组二的长度产生一个新的数据长度："+newLen);
                    var temp = new Array(newLen);
                    var index = 0;
                    for (var i = 0; i < len1; i++) {
                        for (var j = 0; j < len2; j++) {
                            temp[index++] = arr1[i] + ',' + arr2[j];
                        }
                    }
                    var newArray = new Array(len - 1);
                    newArray[0] = temp;
                    if (len > 2) {
                        var _count = 1;
                        for (var i = 2; i < len; i++) {
                            newArray[_count++] = doubleArrays[i];
                        }
                    }
                    console.log("newArray:"+newArray);
                    return sku.doExchange(newArray);
                } else {
                    return doubleArrays[0];
                }
            }
            
        }
//})

