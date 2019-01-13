<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>用户注册</title>
		<script type="text/javascript">
		function checkUserName(){
				var username=document.getElementById("username");
				if(username.value.length<2){
					document.getElementById("span01").innerHTML="不合法";
				}else{
					document.getElementById("span01").innerHTML="";
				}
			}
			function checkPassWord(){
				var pass1=document.getElementById("password1");
				var pass2=document.getElementById("password2");
				if(pass1.value!=pass2.value){
					document.getElementById("span02").innerHTML="两次密码不一致";
				}else{
					document.getElementById("span02").innerHTML="";
				}
			}
			function isEmail(  ){
				var str=document.getElementById("email");
				if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(str)){
					document.getElementById("span03").innerHTML="";
	             }else{
					document.getElementById("span03").innerHTML="";
				}
			}
			function checkIdCard(){
				var idcard=document.getElementById("idcard");
				var len=idcard.value.length;
				if(len!=18){
					document.getElementById("span04").innerHTML="不是18位，不合法";
				}else{
					var chs=new Array();
					for(var x=0;x<len;x++){
						chs[x]=idcard.value.charAt(x);
						if(chs[x]<'0'||chs[x]>'9'){
							document.getElementById("span04").innerHTML="不合法，有其他字符";
						}
					}
				}
			}	
</script>
		
	</head>
<body>
	<form action="registServlet" method="post">
		<table border="1" width="500px">
			<tr>
				<td>用户名</td>
				<td><input type="text"  id="username" onblur="checkUserName()" name="username"> <span id="span01"></span></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="gender" value="男">男
					<input type="radio" name="gender" value="女">女
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" id="password1" name="password1"></td>
			</tr>
			
			<tr>
				<td>确认密码</td>
				<td><input type="password" id="password2" onblur="checkPassWord()" name="password2"><span id="span02"></span></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="email" id="email" onblur="isEmail( )" name="email"><span id="span03"></span></td>
			</tr>
			<tr>
				<td>身份证</td>
				<td><input type="text" id="idcard" onblur="checkIdCard()" name="idcard"> <span id="span04"></span></td>
			</tr>
			
			<tr>
				<td>出生日期</td>
				<td><input type="date" id="birthday" name="birthday"></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
					<input type="checkbox" name="hobby" value="book">book
					<input type="checkbox" name="hobby" value="lol">lol
					<input type="checkbox" name="hobby" value="cf">cf
					<input type="checkbox" name="hobby" value="dnf">dnf
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea name="info" rows="3" cols="20"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册"></td>
			</tr>
		</table>
	</form>
</body>
	
</html>
