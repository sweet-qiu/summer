package com.qiu.controller;

import com.google.gson.Gson;
import com.qiu.anno.Contype;
import com.qiu.utils.SysConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodstr = request.getParameter("method");

        if(methodstr==null){
            response.sendRedirect("/index.jsp");
        }
        try {
            Class clazz = this.getClass();
            Object o = clazz.newInstance();
            Method method = clazz.getMethod(methodstr, HttpServletRequest.class, HttpServletResponse.class);
            if(method.isAnnotationPresent(Contype.class)){
                Contype contype = method.getAnnotation(Contype.class);
                String type = contype.value();
                response.setContentType(type);
            }else{
                response.setContentType("text/html;charset=utf-8");
            }

            Object invoke = method.invoke(o, request, response);

            if(invoke!=null){
               if(invoke.getClass().getSimpleName().equalsIgnoreCase("String")){
                   String s=(String)invoke;
                   String substring = s.substring(s.indexOf(":") + 1);
                   if(s.startsWith(SysConstant.FORWARD)){
                       request.getRequestDispatcher(substring).forward(request,response );
                   }else if(s.startsWith(SysConstant.REDIRECT)){
                       response.sendRedirect(substring);
                   }

               }else{
                   //返回json  前端请求ajax
                   // public  List<Users>  findAll()
                   //public  Map<String,Object>  checkName()
                   //转json
                   String s = new Gson().toJson(invoke);
                   response.getWriter().print(s);

               }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
