package test;



import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathTest {
	public static void main(String[] args) {
		try {
			SAXReader reader=new SAXReader();
			Document doc=reader.read(new File("src/xml/stus.xml"));
			Element rootElement =doc.getRootElement();
			
			//Ҫ��ʹ��Xpath����Ҫ���֧�ֵ�jar����ȡ���ǵ�һ����Ҳֻ����һ��
			Element nameElement =(Element)rootElement.selectSingleNode("//name");
			System.out.println(nameElement.getText());
			
			System.out.println("---------------------------------------");
			
			List<Element> list = rootElement.selectNodes("//name");
			for (Element element : list) {
				System.out.println(element.getText());
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
	}
}
