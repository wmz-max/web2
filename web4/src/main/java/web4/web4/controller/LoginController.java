package web4.web4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import struct.LoginInfo;
import struct.Table;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping({"/","login"})
    public String login(LoginInfo users, Model model, HttpServletRequest request)
    {
        Object flag = request.getSession().getAttribute("login");
        //未登录，交给login.html渲染
        if(null == flag){
            //准备一个模型的数据，将模型的数据加载回login.html中
            flag = model.getAttribute("user");
            if(null == flag){
                model.addAttribute("user",users);
            }
            //返回login.html进行渲染
            return "login";
        }
        //已经登录，直接重定向到通讯录列表
        else
            return "redirect:/list";
    }

    @PostMapping("/checklogin")
    public String checkLogin(LoginInfo user, Model model, HttpServletRequest request){
        //用户名密码正确，设置session中的login参数，并进入联系人表格界面
        if(user.getUsername().equals("admin") && user.getPassword().equals("123456")){
            request.getSession().setAttribute("login",1);
            return "redirect:/list";
        }
        //用户名或密码错误，需要重新返回登录界面，但是为了有提示信息，所以直接保留当前user，通过该结构内的message设置提示信息
        else{
            user.setUsername("");
            user.setPassword("");
            return login(user,model,request);
        }

    }

    @RequestMapping("/checklogin")
    public String redirectLogin(HttpServletRequest request){
        if(null == request.getSession().getAttribute("login")){
            return "redirect:/login";
        }
        else{
            return "redirect:/list";
        }
    }
    @GetMapping("/list")
    public String showMain(HttpServletRequest request){
        Object flag = request.getSession().getAttribute("login");
        if(null != flag){
            HttpSession session = request.getSession();
           // 如果访问时还是一个空列表对象，就先为其分配一个空间
            if(null == session.getAttribute("table")){
                Table table = new Table();
                session.setAttribute("table",table);
            }
            return "list";
        }
        else
            return
                    "redirect:/login";
    }
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        request.getSession().removeAttribute("login");
        return "redirect:/login";
    }
    @PostMapping("/exit")
    public String exit1(HttpServletRequest request){
        request.getSession().removeAttribute("login");
        return "redirect:/login";
    }

}
