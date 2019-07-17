package MybatisApp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "MybatisApp.Mapper")
public class MybatisAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisAppApplication.class, args);
    }

}
