package com.t.zero.common.exception;

import java.util.List;

public class TZeroException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -2620644530685349941L;

    private List<String> args;

    public TZeroException(String message, List<String> args) {
        super(message);
        this.args = args;
    }

    public TZeroException(String message, String arg) {
        super(message);
        this.args = List.of(arg);
    }

    public TZeroException(String message, String arg0, String args1) {
        super(message);
        this.args = List.of(arg0, args1);
    }

    public TZeroException(String message, String arg0, String args1, String args2) {
        super(message);
        this.args = List.of(arg0, args1, args2);
    }

    public TZeroException(String message, String arg0, String args1, String args2, String args3) {
        super(message);
        this.args = List.of(arg0, args1, args2, args3);
    }

    public TZeroException(String message, String arg0, String args1, String args2, String args3, String args4) {
        super(message);
        this.args = List.of(arg0, args1, args2, args3, args4);
    }

    public TZeroException(String message) {
        super(message);
        this.args = null;
    }

    public List<String> getArgs() {
        return this.args;
    }
}
