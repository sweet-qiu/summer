package com.qiu.controller;

import com.qiu.domain.Address;
import com.qiu.domain.Car;
import com.qiu.domain.Order;
import com.qiu.domain.User;
import com.qiu.service.CarService;
import com.qiu.service.OrderService;
import com.qiu.service.serviceimpl.CarServiceImpl;
import com.qiu.service.serviceimpl.OrderServiceIpl;
import com.qiu.utils.SysConstant;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(value = "/order")
public class OrederController extends BaseController {
    CarService carService=new CarServiceImpl();
    OrderService service=new OrderServiceIpl();

    public String  getOrder(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        User user =(User) request.getSession().getAttribute("user");
        System.out.println(user.toString());
            List<Car> car = carService.getCar(user.getId());
            List<Address> address = service.addAdress(user.getId());

            request.setAttribute("car", car);
            request.setAttribute("address", address);
        return SysConstant.FORWARD+SysConstant.FLAG+"order.jsp";
    }
    public String addAddress(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String uid = request.getParameter("uid");
        int i = Integer.parseInt(uid);
        String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String detail = request.getParameter("detail");
            Address address=new Address(0, i, name, phone, detail, 0);
            service.add(address);
        return SysConstant.REDIRECT+SysConstant.FLAG+"cart.jsp";
    }
    public String addOrder(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String aid = request.getParameter("aid");
        int aid1 = Integer.parseInt(aid);
        User user = (User) request.getSession().getAttribute("user");
        Order order = service.addOrder(aid1, user.getId());
        request.setAttribute("order", order);
        return SysConstant.FORWARD+SysConstant.FLAG+"orderSuccess.jsp";
    }
 public String showOrder(HttpServletRequest request ,HttpServletResponse response){
     User user = (User) request.getSession().getAttribute("user");
     int uid = user.getId();
     List<Order> orders = service.orderList(uid);
     request.setAttribute("user", user);
     request.setAttribute("orderList", orders);
     return SysConstant.FORWARD+SysConstant.FLAG+"orderList.jsp";
 }
public String getOrderDetail(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
    request.setCharacterEncoding("utf-8");
    User user = (User) request.getSession().getAttribute("user");
    int uid = user.getId();
    String oid = request.getParameter("oid");
    Order order = service.searchOrder(oid);
    request.setAttribute("order", order);
    List<Car> car = service.show(uid);
    request.setAttribute("list", car);
    return SysConstant.FORWARD+SysConstant.FLAG+"orderDetail.jsp";
}
}
