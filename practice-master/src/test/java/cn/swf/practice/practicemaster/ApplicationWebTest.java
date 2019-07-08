package cn.swf.practice.practicemaster;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by 宋维飞
 * 2019/7/2 9:09
 */
public class ApplicationWebTest extends ApplicationTests {
    @Autowired
    private WebApplicationContext context;

    public MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
}
