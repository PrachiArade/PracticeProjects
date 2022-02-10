package perscholas.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping()
public class RestController {

    @Autowired
    private UserDAO userDao;

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id){
         User user = userDao.findById(id);
         return user;

    }


    @GetMapping("/list")
    public List<User> getList(@RequestParam String firstName ){

        List<User> users = userDao.findByFirstNameLike(firstName);
       // User user = userDAO.findById(id);
        return users;
    }

    @ResponseBody
    @RequestMapping( value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)

       public ResponseEntity<Long> delete(@PathVariable Integer id){

        User user   = userDao.findById(id);
        userDao.delete(user);

        if (id != null && user != null){
            userDao.delete(user);
            return new ResponseEntity<Long>(id.longValue(), HttpStatus.OK);
        }else{
            return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
        }

//        JSONObject jo = new JSONObject();
//        jo.put("status", "success");
//        jo.put("response_code" ,"200");

        //return jo.toString();

    }



}
