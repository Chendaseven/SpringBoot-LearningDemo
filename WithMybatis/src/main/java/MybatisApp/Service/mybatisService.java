package MybatisApp.Service;

import MybatisApp.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mybatisService {
    @Autowired
    private UserMapper userMapper;

    public Integer test(String name, int age) {
        int result = userMapper.insert(name, age);
        return result;
    }
}
