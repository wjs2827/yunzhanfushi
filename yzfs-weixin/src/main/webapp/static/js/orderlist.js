//全部订单
        function orderlistboth() {
            // alert(current_page);
            myScroll.refresh(); 
            setTimeout(function() {
                var el, li, i;
                el = document.getElementById('orderlistboth');
                for (i = 0; i < 4; i++) {
                    li = document.createElement('li');
                    li.innerHTML = '<h1>2016/8/15 12:50:00 <span>未发货</span></h1><div class="ordergoods"><ul><li class="clearfix"><div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div><div class="right"><h2 class="moreOverflowTwo">UGG 雪地靴皮毛一体御寒神器</h2><p>×1<span>¥2000</span></p></div></li><li class="clearfix"><div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div><div class="right"><h2 class="moreOverflowTwo">UGG 雪地靴皮毛一体御寒神器</h2> <p>×1<span>¥2000</span></p></div></li> </ul><div class="unpaidmes"><p>共<span  class="totalnum">2</span>件  共计：<span class="totalmoney">¥450.00</span>  （运费￥12.00）</p><p><a href="#" class="delete-order">删除订单</a><a href="#">申请退货</a></p></div></div>';
                    el.appendChild(li, el.childNodes[0]);
                }
                 cancel();
                 deleteorder();
                myScroll.refresh(); // 数据加载完成后，调用界面更新方法 Remember to refresh when contents are loaded (ie: on ajax completion)
            }, 1000); // <-- Simulate network congestion, remove setTimeout from production!
            if (current_page > 1) {
                $(".goTop").show();
            }
        }

         //代付款
        function orderlistPayment() {
          myScroll.refresh(); 
            setTimeout(function() {
                var el, li, i;
                el = document.getElementById('orderlistPayment');

                for (i = 0; i < 4; i++) {
                    li = document.createElement('li');
                    li.innerHTML = '<h1>2016/8/15 12:50:00 <span>未发货</span></h1> <div class="ordergoods"><ul><li class="clearfix"> <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div><div class="right"><h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2><p>红色  ML<span>x1</span></p><h3><small>￥</small>800</h3></div></li></ul><div class="unpaidmes"><p>共<span  class="totalnum">2</span>件  共计：<span class="totalmoney">¥450.00</span>  （运费￥12.00）</p><p><a href="#" class="cancel-order">取消订单</a><a href="#" class="red">立即支付</a></p></div></div>';
                    el.appendChild(li, el.childNodes[0]);
                }
                cancel();
                deleteorder();
                myScroll.refresh(); // 数据加载完成后，调用界面更新方法 Remember to refresh when contents are loaded (ie: on ajax completion)
            }, 1000); // <-- Simulate network congestion, remove setTimeout from production!
            if (current_page > 1) {
                $(".goTop").show();
            }
        }

       //代发货
        function orderlistdelivery() {
          myScroll.refresh(); 
            setTimeout(function() {
                var el, li, i;
                el = document.getElementById('orderlistdelivery');

                for (i = 0; i < 4; i++) {
                    li = document.createElement('li');
                    li.innerHTML = '<h1>2016/8/15 12:50:00 <span>待发货</span></h1> <div class="ordergoods"><ul><li class="clearfix"> <div class="left"><img src="${contextPath}/static/images/a5.png" width="100%"></div><div class="right"><h2 class="moreOverflowTwo">商品名称商品名称商品名称</h2><p>红色  ML<span>x1</span></p><h3><small>￥</small>800</h3></div></li></ul><div class="unpaidmes"><p>共<span  class="totalnum">2</span>件  共计：<span class="totalmoney">¥450.00</span>  （运费￥12.00）</p><p><a href="#" class="cancel-order">取消订单</a><a href="#" class="red">立即支付</a></p></div></div>';
                    el.appendChild(li, el.childNodes[0]);
                }
                cancel();
                deleteorder();
                myScroll.refresh(); // 数据加载完成后，调用界面更新方法 Remember to refresh when contents are loaded (ie: on ajax completion)
            }, 1000); // <-- Simulate network congestion, remove setTimeout from production!
            if (current_page > 1) {
                $(".goTop").show();
            }
        }


        $('.goTop').on('click',function(){
            myScroll.scrollTo(0,0,500);
            $(this).hide();
        });
      function cancel(){
        //取消订单
        $(".cancel-order").click(function(){
         // $(this).parent().parent().remove();
          $(".deletebox").fadeOut();
           var that=this;
           $(".cancel-order-con").fadeIn(function(){
              $(".confirm").click(function(){
              //  $(that).parent().parent().remove();
               })
          });
        })
      }
      cancel();
      //删除订单
     function deleteorder(){
      $(".delete-order").click(function(){
       
         $(".delete-order-con").find("p").html("确认要删除该订单吗？");
         var that=this;
        $(".delete-order-con").fadeIn(function(){
            $(".confirm").click(function(){
              $(that).parent().parent().parent().parent().remove();
              $(".deletebox").fadeOut();
               myScroll.refresh();
            })
        });
      })
      $(".cancel").click(function(){
        $(this).parent().parent().parent().fadeOut();
     })
    }
   deleteorder();