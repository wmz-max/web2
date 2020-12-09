package web4.web4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import struct.Linkman;
import struct.LoginInfo;
import struct.Table;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddController {
    @PostMapping("/add")
    public String jumptoAdd(HttpServletRequest request)
    {

        return "redirect:/add";
    }
    @GetMapping("/add")
    public String showadd(HttpServletRequest request,Model model,Linkman man)
    {
        Object flag = request.getSession().getAttribute("login");
        if(null != flag)
        {
            flag = model.getAttribute("linkman");
            if(null == flag)
            {
                model.addAttribute("linkman",man);
            }
        }
        else
            return "redirect:/login";

        return "add";
    }
    @PostMapping("/checkadd")
    public String add(HttpServletRequest request,Model model,Linkman man)
    {
        Table t = (Table)request.getSession().getAttribute("table");
        t.getTable().add(man);
        return "redirect:/list";
    }
}
