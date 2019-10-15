package springbootlearning.Chapter3Test;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import springbootlearning.demo2.Chapter3.RESTfulTest;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class UserTest {
    private MockMvc mvc;

    //
//    @Autowired
//    private RESTfulTest resTfulTest;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new RESTfulTest()).build();
    }

    @Test
    public void testUserController() throws Exception {
        // 测试UserController
        RequestBuilder request = null;

        // 1、get查一下user列表，应该为空
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[]")));

        // 2、post提交一个user
        request = MockMvcRequestBuilders.post("/users/")
                .param("id", "1")
                .param("name", "测试大师")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(equalTo("success")));

        // 3、get获取user列表，应该有刚才插入的数据
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")))
                .andDo(MockMvcResultHandlers.print());

        // 4、put修改id为1的user
        request = MockMvcRequestBuilders.put("/users/1")
                .param("name", "测试终极大师")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(equalTo("success")))
                .andDo(MockMvcResultHandlers.print());

        // 5、get一个id为1的user
//        request = MockMvcRequestBuilders.get("/users/1");
//        mvc.perform(request)
//                .andExpect(MockMvcResultMatchers.content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")))
//                .andDo(MockMvcResultHandlers.print());

        ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/users/1"));
        MvcResult mvcResult = perform.andExpect(MockMvcResultMatchers.content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();                 //得到返回结果状态
        String content = mvcResult.getResponse().getContentAsString();    //得到返回结果，内容
        System.out.println(status);
        System.out.println(content);

        // 6、del删除id为1的user
        request = MockMvcRequestBuilders.delete("/users/1");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[]")));

    }
}
