package com.hermes.domain.hauls;

/**
 *  02.10.15.
 */
public class HaulBuilder {

    private HaulBuilder() {
    }

    public static HaulBuilder newHaulBuilder(){
        return new HaulBuilder();
    }
}
