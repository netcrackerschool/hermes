package com.hermes.domain.places;

/**
 *  02.10.15.
 */
public interface PlaceFactory {
    BasicCompanyBase createBasicCompanyBase(String name);

    BasicClientBase createBasicClientBase(String name);

    BasicFix createBasicFix(String name);
}
