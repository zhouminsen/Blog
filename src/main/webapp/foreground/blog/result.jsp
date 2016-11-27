<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="data_list">
		<div class="data_list_title">
		<img src="${cxt}/static/images/search_icon.png"/>
		搜索&nbsp;<font color="red">${keyword}</font>&nbsp;的结果 &nbsp;(总共搜索到&nbsp;${page.totalCount}&nbsp;条记录) </div>
		<div class="datas search">
			<ul>
				<c:choose>
					<c:when test="${blogList.size()==0 }">
						<div align="center" style="padding-top: 20px">${dataEmptyMsg }</div>
					</c:when>
					<c:otherwise>
						<c:forEach var="blog" items="${blogList }">
					  	  <li style="margin-bottom: 20px">
						  	<span class="title"><a href="${cxt}/blog/detail/${blog.id}.shtml" target="_blank">${blog.title }</a></span>
						  	<span class="summary">摘要: ${blog.content }...</span>
						  	<span class="link">
						  		<a href="${cxt}/blog/detail/${blog.id}.shtml">http://blog.java1234.com/blog/articles/${blog.id}.shtml</a>&nbsp;&nbsp;&nbsp;&nbsp;发布日期：${blog.releaseDate }
						  	</span>
						  </li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
   </div>
   <div>
	<nav>
	  <ul class="pagination pagination-sm">
	    ${page.url}
	  </ul>
	</nav>
 </div>