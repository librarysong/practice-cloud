package cn.swf.practice.practicehystrix.controller;

import cn.swf.practice.practicehystrix.ApplicationWebTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by 宋维飞
 * 2019/7/2 9:08
 */
public class RedisTest extends ApplicationWebTest {

    @Test
    public void redisSaveTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/redis/save").param("name", "张三")
                .param("age", "11")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void redisGetTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/redis/get")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }
}
