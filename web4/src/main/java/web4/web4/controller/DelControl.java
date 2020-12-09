package web4.web4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import struct.Linkman;
import struct.Table;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DelControl {
    @GetMapping("/del")
    public String del(HttpServletRequest request)
    {
        return "list";
    }
    @PostMapping("/del")
    public String showChange(@ModelAttribute(value="row")Integer row, HttpServletRequest request, Model model){
        //修改会将当前列表行传过去
        Table t = (Table)request.getSession().getAttribute("table");
        //利用这一行列表实例化一个联系人对象
        Linkman linkman = t.getTable().elementAt(row);
        //将联系人对象传给change.html以便修改
        t.getTable().remove(linkman);
        return "redirect:/list";
    }
}
