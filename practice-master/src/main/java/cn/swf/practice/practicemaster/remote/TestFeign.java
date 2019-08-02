package cn.swf.practice.practicemaster.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 宋维飞
 * 2019/8/1 16:55
 */
@FeignClient(name = "practice-product")
public interface TestFeign {

    @RequestMapping(value = "practice-product/hello")
    String hello(@RequestParam(value = "name") String name);
}
