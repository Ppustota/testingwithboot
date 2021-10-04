package com.example.testingwithboot.service;

import com.example.testingwithboot.model.Customer;
import com.example.testingwithboot.repo.CustomerRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CustomerServiceTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepo customerRepo;

    @Test
    public void findAllTest() throws Exception{
        Customer customer = new Customer();
        customer.setName("zura");
        entityManager.persist(customer);
        entityManager.flush();
        Customer secondCustomer = new Customer();
        customer.setName("luka");
        entityManager.persist(secondCustomer);
        entityManager.flush();
        List<Customer> list  = customerRepo.findAll();
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(1)).isEqualTo(customer);
        assertThat(list.get(2)).isEqualTo(secondCustomer);
    }
    @Test
    public void findByNameTest() throws Exception{
        Customer customer = new Customer();
        customer.setName("zura");
        entityManager.persist(customer);
        entityManager.flush();
        Customer byName = customerRepo.findByName(customer.getName());
        assertThat(byName.getName()).isEqualTo(customer.getName());
    }
}