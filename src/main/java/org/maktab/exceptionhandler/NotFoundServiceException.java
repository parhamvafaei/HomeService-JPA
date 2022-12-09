package org.maktab.exceptionhandler;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundServiceException extends Exception{

    public NotFoundServiceException (String str)
    {

        super(str);
    }
}
