/**
 * JS分页控件<br>
 * css参见wm-paging_v1.0.css文件，按照其规范进行修改<br>
 * @param _options
 * 
 * @returns
 */
function WmPaging(_options){
	this.options = $.extend({
		el:null,
		totalCount:0,
		pageSize:10,
		pageCount:1,
		language:{
			first:"首页",pre:"前一页",next:"后一页",last:"尾页",go:"Go"
		},
		className:"wmeimob-common-paging",
		dataLoad:null
	}, _options);
	
	if(this.options.el == null || typeof(this.options.el) == "unfined"){
		throw new Error("Must be give a dom element to class Wmpaging.");
	};
	
	 
	
	
	
	console.debug("page count:"+this.options.pageCount+", typeof el:"+typeof(this.options.el));
	this.container = typeof(this.options.el) == "string" ? (this.options.el.indexOf(".") == 0 ? $(this.options.el) : $("#"+this.options.el)) : $(this.options.el);
	this.container.toggleClass(this.options.className);
	this.buttonText = this.options.language;
	var that = this;
	this.generatePageNumberButtons = function(curIndex, start, end){
		var pageContainer = that.container.find("ul");
		pageContainer.children().remove();
		for(var pageIndex = start; pageIndex <= end; pageIndex++){
			var li = $(document.createElement("li"));
			li.html(pageIndex);
			if(curIndex == pageIndex){
				li.addClass("select");
				
			}
			pageContainer.append(li);
			li.on("click",function(){
				that.go(this.innerHTML);
				that.pagetotal();
				that.callExternalMethod();
			});
		}
		
	};
	
	this.callExternalMethod = function(){
		console.debug("call external method");
		
		if(typeof(that.options.dataLoad) == "function"){
			var curPageNumber = that.container.find("ul > li.select").html();
			that.options.dataLoad(parseInt(curPageNumber), that.options.pageSize);
			
		}
	};
}

WmPaging.prototype.init=function(){
	//计算总页数
	 
	//创建左边的统计
	var  pageselectall=$(document.createElement("div"));
	
	pageselectall.addClass("pageselectall")
	var  pagetotal=$(document.createElement("div"));
	pagetotal.addClass("pagetotal");
	/*
	var pageselect=$(document.createElement("select"));
	*/
/*	pageselect.html("<option>5</option><option>10</option><option>15</option><option>20</option><option>30</option><option>50</option><option>80</option><option>100</option>");
*/	pagetotal.appendTo(pageselectall);
	/*pageselect.appendTo(pageselectall);
	pageselect.addClass("pageselect")
	*/pageselectall.appendTo(this.container);
	
	var pagelargediv=$(document.createElement("div"));
	pagelargediv.addClass("pageLargediv")
	//创建首页、前一页
	var pre = $(document.createElement("span"));
	var pre_first = $(document.createElement("a"));
	pre_first.html(this.buttonText.first);
	var pre_pre = pre_first.clone();
	pre_pre.html(this.buttonText.pre);
	pre.append(pre_first).append(pre_pre);
	//创建中间的分页按钮
	var pageNumber = $(document.createElement("ul"));
	var li = $(document.createElement("li"));
	li.html(1);
	li.addClass("wmeimob-li");
	pageNumber.addClass("wmeimob-pageNumber");
	pageNumber.append(li);
	
	var that = this;
	
	that.pageSize();
	
	

		if(that.options.pageCount > 1){
			var pageLi = null;
			var endPageNumber = that.options.pageCount <= 5 ? that.options.pageCount : 5;
		
			for(var i=2; i<=endPageNumber; i++){
				pageLi = li.clone();
				pageLi.html(i);
				pageNumber.append(pageLi);
				pageLi.addClass("pageLi")
				pageLi.on("click",function(){
					that.go(this.innerHTML);
					that.callExternalMethod();
		            that.pagetotal();
				});
			}
			li.toggleClass("select");
		}
	
	
	//创建尾页、后一页
	var next = $(document.createElement("span"));
	var next_nt = $(document.createElement("a"));
	next_nt.html(that.buttonText.next);
	next_nt.addClass("nextnt");
	var next_last = next_nt.clone();
	next_last.addClass("nextlast")
	next_last.html(that.buttonText.last);
	next.append(next_nt).append(next_last);

	
	pre.appendTo(pagelargediv);
	pageNumber.appendTo(pagelargediv);
	next.appendTo(pagelargediv);
	
	

	//创建右边的跳到第几页
//	var  gopage=$(document.createElement("div"));
//	gopage.addClass("gopage")
//	var gospan=$(document.createElement("span"));
	/*gospan.html('跳转到 第');*/
//	var gopageInput=$(document.createElement("input"));
//	gopageInput.attr("value","")
//	gopageInput.addClass("gopageindex")
//	gospanTwo=$(document.createElement('i'));
//	gospanTwo.html('页');

     
	
	/*动态创建跳转button*/
	var gobutton=$(document.createElement("button"));
	gobutton.addClass("gobutton");
	gobutton.html(that.buttonText.go);
//	gospan.appendTo(gopage);
//	gopageInput.appendTo(gopage);
//	gospanTwo.appendTo(gopage);
//	gopage.appendTo(pagelargediv);
/*	gobutton.appendTo(gopage);*/
	pagelargediv.appendTo(that.container);
	
	that.pagetotal();
	/*that.pageSelect();	*/
	this.eventBind();
};


WmPaging.prototype.eventBind=function(){
	
	var first = this.container.find("span:first").find("a:first");
	var pre = this.container.find("span:first").find("a:last");
	var next = this.container.find(".nextnt");
	var last = this.container.find(".nextlast");
	var pageselect=this.container.find(".pageselect");
	var gobutton=this.container.find(".gobutton");
	var that = this;
    var thatCount=this.options.pageCount;
    function accountall(){
    	if(thatCount==1){
    		return false
    	}
    }
    function allcount(){
		if(thatCount==1){
			return false;
		}
    }
	first.on("click", function(event){
		var curPageNumber = that.container.find("ul > li.select").html();
		if(curPageNumber ==undefined ||  curPageNumber =='')
			return;
		
		that.go(1);
		that.pagetotal();
		
		that.callExternalMethod();
		return false;
		
	});
	pre.on("click", function(event){
		accountall();
		var curPageNumber = that.container.find("ul > li.select").html();
		if(parseInt(curPageNumber) > 1)
			that.go(parseInt(curPageNumber) - 1);
		else 
			return;
		that.pagetotal();
		that.callExternalMethod();
		return false;
	});
	next.on("click", function(event){
		accountall();
		var curPageNumber = that.container.find("ul > li.select").html();

		if(curPageNumber ==undefined ||  curPageNumber =='')
			return;
		if(parseInt(curPageNumber) < that.options.pageCount)
			that.go(parseInt(curPageNumber) + 1);
		that.pagetotal();
		that.callExternalMethod();
		return false;
	});
	last.on("click", function(event){
		var curPageNumber = that.container.find("ul > li.select").html();
		if(curPageNumber ==undefined ||  curPageNumber =='')
			return;
		
		that.go(that.options.pageCount);
		that.pagetotal();

		that.callExternalMethod();

		return false;
	});
	var That=this.container;

    console.log(thatCount);

    
    
	/*gobutton.on("click",(function(event){
		alert(That.find(".gopageindex").val())
		
		var gopageIndex=That.find(".gopageindex").val()
		that.go(gopageIndex);
		if(gopageIndex <= 0){
	     that.go(1);
		}else if(gopageIndex>thatCount){
			that.go(thatCount)
		}
		that.callExternalMethod();
		that.pagetotal();
		return false;
	})
	);*/
	
  
	
};


WmPaging.prototype.go=function(i){
	/*if(i <= 0){
		that.go(1);
	}else if(i > this.options.pageCount){
		that.go(this.options.pageCount)
	}*/
		if(this.options.totalCount == 0 || this.options.totalCount <= this.options.pageSize){
		return;
	}
	var goPageNumber = parseInt(i);
	var currentPageNumber = this.container.find("ul > li.select").html();
	var gap = goPageNumber - parseInt(currentPageNumber);
	if(gap == 0){
		return;
	}
	if(goPageNumber <= 3){
		var endPageNumber = this.options.pageCount > 5 ? 5 : this.options.pageCount;
		this.generatePageNumberButtons(goPageNumber, 1, endPageNumber);
	}else if(goPageNumber + 2 <= this.options.pageCount){
		this.generatePageNumberButtons(goPageNumber, goPageNumber-2, goPageNumber+2);
	}else if(goPageNumber == this.options.pageCount){
		var beginPageNumber = this.options.pageCount-4 < 1 ? 1 : this.options.pageCount-4;
		this.generatePageNumberButtons(goPageNumber, beginPageNumber, this.options.pageCount);
	}else if(goPageNumber < this.options.pageCount){
		this.generatePageNumberButtons(goPageNumber, this.options.pageCount-4, this.options.pageCount);
	}
/*	this.callExternalMethod();*/
	
	
};

/*显示左边数据的统计数*/
WmPaging.prototype.pagetotal=function(){
	var currentdatalast=this.options.pageSize*$(".select").html();
	var currentdatafirst=currentdatalast-this.options.pageSize+1;
	/*if(currentdatalast>this.options.totalCount){
		  $(".pagetotal").html('共'+this.options.totalCount+'条数据');
	}else{
	    $(".pagetotal").html('共'+this.options.totalCount+'条数据');
	}*/
};


/*动态改变每一页显示的数据条数*/	
WmPaging.prototype.pageSize=function(){

	
		this.options.pageCount = this.options.totalCount % this.options.pageSize == 0 ? this.options.totalCount / this.options.pageSize : (parseInt(this.options.totalCount / this.options.pageSize) + 1);
}


/*select框动态修改每页显示数据的条数*/
/*WmPaging.prototype.pageSelect=function(){
	var that=this
	$(".pageselect").on("change",function(){
	        that.generatePageNumberButtons();
	    	that.options.pageSize = $(".pageselect").val();
	    	
	    	
			that.go(1);
			that.pageSize();
			that.pagetotal();
		
	})
 
}*/
