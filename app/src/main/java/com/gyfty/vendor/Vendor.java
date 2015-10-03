package com.gyfty.vendor;

import com.gyfty.support.Addresses;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Mac on 9/18/15.
 */

@ParseClassName("Vendor")
public class Vendor extends ParseObject {

    public String getVendorId() {
        return getString(VendorParams.vendorId.toString());
    }

    public void setVendorId(String value) {
        put(VendorParams.vendorId.toString(),value);
    }

    public String getName() {
        return getString(VendorParams.name.toString());
    }

    public void setName(String value) {
        put(VendorParams.name.toString(),value);
    }

    public String getBranch() {
        return getString(VendorParams.branch.toString());
    }

    public void setBranch(String value) {
        put(VendorParams.branch.toString(),value);
    }

    public String getPhoneNumber() {
        return getString(VendorParams.phoneNumber.toString());
    }

    public void setPhoneNumber(String value) {
        put(VendorParams.phoneNumber.toString(),value);
    }

    public String getBankName() {
        return getString(VendorParams.bankName.toString());
    }

    public void setBankName(String value) {
        put(VendorParams.bankName.toString(),value);
    }

    public String getBankAccountNumber() {
        return getString(VendorParams.bankAccountNumber.toString());
    }

    public void setBankAccountNumber(String value) {
        put(VendorParams.bankAccountNumber.toString(),value);
    }

    public String getBankIFSCCode() {
        return getString(VendorParams.bankIFSCCode.toString());
    }

    public void setBankIFSCCode(String value) {
        put(VendorParams.bankIFSCCode.toString(),value);
    }

    public String getEmailAddress() {
        return getString(VendorParams.emailAddress.toString());
    }

    public void setEmailAddress(String value) {
        put(VendorParams.emailAddress.toString(),value);
    }

    public Addresses getBranchAddress() {
        return (Addresses)getParseObject(VendorParams.branchAddress.toString());
    }

    public void setBranchAddress(Addresses value) {
        put(VendorParams.branchAddress.toString(),value);
    }

    public Addresses getBillingAddress() {
        return (Addresses)getParseObject(VendorParams.billingAddress.toString());
    }

    public void setBillingAddress(Addresses value) {
        put(VendorParams.billingAddress.toString(),value);
    }

    public Double getCommisionPercentage() {
        return getDouble(VendorParams.commisionPercentage.toString());
    }

    public void setCommisionPercentage(Double value) {
        put(VendorParams.commisionPercentage.toString(),value);
    }

    public String getLocale() {
        return getString(VendorParams.locale.toString());
    }

    public void setLocale(String value) {
        put(VendorParams.locale.toString(),value);
    }


    public enum VendorParams {
        vendorId,
        name,
        branch,
        emailAddress,
        phoneNumber,
        bankName,
        bankAccountNumber,
        bankIFSCCode,
        branchAddress,
        billingAddress,
        commisionPercentage,
        locale


    }
}
