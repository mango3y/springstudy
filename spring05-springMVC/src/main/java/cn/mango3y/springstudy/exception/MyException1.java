package cn.mango3y.springstudy.exception;

public class MyException1 extends RuntimeException {
    public MyException1() {
    }

    public MyException1(String message) {
        super(message);
    }
}
