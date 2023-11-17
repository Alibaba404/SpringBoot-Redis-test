package cn.aikuiba;

import cn.aikuiba.entity.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by 蛮小满Sama at 2023/11/17 14:39
 *
 * @description
 */
@SpringBootTest
class AikuibaApplicationTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("dog", new Dog(1L, "蛮吉", Boolean.TRUE));
    }

    @Test
    public void test2() throws InterruptedException {
        // 设置过期时间
        redisTemplate.opsForValue().set("ip", "127.0.0.1", 10, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("ip"));
        Thread.sleep(10 * 1000);
        System.out.println(redisTemplate.opsForValue().get("ip"));
    }

    @Test
    public void test3() {
        System.out.println(redisTemplate.opsForList().size("names"));
        redisTemplate.opsForList().leftPushAll("ips", "127.0.0.1", "172.168.30.254");
    }

}
