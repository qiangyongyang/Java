$(function() {
	//1。找到省份的元素
	$("#province").change(function() {
		//2. 一旦里面的值发生了改变，那么就去请求该省份的城市数据
		//$("#province").varl();
		var pid = $(this).val();
		
		/*<list>
			<city>
				<id>1<id>
				<pid>1</pid>
				<cname>深圳</cname>
			</city>
			<city >
				<id>2<id>
				<pid>1</pid>
				<cname>东莞</cname>
			</city>
		</list>*/
		
		$.post( "CityServlet",{pid:pid} ,function(data,status){
			//alert("回来数据了:"+data);
			
			//先清空以前的值：
			$("#city").html("<option value='' >-请选择-")
			//遍历： 
			//从data数据里面找出所有的city  ， 然后遍历所有的city。
			//遍历一个city，就执行一次function方法
			$(data).find("city").each(function() {
				
				//遍历出来的每一个city，取它的孩子。 id , cname
				var id = $(this).children("id").text();
				var cname = $(this).children("cname").text();
				
				$("#city").append("<option value='"+id+"' >"+cname)
			});
		} );
		
	});
});