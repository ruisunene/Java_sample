package com.example.demo;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("employeeInfo")
public class DisplayInfoController {
    private static final Logger logger = LoggerFactory.getLogger(DisplayInfoController.class);

    @PostMapping("/display_info")
    public String displayInfo(@ModelAttribute("employeeInfo") EmployeeInfo employeeInfo, HttpSession httpSession) {
        logger.info("employeeInfo =[{}]", employeeInfo.toString());
        logger.info("Session info: " + httpSession.toString()); 
        httpSession.invalidate();
        return "display_info";
    }
}
