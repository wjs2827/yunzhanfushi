package com.wmeimob.yzfs.controller;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.wmeimob.yzfs.exception.CustomException;
import com.wmeimob.yzfs.model.HelpManager;
import com.wmeimob.yzfs.service.HelpManagerService;
import com.wmeimob.yzfs.vo.HelpManagerVO;

/**
 * 商品管理模块
 * @author WMM08
 *
 */
@Controller
@RequestMapping("/admin/help")
public class HelpManagerController{

	@Autowired
	private HelpManagerService helpManagerService;
	
	
	/**
	 * 查询推广页
	 * @param request
	 * @return
	 */
	@RequestMapping("/tgList")
	public ModelAndView tgList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("help/tuiguang");
		HelpManager record = new HelpManager();
		record.setType(0);//推广页
		HelpManagerVO manager=helpManagerService.queryHelpList(record);
		mv.addObject("manager", manager);
		return mv;
	}
	
	/**
	 * 查询帮助说明
	 * @param request
	 * @return
	 */
	@RequestMapping("/helpList")
	public ModelAndView helpList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("help/help");
		HelpManager record = new HelpManager();
		record.setType(1);//帮助说明
		HelpManagerVO manager=helpManagerService.queryHelpList(record);
		mv.addObject("manager", manager);
		return mv;
	}
	
	
	/**
	 * 编辑
	 * @param request
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public Map<String, Object> edit(HttpServletRequest request) {
		Map<String, Object> resultVo=new HashMap<String, Object>();
		try {
			resultVo=helpManagerService.editAndSaveHelpManagerInfo(request);
		} catch (CustomException e) {
			resultVo.put("code", e.getCode());
			resultVo.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return resultVo;
	}


}
