//package com.abc.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Component
//public class ProviderImpl {
//
//        private final static String TOPIC_NAME = "my-replicated-topic";
//
//        @Autowired
//        private KafkaTemplate<String, String> kafkaTemplate;
//
//        @RequestMapping("/send")
//        public String send(@RequestParam("msg") String msg) {
//            kafkaTemplate.send(TOPIC_NAME, "key", msg);
//            return String.format("消息 %s 发送成功！", msg);
//        }
//    }
//
//
//
