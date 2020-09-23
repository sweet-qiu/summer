package com.qiu.controller;

import cn.dsna.util.images.ValidateCode;
import com.qiu.anno.Contype;
import com.qiu.domain.User;
import com.qiu.service.UserService;
import com.qiu.service.serviceimpl.UserServiceImpl;
import com.qiu.utils.CodeUtils;
import com.qiu.utils.SysConstant;
import org.apache.commons.beanutils.BeanUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/controller")
public class ControllerServlet extends BaseController {

    public String active(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("-------------");
        String code = request.getParameter("code");
        UserService service=new UserServiceImpl();
        boolean b = service.active(code);
        if(b){
            request.setAttribute("msg","激活成功" );

            return SysConstant.FORWARD+SysConstant.FLAG+"login.jsp";
        }else{
            return SysConstant.REDIRECT+SysConstant.FLAG+"register.jsp";
        }
    }
    @Contype(value = "image/jpg")
    public void image(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("+++++++++++++");
        ValidateCode code=new ValidateCode(150, 40, 4, 5);
        String code1 = code.getCode();
        request.getSession().setAttribute("code1", code1 );
        ImageIO.write(code.getBuffImg(),"jpg",response.getOutputStream());
    }
    @Contype(value = "application/json;charset=utf-8")
    public Map<String,Object> checkname(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        UserService service=new UserServiceImpl();
        boolean b = service.checkName(username);
        response.setCharacterEncoding("utf-8");
        Map<String,Object> map=new HashMap<>();
        if(!b){
            map.put("data",1);
        }else {
            map.put("data",0);
        }

        return map;
    }
    public String register(HttpServletRequest request, HttpServletResponse response) {
        UserService service=new UserServiceImpl();
        User user=new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
            user.setCode(CodeUtils.getActiveCode());
            user.setRole(0);
            user.setStatus(SysConstant.Status.NOT_ACTIVE.getCode());
            int i = service.register(user);
            System.out.println(i);
            if(i==1){
                request.getSession().setAttribute("msg", "注册成功");
                return SysConstant.FORWARD+SysConstant.FLAG+"registerSuccess.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysConstant.REDIRECT+SysConstant.FLAG+"register.jsp";
    }
    public String  login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code1 = (String)request.getSession().getAttribute("code1");
        String code = request.getParameter("code");
        System.out.println("***********");
        if(!code1.equalsIgnoreCase(code)||code==null){
            request.setAttribute("msg","验证码有误" );
            return SysConstant.FORWARD+SysConstant.FLAG+"login.jsp";
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service=new UserServiceImpl();
        User user = service.login(username, password);
        if(user==null){
            request.setAttribute("msg","账户或密码输入有误" );
            return SysConstant.FORWARD+SysConstant.FLAG+"login.jsp";
        }
        if(user!=null&&user.getStatus()== SysConstant.Status.NOT_ACTIVE.getCode()){
            request.setAttribute("msg","账户未激活" );
            return SysConstant.FORWARD+SysConstant.FLAG+"registerSuccess.jsp";
        }else if (user!=null&&user.getStatus()== SysConstant.Status.ACTIVT.getCode()){
            request.getSession().setAttribute("user", user);
            return SysConstant.FORWARD+SysConstant.FLAG+"index.jsp";
        }



        return SysConstant.FORWARD+SysConstant.FLAG+"login.jsp";
    }
    public String showInfo(HttpServletRequest request ,HttpServletResponse fresponse) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        return SysConstant.FORWARD+SysConstant.FLAG+"self_info.jsp";
    }

}
