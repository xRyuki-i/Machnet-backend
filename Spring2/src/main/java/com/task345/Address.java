package com.task345;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class Address {
    @Value("${address.address_id}")
    private String addressId;
    @Value("${address.address_name}")
    private String addressName;

    public void displayAddressInfo() {
        System.out.println("Address Id: " + addressId);
        System.out.println("Address: " + addressName);
    }
}
