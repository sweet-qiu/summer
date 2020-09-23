<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品列表页</title>

</head>
<body>
	<%@ include file="header.jsp"%>
	
   
<div class="panel panel-default" style="margin: 0 auto;width: 95%;">
	<div class="panel-heading">
	    <h3 class="panel-title"><span class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;商品列表</h3>
	</div>
	<div class="panel-body">
	   	   <!--列表开始-->
	    <div class="row" style="margin: 0 auto;">
	    	<c:forEach items="${glist.list}" var="g" varStatus="i">
		    	<div class="col-sm-3">
				    <div class="thumbnail">
				      <img src="${pageContext.request.contextPath}/${g.pimage}" width="180" height="180"  alt="小米6" />
				      <div class="caption">
				        <h4>商品名称<a href="${pageContext.request.contextPath}/goods?method=showMsg&pid=${g.pid}">${g.pname}</a></h4>
				        <p>热销指数
				        	<c:forEach begin="1" end="${g.pstate}">
				        		<img src="image/star_red.gif" alt="star"/>
				        	</c:forEach>
				        </p>
				         <p>上架日期:${g.ptime}</p>
			             <p style="color:orange">价格:${g.pprice}</p>
				      </div>
				    </div>
				  </div>
	    	</c:forEach>

			<div>
				<a href="goods?method=getGoodsList&nowpage=1&typeId=${typeId}">首页</a>
				<c:if test="${glist.nowpage<glist.pagecount}">
					<a href="goods?method=getGoodsList&typeId=${typeId}&nowpage=${glist.nowpage+1}">下一页</a>
				</c:if>
				<c:if test="${glist.nowpage>1}">
				<a href="goods?method=getGoodsList&typeId=${typeId}&nowpage=${glist.nowpage-1}">上一页</a>
				</c:if>
			    <a href="goods?method=getGoodsList&typeId=${typeId}&nowpage=${glist.pagecount}">尾页</a>
			</div>

		</div>
   	</div>
</div>
      <!-- 底部 -->
   <%@ include file="footer.jsp"%>
</body>
</html>