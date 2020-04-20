package au.master.foundation.mc.master_bank.dto;

import au.master.foundation.mc.master_bank.domain.Account;
import au.master.foundation.mc.master_bank.domain.AccountSavings;
import au.master.foundation.mc.master_bank.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CustomerDTOImpl implements CustomerDTO {

    private static List<Customer> customers = new ArrayList<>();
    static int counter = 0;

    static {
        customers.add(new Customer(null, "Augusto Longo","guzzdev2020@gmail.com", "9999-9999"));
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer getCustomer(Integer id) {
        Customer tempCustomer = null;
        for(Customer customer:customers){
            if(customer.getId()==id){
                tempCustomer = customer;
                break;
            }
        }
        return tempCustomer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer saveCustomer = new Customer();
        saveCustomer.setId(++counter);
        saveCustomer.setFullName(customer.getFullName());
        saveCustomer.setEmail(customer.getEmail());
        saveCustomer.setPhone(customer.getPhone());

        customers.add(saveCustomer);
        return saveCustomer;
    }

    @Override
    public Customer updateCustomer(Integer id, Customer customer) {
        Customer updateCustomer=null;

        for(Customer employee:customers) {
            if(employee.getId()==id) {
                employee.setFullName(customer.getFullName());
                employee.setPhone(customer.getPhone());
                employee.setEmail(customer.getEmail());
                updateCustomer=customer;
                break;
            }
        }
        return updateCustomer;
    }

    @Override
    public Customer deleteCustomer(Integer id) {
        Customer deleteCustomer=null;
        Iterator<Customer> itr = customers.iterator();
        while(itr.hasNext()) {
            Customer customer=itr.next();
            if(customer.getId()==id) {
                deleteCustomer=customer;
                itr.remove();
            }
        }
        return deleteCustomer;
    }
}
