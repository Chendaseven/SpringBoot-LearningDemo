package MybatisApp.Controller;

import MybatisApp.Service.mybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sqlController {

    @Autowired
    private mybatisService mybatisService;

    @RequestMapping("/mybatisTest")
    @ResponseBody
    public Integer sqlTest(String name,int age){
        Integer test = mybatisService.test(name,age);
        return test;
    }

}
