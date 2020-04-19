package au.master.foundation.mc.master_bank.dto;

import au.master.foundation.mc.master_bank.domain.Customer;

import java.util.List;

public interface CustomerDTO {

    public List<Customer> getCustomers();
    public Customer getCustomer(Integer id);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Integer id, Customer customer);
    public Customer deleteCustomer(Integer id);
}
