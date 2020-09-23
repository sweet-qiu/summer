package com.qiu.controller;

import com.qiu.anno.Contype;
import com.qiu.domain.PageBean;
import com.qiu.domain.Product;
import com.qiu.domain.Types;
import com.qiu.service.GoodsService;
import com.qiu.service.serviceimpl.GoodsServiceImpl;
import com.qiu.utils.SysConstant;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(value = "/goods")
public class GoodsController extends BaseController {
    GoodsService service=new GoodsServiceImpl();

    @Contype(value = "application/json;charset=utf-8")
    public List<Types> getTypes(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        List<Types> types = service.findTypes();
       return types;

    }

 public String getGoodsList(HttpServletRequest request, HttpServletResponse response ){
String typId= request.getParameter("typeId");
String nowpage= request.getParameter("nowpage");
     System.out.println(nowpage+"*");
if(nowpage==null||nowpage==""){
   nowpage="1";
}
     int id = Integer.parseInt(typId);
     int page = Integer.parseInt(nowpage);
     int start=(page-1)*5;
     PageBean bean=service.getGoods(id, start, 5);
     bean.setNowpage(page);
     request.setAttribute("glist",bean );
     request.setAttribute("typeId", typId);
     return SysConstant.FORWARD+SysConstant.FLAG+"goodsList.jsp";

 }
 public  String showMsg(HttpServletRequest request,HttpServletResponse response){
     String pid = request.getParameter("pid");
     int ppd = Integer.parseInt(pid);
     Product product = service.show(ppd);
     request.setAttribute("goods", product);
     return SysConstant.FORWARD+SysConstant.FLAG+"goodsDetail.jsp";
 }

}
