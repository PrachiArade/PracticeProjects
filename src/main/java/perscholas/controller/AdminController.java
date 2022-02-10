package perscholas.controller;


import net.bytebuddy.dynamic.DynamicType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import perscholas.security.UserDetailsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping ("/admin")

@PreAuthorize("hasAuthority('ADMIN')")
//TODO this restricts ADMIN only
public class AdminController {

    public static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
    @RequestMapping (value={"/home"}, method =RequestMethod.GET)

    public ModelAndView index(HttpServletRequest REQUEST, HttpSession session) throws Exception{
        ModelAndView response =new ModelAndView();
                response.setViewName("admin/home");
        return response;
    }



}
