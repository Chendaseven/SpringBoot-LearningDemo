package FreemarkerTest.indexController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @Author Chenpeng
 * @Param  * @param null
 * @return
 */
@Controller
public class freeIndex {

    @RequestMapping("/freeindex")
    public String test() {
        return "index1";
    }
}
