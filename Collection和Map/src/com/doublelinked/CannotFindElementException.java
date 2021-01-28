package com.doublelinked;

/**
 * @author fmk
 * @date 2020/5/7
 **/
public class CannotFindElementException extends Exception {
    public CannotFindElementException(String message) {
        super(message);
    }

    public CannotFindElementException() {
    }
}
