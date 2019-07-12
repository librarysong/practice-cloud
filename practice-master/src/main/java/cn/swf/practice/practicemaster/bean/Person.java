package cn.swf.practice.practicemaster.bean;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Created by 宋维飞
 * 2019/7/12 9:07
 */
@Data
public class Person {

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "年龄不能为空")
    @Min(value = 18, message = "年龄不能小于18")
    private String age;

    @NotEmpty(message = "地址不能为空")
    private String address;
}
