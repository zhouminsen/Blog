<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${cxt}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="application/javascript">  
  
$.fn.serializeObject = function()    
{    
   var o = {};    
   var a = this.serializeArray();    
   $.each(a, function() {    
       if (o[this.name]) {    
           if (!o[this.name].push) {    
               o[this.name] = [o[this.name]];    
           }    
           o[this.name].push(this.value || '');    
       } else {    
           o[this.name] = this.value || '';    
       }    
   });    
   return o;    
};  
  
function onClik(){  
        /* var data = $("#form1").serializeArray(); //自动将form表单封装成json  
        alert(JSON.stringify(data));   */
        var jsonuserinfo = $('#form1').serializeObject();  
        var jsonStr=JSON.stringify(jsonuserinfo);
        alert(jsonStr)
}  
</script>  
  
  <body>
   <body>  
<form id="form1" name="form1" method="post" action="">  
  <p>进货人 :  
    <label for="name"></label>  
    <input type="text" name="name" id="name" />  
  </p>  
  <p>性别:  
    <label for="sex"></label>  
    <select name="sex" size="1" id="sex">  
      <option value="1">男</option>  
      <option value="2">女</option>  
    </select>  
  </p>  
  <table width="708" border="1">  
    <tr>  
      <td width="185">商品名</td>  
      <td width="205">商品数量</td>  
      <td width="296">商品价格</td>  
    </tr>  
    <tr>  
      <td><label for="pro_name"></label>  
        <input type="text" name="pro_name" id="pro_name" /></td>  
      <td><label for="pro_num"></label>  
        <input type="text" name="pro_num" id="pro_num" /></td>  
      <td><label for="pro_price"></label>  
        <input type="text" name="pro_price" id="pro_price" /></td>  
    </tr>  
    <tr>  
      <td><input type="text" name="pro_name2" id="pro_name2" /></td>  
      <td><input type="text" name="pro_num2" id="pro_num2" /></td>  
      <td><input type="text" name="pro_price2" id="pro_price2" /></td>  
    </tr>  
  </table>  
  <p> </p>  
  <input type="button" name="submit" onclick="onClik();" value="提交"/>  
</form>  
</body>  
</html>  
  </body>
</html>
