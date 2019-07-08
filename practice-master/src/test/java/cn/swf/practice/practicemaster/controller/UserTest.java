package cn.swf.practice.practicemaster.controller;

import cn.swf.practice.practicemaster.ApplicationWebTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by 宋维飞
 * 2019/7/8 14:56
 */
public class UserTest extends ApplicationWebTest {


    @Test
    public void testUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/user/add").param("userName","李四").param("password","11")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }
}
