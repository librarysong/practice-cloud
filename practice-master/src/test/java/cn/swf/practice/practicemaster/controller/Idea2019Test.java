package cn.swf.practice.practicemaster.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weifei.song
 * @date 2019/10/27 20:38
 */
@RestController
@Slf4j
@Deprecated
public class Idea2019Test {

    private static int age;

    public void testFastKey() {
        //CTRT+ALT+M重构方法
        numAdd();
        // ctrl+alt+l
        // ctrl+alt+o
        //ctrl+shift+up、down
        //ctrl+f12
        //alt+enter
        //alt+insert
        //ctrl+d  ctrl+y
        //ctrl+shift+f
        //ctrl+shift+n
        //shift+shift
    }

    private int numAdd() {
        int a = 3;
        int b = 4;
        return a + b;
    }
}
