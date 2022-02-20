package io.github.lsj8367.demo.example.factorybean;

import io.github.lsj8367.demo.example.Message;
import org.springframework.beans.factory.FactoryBean;

public class MessageFactoryBean implements FactoryBean<Message> {

    private String text;

    // 책은 setter주입이지만 생성자 주입 사용
    public MessageFactoryBean(final String text) {
        this.text = text;
    }

    @Override
    public Message getObject() throws Exception {
        // 실제 빈으로 등록될 객체 인스턴스 생성

        return Message.newMessage(text);
    }

    @Override
    public Class<?> getObjectType() {
        return Message.class;
    }

    @Override
    public boolean isSingleton() {
        //여기서 만들어진 빈 오브젝트는 싱글턴으로 등록이 된다.
        return false;
    }

}
