package au.master.foundation.mc.master_bank.services;

import au.master.foundation.mc.master_bank.domain.Customer;
import au.master.foundation.mc.master_bank.repositories.CustomerRepository;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public final void testGetCustomer(){

        Customer customer = new Customer();
        customer.setFirstName("Someone");

        when(customerRepository.findById(anyInt())).thenReturn(java.util.Optional.of(customer));
        Customer customerResponse = customerService.getCustomer(anyInt());

        assertNotNull(customerResponse);
        assertEquals("Someone", customerResponse.getfirstName());
    }

    @Test
    public final void testGetCustomers(){

        Customer a = new Customer();
        List<Customer> customers = new ArrayList<>();
        customers.add(a);
        
        assertThat(customers, hasItem(a));
    }


}
