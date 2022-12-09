package org.maktab.exceptionhandler;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class RepetitiveServiceException extends Exception{

    public RepetitiveServiceException (String str)
    {

        super(str);
    }
}

