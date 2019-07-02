package cn.swf.practice.practicehystrix;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 宋维飞
 * 2019/7/2 9:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PracticeHystrixApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ApplicationTests {

}
