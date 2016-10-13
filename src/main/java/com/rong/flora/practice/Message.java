package com.rong.flora.practice;


import static com.rong.flora.practice.Constants.*;

/**
 * Created by lafengnan on 16/9/7.
 */
public class Message {
    private long id;
    private String content;
    private Byte sendChannel;
    private static long cnt;

    static {
        cnt = 0;
    }

    private Message(long id, final String content, Byte sendChannel) {
        this.id = id;
        this.content = content;
        this.sendChannel = sendChannel;
        int len = Integer.toBinaryString(sendChannel).length();
        String padding = "";
        for (int i = 0; i < 8 - len; i++) {
            padding += 0;
        }
        System.out.println("sendChannel: " + padding + Integer.toBinaryString(sendChannel));
    }

    public static Message newMessage(String content, Byte sendChannel) {
       return new Message(cnt++, content, sendChannel);
    }

    public Boolean sendMessage(String mobileId, String phoneNumber, String weChatId, String email) {
        for(int i = 0; i < 4; i++){
            switch (sendChannel & (1 << i)) {
                case 1:
                    sendMessageViaEmail(email);
                    break;
                case 2:
                    sendMessageViaWeChat(weChatId);
                    break;
                case 4:
                    sendMessageViaSMS(mobileId);
                    break;
                case 8:
                    sendMessageViaPhone(phoneNumber);
                    break;
            }
        }
       return true;
    }

    private Boolean sendMessageViaSMS(String mobileId) {
        System.out.println("send message: " + content + " via SMS");
        return true;
    }

    private Boolean sendMessageViaWeChat(String weChatId) {
        System.out.println("send message: " + content + " via WeChat");
        return true;
    }

    private Boolean sendMessageViaEmail(String email) {
        System.out.println("send message: " + content + " via email");
        return true;
    }

    private Boolean sendMessageViaPhone(String phoneNumber) {
        System.out.println("send message: " + content + " via phone call");
        return true;
    }

    public static void main(String[] args){
        Message message = Message.newMessage("kiko", Byte.valueOf(("7")));
        message.sendMessage("1","2","3","4");
        Integer a = 127;
        Integer b = 127;
        Integer c = 10;
        Integer d = 10;

        {
            Integer o = 1;
        }
        System.out.println(a == b);
        System.out.println(c == d);

        class Person {
            private String name;
            Integer age;

            public String getName() {
                return name;
            }

            public void setName(Person this, String name) {
                this.name = name;
            }

            public Integer getAge() {
                return age;
            }

            public void setAge(Integer age) {
                this.age = age;
            }
        }

        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        p1.setName("123");
        p2.setName("123");
        p3.setName("123");


    }

    enum CHANNEL {
        EMAIL(1), WECHAT(2), MOBILE(4), SMS(8);
        private Integer v;
        private CHANNEL(Integer v) {
            this.v = v;
        }
        public Integer getV(){
            return this.v;
        }
    }
}
