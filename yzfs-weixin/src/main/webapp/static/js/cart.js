    //计算总价
    function price(){
        var price=0;
        $(".price-num").each(function(){
            price+=parseFloat($(this).html())*parseInt($(this).parents(".list-priceall").find(".list-num").html());
        });
        $(".total-price").html(price);
    }

    //地址填写
    $(".payPoint").click(function(){
       $(".address").fadeIn();
    })
        $(".cancelbtn").click(function(){
            $(".address").fadeOut();
          });
    
      $(function(){
        // 判断购物车是否为空
        function nonegoods(){
          if($(".list-li").length==0){
          $(".no-goods").show();
          }
        }
        
      //初始计算价格
      price();

      // 删除按点击事件
      $(".delete").click(function(){
          var that=this;
          $(".deletebox").fadeIn(function(){
            $(".confirm").click(function(){
              $(that).parent().parent().parent().parent().remove();
              $(".deletebox").fadeOut();
              price();
              nonegoods();
            })
          })
      })
    //减按钮点击事件
    $(".sub").on('touchstart',function(){
       var numCon=$(this).siblings(".list-num");
       var count=parseInt(numCon.html());
       if (count>1) {
          numCon.html(count-1);
          price();
       };
    });

    //加按钮点击事件
    $(".add").on('touchstart',function(){
       var left=parseInt($(this).siblings("input[class=j-input-left]").val());
       var numCon=$(this).siblings(".list-num");
       var count=parseInt(numCon.html());
       if (count < left) {
          numCon.html(count+1);
          price();
       };
    });

    });