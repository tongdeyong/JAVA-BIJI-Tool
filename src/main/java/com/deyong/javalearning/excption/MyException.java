package com.deyong.javalearning.excption;

/**
 * 异常类
 *
 * @author dytong 童德勇 2019/3/29 13:57
 * @version 1.0
 * @since 1.0
 */
public class MyException extends Exception{

    /**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String message) {
        super(message);
    }
}
