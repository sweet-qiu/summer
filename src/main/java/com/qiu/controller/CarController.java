package com.qiu.controller;

import com.qiu.domain.Car;
import com.qiu.domain.User;
import com.qiu.service.CarService;
import com.qiu.service.serviceimpl.CarServiceImpl;
import com.qiu.utils.SysConstant;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(value = "/car")
public class CarController extends BaseController {

    CarService service=new CarServiceImpl();
    public String addCart(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            request.setAttribute("msg","请登录之后进行操作" );
            return SysConstant.REDIRECT+SysConstant.FLAG+"login.jsp";
        }
        int uid = user.getId();
        String pid1 = request.getParameter("pid");
        int pid = Integer.parseInt(pid1);
        int i = service.addCar(pid, uid);
        if(i!=0) {
            request.setAttribute("cid", i);
            return SysConstant.FORWARD + SysConstant.FLAG + "cartSuccess.jsp";
        }else {
            return SysConstant.REDIRECT+SysConstant.FLAG+"goodsList.jsp";
        }
    }
    public String getCart(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            request.setAttribute("msg","请登录之后进行操作" );
            return SysConstant.REDIRECT+SysConstant.FLAG+"login.jsp";
        }
        int uid = user.getId();
        List<Car> car = service.getCar(uid);
        request.setAttribute("carts", car);
        return SysConstant.FORWARD + SysConstant.FLAG + "cart.jsp";

    }
    public String updateCartNum(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            request.setAttribute("msg","请登录之后进行操作" );
            return SysConstant.REDIRECT+SysConstant.FLAG+"login.jsp";
        }
        String cid1 = request.getParameter("cid");
        String num1 = request.getParameter("num");
        String price1 = request.getParameter("price");
        int cid = Integer.parseInt(cid1);
        int num = Integer.parseInt(num1);
        int price = Integer.parseInt(price1);
        int i = service.updateNum(num ,new BigDecimal(price), cid);
        if(i==-1){
            return SysConstant.FORWARD+SysConstant.FLAG+"car?method=getCart";
        }
        return null;
    }
    public String clear(HttpServletRequest request, HttpServletResponse response){
        System.out.println("??");
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            request.setAttribute("msg","请登录之后进行操作" );
            return SysConstant.REDIRECT+SysConstant.FLAG+"login.jsp";
        }
        String cid = request.getParameter("cid");
        int cid1 = Integer.parseInt(cid);
        if(cid1!=0){
            service.clear(cid1);
        }else{
            service.clearAll( user.getId());
        }
        return SysConstant.FORWARD+SysConstant.FLAG+"car?method=getCart";
    }
}
