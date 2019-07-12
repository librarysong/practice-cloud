package cn.swf.practice.practicemaster.controller;

import cn.swf.practice.practicemaster.ApplicationWebTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by 宋维飞
 * 2019/7/12 9:33
 */
public class ValidateControllerTest extends ApplicationWebTest {

    @Test
    public void TestValidate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/validate").param("name","张三").param("age","20").param("address","beijing")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }
}
