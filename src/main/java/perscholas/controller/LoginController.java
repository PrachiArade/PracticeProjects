package perscholas.controller;

import com.fasterxml.jackson.databind.DatabindContext;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/registration-url-path")
public class LoginController {


    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public ModelAndView login( HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();

       String username = (String) session.getAttribute("username");

//        if ("tom".equals(username)) {
//            response.setViewName("login/success");
//        } else {
//            response.setViewName("login/login");
//        }
        response.setViewName("/login/login");
        return response;
    }

    @RequestMapping(value = "/loginSubmit", method = RequestMethod.GET)
    public ModelAndView loginSubmit(ServletRequest request , HttpSession session ) throws Exception {

        //name should be same as on the html form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ModelAndView response = new ModelAndView();

        if ( username.equals("tom") && password.equals("jerry")){
            session.setAttribute("username","putting username in session here"+ username);
            response.setViewName("login/success");
        } else {
            response.setViewName("login/login");
        }

        return response;
    }

  /*  @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginReturn(ServletRequest request ,HttpSession session ) throws Exception {

        ModelAndView response = new ModelAndView();

        response.setViewName("login/login");

        return response;
    }*/


    }

   /*// Exercise 1//
    create a login controller
    create a success.jsp
    create a login.jsp page with a form that has username and password
    make the form submit to login
    in the loginSubmit function check if the username is tom and password is jerry
    if true then add tom to the session and return the success view
    otherwise return the login view
    in the login method check if the username tom is in the session & so return the success view




      // exercise 2//
	 use setAttribute to set an error message in the session.   In the formSubmit2 method
	// getAttribute to get the error message from the session in the login method.
	// response (model) .addObject to make the error message available to the JSP
	// alter the login.jsp to show the error message from the model using ${ } notation */
