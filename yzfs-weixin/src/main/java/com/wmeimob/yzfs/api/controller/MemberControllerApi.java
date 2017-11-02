package com.wmeimob.yzfs.api.controller;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wmeimob.wechat.core.WeChat;
import com.wmeimob.wechat.model.basic.WxAuthAccessToken;
import com.wmeimob.yzfs.common.BaseController;
import com.wmeimob.yzfs.dao.UsersMapper;
import com.wmeimob.yzfs.util.APIConstant;
import com.wmeimob.yzfs.util.JwtTokenUtil;
import com.wmeimob.yzfs.util.JwtUserFactory;
import com.wmeimob.yzfs.util.JwtWechatUser;
import com.wmeimob.yzfs.weixin.WeChatUtil;

@Controller
@RequestMapping("/center/api")
@CrossOrigin
@Transactional
public class MemberControllerApi{
	
	

}
