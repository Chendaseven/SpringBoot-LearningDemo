package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * @Author Chenpeng
 * @Param  * @param null
 * @return 省略getter和setter
 */
@Component
public class BeanProperties {
    @Value("{Name}")
    private String name;
    @Value("{Date}")
    private String date;
}
