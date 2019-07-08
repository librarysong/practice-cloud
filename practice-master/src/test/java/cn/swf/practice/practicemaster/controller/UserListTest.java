package cn.swf.practice.practicemaster.controller;

import cn.swf.practice.practicemaster.ApplicationWebTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by 宋维飞
 * 2019/7/8 15:36
 */
public class UserListTest extends ApplicationWebTest {


    @Test
    public void testPerson() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/user/list").param("type","person").param("userName","张三")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testMaster() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/user/list").param("type","master").param("userName","李四")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }

}
