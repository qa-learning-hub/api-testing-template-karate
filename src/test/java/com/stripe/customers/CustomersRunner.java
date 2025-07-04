package com.stripe.customers;

import com.intuit.karate.junit5.Karate;

public class CustomersRunner {

    @Karate.Test
    Karate runGetCustomers() {
        return Karate.run("customers-get.feature").relativeTo(getClass());
    }
}
