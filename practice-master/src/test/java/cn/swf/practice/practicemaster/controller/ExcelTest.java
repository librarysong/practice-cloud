package cn.swf.practice.practicemaster.controller;

import cn.swf.practice.practicemaster.ApplicationWebTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by 宋维飞
 * 2019/10/20 13:34
 */
public class ExcelTest extends ApplicationWebTest {
    @Test
    public void testPerson() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/excel")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }
}
