package com.gyfty.promotions;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/26/15.
 */

// Error Codes Table

@ParseClassName("PromotionErrorCodes")
public class PromotionErrorCodes extends ParseObject{


    public String getErrorCode() {
        return getString(PromotionErrorCodesParams.errorCode.toString());
    }

    public void setErrorCode(String value) {
        put(PromotionErrorCodesParams.errorCode.toString(),value);
    }

    public String getErrorMessage() {
        return getString(PromotionErrorCodesParams.errorMessage.toString());
    }

    public void setErrorMessage(String value) {
        put(PromotionErrorCodesParams.errorMessage.toString(),value);
    }

    public enum PromotionErrorCodesParams {

        errorCode,
        errorMessage

    }

}
