package org.maktab.exceptionhandler;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class RepetitiveServiceException extends RuntimeException{

    public RepetitiveServiceException (String str)
    {

        super(str);
    }
}

