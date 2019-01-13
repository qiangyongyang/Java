package com.itheima.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.*;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.exception.MessageException;
import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService;


@Controller
public class ItemController {
	
	@Autowired 
	private ItemService itemService;
	
	
	
	@RequestMapping("itemlist.action")
	public String itemList(Model model) throws Exception{
		//int i=1/0;
		List<Items> list = itemService.selectItemsList();
		/*if(null==null){
			throw new MessageException("商品信息不能为空");
		}*/
		model.addAttribute("itemList", list);
		return "itemList";
	}
	
	
	
	@RequestMapping("itemEdit.action")
	public String itemEdit(Integer id,Model model){
		Items items = itemService.findById(id);
		model.addAttribute("item", items);
		return "editItem";
	}
	
	
	
	@RequestMapping("updateitem.action")
	public String  itemUpdate(QueryVo vo,MultipartFile pictureFile) throws Exception {
		//保存图片到项目下
		
		
		//1.防止图片重名
		String name=UUID.randomUUID().toString().replace("-", "");  
		//2.获取图片后缀名
		String ext=FilenameUtils.getExtension(pictureFile.getOriginalFilename()) ;
		//3.保存图片图片到具体路径
		pictureFile.transferTo(new File("E:\\java\\程序\\SpringMVC\\springmvc-mybatis\\photo\\"+name+"."+ext));//图片保存地址
		//4.封装到items
		vo.getItems().setPic(name+"."+ext);
		
		
		itemService.itemUpdate(vo.getItems());
		//重定向页面：
		//return "redirect:/itemlist.action";
		return "redirect:/itemlist.action";
		//转发：
		//return "forward:itemlist.action";
	}
	
	/*@RequestMapping(value="login.action",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="login.action",method=RequestMethod.POST)
	public String login(String username,HttpServletRequest req){
		req.getSession().setAttribute("user_session", username);
		return "redirect:itemlist.action";
	}*/
	
	
	//json数据交互
	@RequestMapping("json.action") 
	@ResponseBody
	public Items json(@RequestBody Items items){
		return items;
	}
	
	
	
	
	//只是跳转页面看看-----批量删除 
	/*@RequestMapping(value={"/itemdeletes.action"} )
	public ModelAndView itemDeletes(Integer id[]){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("success");
		return mav;
	}*/
	
	
	
	
	
}











































