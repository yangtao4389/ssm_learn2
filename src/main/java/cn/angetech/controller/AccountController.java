package cn.angetech.controller;

import cn.angetech.domain.Account;
import cn.angetech.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/findAll")
    public String findAll(Model model){
        System.out.println("Controller表现层：查询所有zhaopin.com。");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";  // 跳转到list页面？？？？？？？
    }

    // 直接返回字符串
//    @RequestMapping("/account/findAll")
//    public void findAll(HttpServletRequest req, HttpServletResponse resp)  throws Exception {
//        resp.getWriter().println("hello HttpServletResponse");
//    }

    // 重定向到另外一个视图
//    @RequestMapping("/account/findAll")
//    public void findAll(HttpServletRequest req, HttpServletResponse resp)  throws Exception {
//        resp.sendRedirect("index.jsp"); // http://localhost:8050/ssm_learn2/account/index.jsp
//    }

    @RequestMapping("/account/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception{
       accountService.saveAccount(account);
       response.sendRedirect(request.getContextPath()+"/account/findAll");
       return;
    }

}
