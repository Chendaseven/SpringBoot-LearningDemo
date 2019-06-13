package springbootlearning.demo2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BeanTest {

    @Autowired
    private BeanProperties beanProperties;

    @Test
    public void test(){
        Assert.assertEquals(beanProperties.getName(),"kobe");
        Assert.assertEquals(beanProperties.getTitle(),"SpringBoot学习");
    }
}
