package com.wmeimob.yzfs.controller;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wmeimob.yzfs.service.AdminStatisticsService;
import com.wmeimob.yzfs.vo.DataStatisticsVO;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Alignment;
import jxl.write.Border;
import jxl.write.BorderLineStyle;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/*所有统计管理*/
@Controller
@RequestMapping("/admin/statis")
public class AdminStatisticsController{
	
	
	@Autowired
	private AdminStatisticsService adminStatisticsService;
	
	
	
	/**
	 * 订单销售统计
	 * @return
	 */
	@RequestMapping("/goodStatisList")
	public ModelAndView statisList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("statistics/good_statistics");
		return mv;
	}
	
	/**
	 * 异步查询订单销售统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/batchGoodStatisList")
	public ModelAndView batchGoodStatisList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("statistics/batch_good_statistics");
		DataStatisticsVO params =new DataStatisticsVO();
		//参数处理
		params=publicGoodsParams(request);
		List<DataStatisticsVO> list = adminStatisticsService.queryGoodStatistics(params);
		//计算合计
		Integer allSumSellCount = 0;//销售数量总计
		BigDecimal allSumSellAmount =new BigDecimal(0.00);//销售金额总计
		BigDecimal allSumSellPoints =new BigDecimal(0.00);;//销售金币总计
		Integer allSumBackCount = 0;//退货数量总计
		BigDecimal allSumBackAmount =new BigDecimal(0.00);//退货金额总计
		if(!StringUtils.isEmpty(list)&&list.size()>0){
			for(int i=0;i<list.size();i++){
				allSumSellCount=allSumSellCount+list.get(i).getSaleCount();
				allSumSellAmount=allSumSellAmount.add(list.get(i).getSaleAmount());
				allSumSellPoints=allSumSellPoints.add(list.get(i).getDeductibleAmount());
				allSumBackCount=allSumBackCount+list.get(i).getRefundCount();
				allSumBackAmount=allSumBackAmount.add(list.get(i).getRefundAmount());
			}
		}
		mv.addObject("allSumSellCount", allSumSellCount);//销售数量总计
		mv.addObject("allSumSellAmount", allSumSellAmount);//销售金额总计
		mv.addObject("allSumSellPoints", allSumSellPoints);//销售积分总计
		mv.addObject("allSumBackCount", allSumBackCount);//退货数量总计
		mv.addObject("allSumBackAmount", allSumBackAmount);//退货金额总计
		mv.addObject("list", list);
		return mv;
	}
	
	/**
	 * 订单统计公共参数处理方法
	 * @param request
	 * @return
	 */
	public DataStatisticsVO publicGoodsParams(HttpServletRequest request){
		DataStatisticsVO params =new DataStatisticsVO();
		String name=request.getParameter("goodName");//商品名称
		String nickName=request.getParameter("nickName");//商品昵称或者手机号码
		String createStart=request.getParameter("startTime");//创建时间开始
		String createEnd=request.getParameter("endTime");//创建时间结束
		String firstClassId=request.getParameter("firstClassId");//一级分类
		String secondClassId=request.getParameter("secondClassId");//二级分类
		if(!StringUtils.isEmpty(name)){
			params.setGoodName(name);
		}else{
			params.setGoodName(null);
		}
		if(!StringUtils.isEmpty(nickName)){
			params.setNickName(nickName);
		}else{
			params.setNickName(null);
		}
		if(!StringUtils.isEmpty(createStart)){
			params.setStartTime(createStart);
		}else{
			params.setStartTime(null);
		}
		if(!StringUtils.isEmpty(createEnd)){
			params.setEndTime(createEnd);
		}else{
			params.setEndTime(null);
		}
		if(!StringUtils.isEmpty(firstClassId)){
			params.setFirstClassId(firstClassId);
			
		}else{
			params.setFirstClassId(null);
		}
		if(!StringUtils.isEmpty(secondClassId)){
			params.setSecondClassId(secondClassId);
		}else{
			params.setSecondClassId(null);
		}
		return params;
	}
	
	/**
	 * 充值统计
	 * @return
	 */
	@RequestMapping("/rechargeStatisList")
	public ModelAndView rechargeStatisList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("statistics/recharge_statistics");
		return mv;
	}
	
	/**
	 * 异步查询充值统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/batchRechargeStatisList")
	public ModelAndView batchRechargeStatisList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("statistics/batch_recharge_statistics");
		DataStatisticsVO params =new DataStatisticsVO();
		//参数处理
		params=publicGoodsParams(request);
		List<DataStatisticsVO> list = adminStatisticsService.queryRechargeStatistics(params);
		//计算合计
		BigDecimal allSumRechargeAmount =new BigDecimal(0.00);//累计充值余额
		BigDecimal allSumAttachAmount =new BigDecimal(0.00);;//累计赠送余额
		if(!StringUtils.isEmpty(list)&&list.size()>0){
			for(int i=0;i<list.size();i++){
				allSumRechargeAmount=allSumRechargeAmount.add(list.get(i).getSumRechargeAmount());
				allSumAttachAmount=allSumAttachAmount.add(list.get(i).getSumAttachAmount());
			}
		}
		mv.addObject("allSumRechargeAmount", allSumRechargeAmount);//累计充值余额
		mv.addObject("allSumAttachAmount", allSumAttachAmount);//累计赠送余额
		mv.addObject("allSumAccountAmount", allSumRechargeAmount.add(allSumAttachAmount));//累计账户余额
		mv.addObject("list", list);
		return mv;
	}
	
	/**
	 * 佣金统计
	 * @return
	 */
	@RequestMapping("/commissionStatisList")
	public ModelAndView commissionStatisList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("statistics/commisssion_statistics");
		return mv;
	}
	
	/**
	 * 异步查询佣金统计
	 * @param request
	 * @return
	 */
	@RequestMapping("/batchCommissionStatisList")
	public ModelAndView batchCommissionStatisList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("statistics/batch_commission_statistics");
		DataStatisticsVO params =new DataStatisticsVO();
		//参数处理
		params=publicGoodsParams(request);
		List<DataStatisticsVO> list = adminStatisticsService.queryCommissionStatistics(params);
		//计算合计
		BigDecimal allSumRechargeAmount =new BigDecimal(0.00);//累计佣金
		BigDecimal allSumAttachAmount =new BigDecimal(0.00);;//累计已提现佣金
		BigDecimal allSumAccountAmount =new BigDecimal(0.00);;//累计可用佣金
		if(!StringUtils.isEmpty(list)&&list.size()>0){
			for(int i=0;i<list.size();i++){
				allSumRechargeAmount=allSumRechargeAmount.add(list.get(i).getSumCommissonAmount());
				allSumAttachAmount=allSumAttachAmount.add(list.get(i).getSumWithdrawAmount());
				allSumAccountAmount=allSumAccountAmount.add(list.get(i).getSumCommissionAccountAmount());
			}
		}
		mv.addObject("allSumRechargeAmount", allSumRechargeAmount);//累计佣金
		mv.addObject("allSumAttachAmount", allSumAttachAmount);//累计已提现佣金
		mv.addObject("allSumAccountAmount", allSumAccountAmount);//累计可用佣金
		mv.addObject("list", list);
		return mv;
	}
	
	
}
