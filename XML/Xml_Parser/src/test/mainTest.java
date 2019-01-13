package test;

import java.awt.List;
import java.io.File;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class mainTest {
	public static void main(String[] args) {
		try {
			//1.创建sax读取对象
			SAXReader reader =new SAXReader();
			//2.指定解析的xml源
			Document doc= reader.read(new File("src/xml/stus.xml"));
			//3.得到元素
			Element rootElement=doc.getRootElement();
			
			//得到根元素stus
			System.out.println(rootElement.getName());  
			//获取根元素下的子元素stu
			System.out.println(rootElement.element("stu").getName());
			//获取子元素下的子元素age
			System.out.println(rootElement.element("stu").element("age").getName());
			//获取age的具体值
			//System.out.println(rootElement.element("stu").element("age").getStringValue());
			System.out.println(rootElement.element("stu").element("age").getText());
		
		
		
		    //获取根元素下所有子元素（stu）
			java.util.List<Element>  elements = rootElement.elements();
			//遍历所有stu元素
			for (Element element : elements) {
				String name=element.element("name").getText();
				String age=element.element("age").getText();
				String address=element.element("address").getText();
				System.out.println("name="+name+"    age="+age+"    address="+address);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
