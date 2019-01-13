package test;

import java.awt.List;
import java.io.File;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class mainTest {
	public static void main(String[] args) {
		try {
			//1.����sax��ȡ����
			SAXReader reader =new SAXReader();
			//2.ָ��������xmlԴ
			Document doc= reader.read(new File("src/xml/stus.xml"));
			//3.�õ�Ԫ��
			Element rootElement=doc.getRootElement();
			
			//�õ���Ԫ��stus
			System.out.println(rootElement.getName());  
			//��ȡ��Ԫ���µ���Ԫ��stu
			System.out.println(rootElement.element("stu").getName());
			//��ȡ��Ԫ���µ���Ԫ��age
			System.out.println(rootElement.element("stu").element("age").getName());
			//��ȡage�ľ���ֵ
			//System.out.println(rootElement.element("stu").element("age").getStringValue());
			System.out.println(rootElement.element("stu").element("age").getText());
		
		
		
		    //��ȡ��Ԫ����������Ԫ�أ�stu��
			java.util.List<Element>  elements = rootElement.elements();
			//��������stuԪ��
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
