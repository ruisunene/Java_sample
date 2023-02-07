package com.example.demo;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("employeeInfo")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @ModelAttribute("employeeInfo")
    public EmployeeInfo employeeInfo() {
        return new EmployeeInfo();
    }


    @ModelAttribute("genders")
    public List<String> genders() {
        return Arrays.asList("男性", "女性");
    }

    @ModelAttribute("departments")
    public List<String> departments() {
        return Arrays.asList("IT", "販売", "マーケティング", "人事" ,"研究開発" ,"その他" );
    }

    @ModelAttribute("titles")
    public List<String> titles() {
        return Arrays.asList("ディレクター" ,"マネージャー" ,"サブマネージャー" , "マネージャー補佐" ,"その他" );
    }

    @RequestMapping(value = "/" ,method = RequestMethod.GET )
    public String home(HttpSession httpSession, @ModelAttribute("employeeInfo") EmployeeInfo employeeInfo) {
        logger.info("start home method");
        logger.info("Session ID: " + httpSession.getId());
        logger.info("employeeInfo =[{}]", employeeInfo.toString());

        return "/input.html";
    }
}