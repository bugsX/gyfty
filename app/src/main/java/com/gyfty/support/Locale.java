package com.gyfty.support;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

/**
 * Created by Mac on 10/5/15.
 */

// Locale table stores the different cities that gyfty operates in along with the city's coordinates

@ParseClassName("Locale")
public class Locale extends ParseObject {

    public String getLocaleName() {
        return getString(LocaleParams.localeName.toString());
    }

    public void setLocaleName(String value) {
        put(LocaleParams.localeName.toString(), value);
    }

    public ParseGeoPoint getLocaleCoordinates() {
        return getParseGeoPoint(LocaleParams.localeCoordinates.toString());
    }

    public void setLocaleCoordinates(ParseGeoPoint value) {
        put(LocaleParams.localeCoordinates.toString(), value);
    }

    public enum LocaleParams {

        localeName,
        localeCoordinates // ParseGeoPoint

    }

}
