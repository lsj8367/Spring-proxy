package io.github.lsj8367.demo.example.factorybean;

import static org.assertj.core.api.Assertions.assertThat;
import io.github.lsj8367.demo.example.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class MessageFactoryBeanTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    void test() {
        Object object = ctx.getBean("messageFactoryBean");

        assertThat(object).isInstanceOf(Message.class);
        assertThat(((Message)object).getText()).isEqualTo("test");
    }

}