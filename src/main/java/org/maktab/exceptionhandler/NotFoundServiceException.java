package org.maktab.exceptionhandler;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundServiceException extends RuntimeException{

    public NotFoundServiceException (String str)
    {

        super(str);
    }
}
