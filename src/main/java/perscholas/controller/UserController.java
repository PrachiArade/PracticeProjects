package perscholas.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;


@Slf4j
@Controller
public class UserController {

    @RequestMapping
    public ModelAndView login (HttpServletRequest request, HttpSession session) throws Exception{

         ModelAndView response = new ModelAndView();
         response.setViewName("/login");
         return response;
    }


    // --------- common file upload method-------------//

    @RequestMapping (value = "/user/fileUpload", method = RequestMethod.GET)

    public ModelAndView fileUpload (HttpServletRequest request, HttpSession session) throws Exception{

        ModelAndView response = new ModelAndView();
        response.setViewName("user/fileUpload");
        return response;
    }

    @RequestMapping(value = "/user/fileUploadSubmit", method = RequestMethod.POST)

    public ModelAndView uploadSubmit
            (@RequestParam MultipartFile file,@RequestParam(required = false) String title )throws Exception {
        // figure out what the default OS temp directory is
        String tempdir = System.getProperty("java.io.tmpdir") + File.separator + "perscholas";

        // create a new file object for this directory and see if the directory exists
        File saveFileDirectory = new File(tempdir);
        if (!saveFileDirectory.exists()) {
            // it does not exist so make the temp directory using mkdirs
            // mkdirs will create any parent folders needed
            log.debug("Creating temp folder for file upload : " + saveFileDirectory.getAbsolutePath());
            saveFileDirectory.mkdirs();
        }

        // build the full path to file we want to save
        String saveFileName = saveFileDirectory.getAbsolutePath() + File.separator + file.getOriginalFilename();
        File targetFile = new File(saveFileName);

        if (targetFile.exists()) {
            throw new Exception("Unable to save uploaded file " + file.getOriginalFilename() + " because a file with that name already exists");

        }
        FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);

        log.debug("Uploaded file saved to : " + targetFile.getAbsolutePath());

        ModelAndView response = new ModelAndView();
        response.setViewName("user/fileUpload");
        return response;


    }

}
