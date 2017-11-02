package com.wmeimob.yzfs.api.wxutils;

import java.io.StringReader;   
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;   
import javax.xml.parsers.DocumentBuilderFactory;   
import org.w3c.dom.Document;   
import org.w3c.dom.Element;   
import org.w3c.dom.Node;   
import org.w3c.dom.NodeList;   
import org.xml.sax.InputSource; 

/**
 * 解析xml（key不重复）
 * @author Administrator
 *
 */
public class XmlAnalysisUtil {
	
	public static Map<String, Object> xmlAnalysisUtil(String xml) {
	    Map<String, Object> condition = new HashMap<String, Object>();
	    try {   
            DocumentBuilderFactory factory = DocumentBuilderFactory   
                    .newInstance();   
            DocumentBuilder builder = factory.newDocumentBuilder();   
            Document doc = builder   
                    .parse(new InputSource(new StringReader(xml)));   
 
            Element root = doc.getDocumentElement();   
            NodeList books = root.getChildNodes();   
           if (books != null) {   
               for (int i = 0; i < books.getLength(); i++) {   
                    Node book = books.item(i);   
                    if(book!=null&&book.getFirstChild()!=null){
                    	condition.put(book.getNodeName(), book.getFirstChild().getNodeValue());
	                    System.out.println("节点=" + book.getNodeName() + "\ttext="  
	                            + book.getFirstChild().getNodeValue());  
                    }
                }   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        }    
		return condition;
	}

}
