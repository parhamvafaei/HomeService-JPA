package org.maktab.util;

import static org.maktab.entity.Service.getServices;

public class Util {

    public static Boolean isContain(String name){
        for (int i=0 ; i<= getServices().length;i++) {
            if(getServices()[i].toString().equals(name))
                return true;
        }

        return false;
    }
}
