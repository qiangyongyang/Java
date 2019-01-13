$(function() {
	//1。找到省份的元素
	$("#province").change(function() {
		//2. 一旦里面的值发生了改变，那么就去请求该省份的城市数据
		//$("#province").varl();
		var pid = $(this).val();
		
		$("#city").html("<option value=''>-请选择-");
		$.post( "CityServlet02",{pid:pid} ,function(data,status){
			$(data).each(function(index,city){
				$("#city").append("<option value='"+city.id+"'>"+city.cname);
			});
		},"json");
		
	});
});