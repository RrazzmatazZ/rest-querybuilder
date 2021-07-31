package com.dreamtail.querybuilder.examples;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author xdq
 * @version 1.0
 * @className User
 * @description TODO
 * @date 2021/7/2 14:07
 */
@Data
public class User {
    @Field("name")
    String name;
    String sex;
    Integer age;
    String city;
}
