package org.maktab.entity;


public enum Service {

    DECORATION, FACILITIES, VEHICLES, CARRYING, HOUSEHOLD_APPLIANCES, CLEANING;

  public static Service[] getServices(){
        return Service.values();
    }
}
