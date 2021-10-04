package com.example.testingwithboot.controller;

import com.example.testingwithboot.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerController controller;

    @Test
    public void findAllTest() throws Exception {
        Customer customer = new Customer();
        customer.setName("zura");
        List<Customer> list = Collections.singletonList(customer);
        when(controller.findALlCustomers()).thenReturn(list);
        mockMvc.perform(get("/v2")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(customer.getName())));
    }
    @Test
    public void findByNameTest() throws Exception {
        Customer customer = new Customer();
        customer.setName("zura");
        when(controller.findByName(customer.getName())).thenReturn(customer);
        mockMvc.perform(get("/v2/customers?name="+customer.getName())).andExpect(status().isOk())
                .andExpect(jsonPath("name", is(customer.getName())));
    }

}