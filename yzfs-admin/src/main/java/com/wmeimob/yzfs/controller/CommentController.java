package com.wmeimob.yzfs.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.yzfs.service.CommentService;
import com.wmeimob.yzfs.vo.GoodsCommentVO;

/**
 * 商品评论列表
 *
 * @Date 2016/8/1 18:34
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentController{

    @Autowired
    private CommentService commentService;


    /**
     * 查询商品评价列表
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView queryCommentList(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/comment/comment_manage");//页面
        return mv;
    }
    
	/**
	 * 查询公共参数处理
	 * @param request
	 * @return
	 */
	public Map<String,Object> getOrderPublicParams(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
		String goodsName=request.getParameter("goodName");//商品名称
		String createStart=request.getParameter("startTime");//开始时间
		String createEnd=request.getParameter("endTime");//结束时间
		String orderNo=request.getParameter("orderNo");//卡号
		String nickName=request.getParameter("nickName");//客户
		String grade=request.getParameter("grade");
		if(!StringUtils.isEmpty(goodsName))
		    map.put("goodsName",goodsName);
		else
		    map.put("goodsName","");
		if(!StringUtils.isEmpty(createStart))
			map.put("createStart",createStart);
		else
			map.put("createStart","");//如果开始时间为空，则默认当前时间00：00开始
		if(!StringUtils.isEmpty(createEnd))
            map.put("createEnd",createEnd);
		else 
			map.put("createEnd","");//如果结束时间为空，则默认当前结束时间23：59结束
		if(!StringUtils.isEmpty(orderNo))
            map.put("orderNo",orderNo);
		else
			map.put("orderNo","");
		if(!StringUtils.isEmpty(nickName))
            map.put("nickName",nickName);
		else
			map.put("nickName","");
		if(!StringUtils.isEmpty(grade))
		    map.put("grade",grade);
		else
		    map.put("grade","0");
		return map;
		/*######参数处理结束######*/
	}
    
	 /**
     * 异步查询订单信息
     * @param request
     * @return
     */
    @RequestMapping("/patchList")
    public ModelAndView queryGoodsClassPatch(HttpServletRequest request){
    	ModelAndView mv = new ModelAndView();
        Map<String,Object> map =getOrderPublicParams(request);
        List<GoodsCommentVO> commentVos = commentService.queryCommentsInfo(map);
        mv.addObject("commentVos",commentVos);//评论列表
        mv.setViewName("/comment/comment_patchList");//页面
    	return mv;
    }


    /**
     * 是否微信端显示和隐藏评论
     * @param id
     * @return
     */
    @RequestMapping(value= "/delete")
    @ResponseBody
    public JSONObject deleteComment(@RequestParam("id") String id,@RequestParam("status") Integer status){
    	JSONObject json = new JSONObject();
    	GoodsCommentVO params =new GoodsCommentVO();
        params.setId(id);
        params.setStatus(status);
        String msg="";
        if(status==1){
        	msg="启用成功";
        }else{
        	msg="停用成功";
        }
        	
        Integer count = commentService.deleteComments(params);
        if (count > 0) {
        	json.put("code", 100);
        	json.put("msg", msg);
        }else{
        	json.put("code", 200);
        	json.put("msg", "操作失败");
        }
        return json;
    }
}
