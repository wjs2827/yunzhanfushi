package com.wmeimob.yzfs.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.service.UsersService;
import com.wmeimob.yzfs.vo.UserAccountLogsVO;
import com.wmeimob.yzfs.vo.UserCardLogsVO;
import com.wmeimob.yzfs.vo.UserCommissionAccountLogsVO;
import com.wmeimob.yzfs.vo.UserVO;

/**
 * 用户管理模块
 * @author WMM08
 *
 */
@Controller
@RequestMapping("/admin/user")
public class UsersController{


	@Autowired
	private UsersService usersService;
	
	
	/**
	 * 查询用户列表
	 * @return
	 */
	@RequestMapping("/userList")
	public ModelAndView selectUserListByParams(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/user_list");
		return mv;
	}
	
	
	
	/**
	 * 查询用户列表公共参数设置标准化
	 * @param request
	 * @return
	 */
	public UserVO publicParamsFromUser(HttpServletRequest request){
		UserVO params = new UserVO();
		String nickName=request.getParameter("nickName");//昵称或者手机号码
		String startTime=request.getParameter("startTime");//开始时间
		String endTime=request.getParameter("endTime");//结束时间
		if (!StringUtils.isEmpty(nickName)) {
			params.setNickName(nickName);
		}else{
			params.setNickName(null);
		}
		if (!StringUtils.isEmpty(startTime)) {
			params.setStartTime(startTime);
		}else{
			params.setStartTime(null);
		}
		if (!StringUtils.isEmpty(endTime)) {
			params.setEndTime(endTime);
		}else{
			params.setEndTime(null);
		}
		return params;
	}
	
	/**
	 * 异步查询用户列表
	 * @return
	 */
	@RequestMapping("/patchlist")
	@ResponseBody
	public ModelAndView patchlist(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		UserVO params = new UserVO();
		/*######商品查询参数设置######*/
		params=publicParamsFromUser(request);
		List<UserVO> userList = usersService.selectUserListByParams(params);
		mv.addObject("userList", userList);
		if(userList!=null &&userList.size()>0){
			mv.addObject("userCount", userList.size());//会员总数
		}else{
			mv.addObject("userCount", 0);
		}
		mv.setViewName("user/batch_user_list");
		return mv;
	}
	
	
	
	/**
	 * 根据账户信息变更用户信息
	 * @return
	 */
	@RequestMapping("/changeUserInfo")
	@ResponseBody
	public Map<String,Object> changeUserInfo(HttpServletRequest request,String userId,int changeType,Integer userPoint,String changeReson) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			UserCardLogsVO params = new UserCardLogsVO();
			params.setUserId(userId);
			params.setRecordType((byte) changeType);
			params.setChangeType("admin_change");
			params.setChangePoints(userPoint);
			params.setChangeNote(changeReson);
			return usersService.changeUserInfo(params);
		} catch (CustomException e) {
			map.put("code", 404);
			map.put("msg", "系统异常");
		}
		return map;
	}
	
	
	/**
	 * 查询积分流水列表
	 * @return
	 */
	@RequestMapping("/pointslist")
	public ModelAndView queryPointsList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/points_list");
		return mv;
	}
	
	
	/**
	 * 异步查询积分流水列表
	 * @return
	 */
	@RequestMapping("/batchPointsList")
	@ResponseBody
	public ModelAndView batchPointsList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		UserCardLogsVO params = new UserCardLogsVO();
		/*######商品查询参数设置######*/
		params=publicParamsFromPoints(request);
		List<UserCardLogsVO> pointsList = usersService.selectPointsListByParams(params);
		mv.addObject("list", pointsList);
		mv.setViewName("user/batch_points_list");
		return mv;
	}
	
	
	
	/**
	 * 查询积分流水公共参数设置标准化
	 * @param request
	 * @return
	 */
	public UserCardLogsVO publicParamsFromPoints(HttpServletRequest request){
		UserCardLogsVO params = new UserCardLogsVO();
		String nickName=request.getParameter("nickName");//昵称
		String startTime=request.getParameter("startTime");//开始时间
		String endTime=request.getParameter("endTime");//结束时间
		if (!StringUtils.isEmpty(startTime)) {
			params.setStartTime(startTime);
		}else{
			params.setStartTime(null);
		}
		if (!StringUtils.isEmpty(endTime)) {
			params.setEndTime(endTime);
		}else{
			params.setEndTime(null);
		}
		if (!StringUtils.isEmpty(nickName)) {
			params.setNickName(nickName);
		}else{
			params.setNickName(null);
		}
		return params;
	}
	
	
	
	/**
	 * 查询充值列表
	 * @return
	 */
	@RequestMapping("/queryAccountList")
	public ModelAndView queryAccountList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/recharge_list");
		return mv;
	}
	
	
	/**
	 * 异步查询充值列表
	 * @return
	 */
	@RequestMapping("/batchQueryAccountList")
	@ResponseBody
	public ModelAndView batchQueryAccountList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		UserAccountLogsVO params = new UserAccountLogsVO();
		/*######商品查询参数设置######*/
		params=publicParamsFromRechage(request);
		List<UserAccountLogsVO> pointsList = usersService.selectAccountListByParams(params);
		mv.addObject("list", pointsList);
		mv.setViewName("user/batch_recharge_list");
		return mv;
	}
	
	
	
	/**
	 * 查询充值列表公共参数设置标准化
	 * @param request
	 * @return
	 */
	public UserAccountLogsVO publicParamsFromRechage(HttpServletRequest request){
		UserAccountLogsVO params = new UserAccountLogsVO();
		String nickName=request.getParameter("nickName");//昵称
		String startTime=request.getParameter("startTime");//开始时间
		String endTime=request.getParameter("endTime");//结束时间
		String recharge=request.getParameter("recharge");//类型
		if (!StringUtils.isEmpty(startTime)) {
			params.setStartTime(startTime);
		}else{
			params.setStartTime(null);
		}
		if (!StringUtils.isEmpty(endTime)) {
			params.setEndTime(endTime);
		}else{
			params.setEndTime(null);
		}
		if (!StringUtils.isEmpty(nickName)) {
			params.setNickName(nickName);
		}else{
			params.setNickName(null);
		}
		if (!StringUtils.isEmpty(recharge)) {
			params.setChangeType(recharge);
		}else{
			params.setChangeType("recharge");
		}
		return params;
	}

	
	/**
	 * 查询佣金列表
	 * @return
	 */
	@RequestMapping("/queryCommissionList")
	public ModelAndView queryCommissionList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/commission_list");
		return mv;
	}
	
	
	/**
	 * 异步查询佣金列表
	 * @return
	 */
	@RequestMapping("/batchQueryCommissionList")
	@ResponseBody
	public ModelAndView batchQueryCommissionList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		UserCommissionAccountLogsVO params = new UserCommissionAccountLogsVO();
		/*######商品查询参数设置######*/
		params=publicParamsFromCommission(request);
		List<UserCommissionAccountLogsVO> pointsList = usersService.selectCommissionListByParams(params);
		mv.addObject("list", pointsList);
		mv.setViewName("user/batch_commission_list");
		return mv;
	}
	
	
	
	/**
	 * 查询佣金列表公共参数设置标准化
	 * @param request
	 * @return
	 */
	public UserCommissionAccountLogsVO publicParamsFromCommission(HttpServletRequest request){
		UserCommissionAccountLogsVO params = new UserCommissionAccountLogsVO();
		String nickName=request.getParameter("nickName");//昵称
		String startTime=request.getParameter("startTime");//开始时间
		String endTime=request.getParameter("endTime");//结束时间
		if (!StringUtils.isEmpty(startTime)) {
			params.setStartTime(startTime);
		}else{
			params.setStartTime(null);
		}
		if (!StringUtils.isEmpty(endTime)) {
			params.setEndTime(endTime);
		}else{
			params.setEndTime(null);
		}
		if (!StringUtils.isEmpty(nickName)) {
			params.setNickName(nickName);
		}else{
			params.setNickName(null);
		}
		return params;
	}


}
