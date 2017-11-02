package com.wmeimob.yzfs.weixin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
 * <FromUserName><![CDATA[FromUser]]></FromUserName>
 * <CreateTime>123456789</CreateTime> <MsgType><![CDATA[event]]></MsgType>
 * <Event><![CDATA[VIEW]]></Event>
 * <EventKey><![CDATA[www.qq.com]]></EventKey> </xml>
 * 
 * @author yangzhou
 *
 */
public class XmlReaderUtil {

	private static DocumentBuilder db = null;

	public static Map<String, String> read(InputStream is)
			throws ParserConfigurationException, SAXException, IOException {
		if (db == null) {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		}
		Document doc = db.parse(is);
		NodeList list = doc.getChildNodes();
		if (list != null && list.getLength() > 0) {
			Map<String, String> xmlMap = new HashMap<String, String>();
			iteratorNode(list, xmlMap);
			is.close();
			return xmlMap;
		}
		return null;
	}

	/**
	 * 读取xml为map
	 * 
	 * @param xml
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Map<String, String> read(String xml) throws ParserConfigurationException, SAXException, IOException {
		ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
		return read(is);
	}

	/**
	 * 将map转换为Object
	 * 
	 * @param map
	 * @param clazz
	 * @return 
	 * @return
	 * @throws Exception
	 */
	public static <T> T mapToObject(Map<String, String> map, Class<T> clazz) throws Exception {
		if (map == null)
			return null;
		T obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			int mod = field.getModifiers();
			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}
			field.setAccessible(true);
			field.set(obj, map.get(field.getName()));		
		}
		return obj;
	}
	
	/**
	 * 将Object转换为xmlString
	 * @param o
	 * @return
	 */
	public static String objectToXml(Object o){
		String param = "<xml>";
		try {
			Class cls = o.getClass();
			Field[] fields = cls.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				if (f.get(o) != null && !"".equals(f.get(o))) {
					param += "<" + f.getName() + ">" + f.get(o) + "</" + f.getName() + ">";
				}
			}
		} catch (Exception e) {
			return null;
		}
		param += "</xml>";
		return param;
	}

	private static void iteratorNode(NodeList list, Map<String, String> xmlMap) {
		if (list != null && list.getLength() > 0) {
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getChildNodes() != null && node.getChildNodes().getLength() > 1) {
					iteratorNode(node.getChildNodes(), xmlMap);
				} else {
					String value = node.getNodeValue() == null ? node.getFirstChild().getNodeValue()
							: node.getNodeValue();
					xmlMap.put(node.getNodeName(), value);
				}
			}
		}
	}
	
    /**
    * 从Request对象中获得客户端IP，处理了HTTP代理服务器和Nginx的反向代理截取了ip
    * @param request
    * @return ip
    */
  public static  String getLocalIp(HttpServletRequest request) {
      String remoteAddr = request.getRemoteAddr();
      String forwarded = request.getHeader("X-Forwarded-For");
      String realIp = request.getHeader("X-Real-IP");

      String ip = null;
      if (realIp == null) {
          if (forwarded == null) {
              ip = remoteAddr;
          } else {
              ip = remoteAddr + "/" + forwarded.split(",")[0];
          }
      } else {
          if (realIp.equals(forwarded)) {
              ip = realIp;
          } else {
              if(forwarded != null){
                  forwarded = forwarded.split(",")[0];
              }
              ip = realIp + "/" + forwarded;
          }
      }
      return ip;
  }
}
