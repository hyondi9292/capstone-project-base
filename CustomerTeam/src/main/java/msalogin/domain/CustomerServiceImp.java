package msalogin.domain;

import msalogin.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    // 고객신규  (String customerId, String address, String telNo, String name, String juminNo);
    public void createCustomer(String customerId, String address, String telNo, String name, String juminNo) {
        System.out.println("#########Customer Service : Start Register Customer#######");
        Customer customer = new Customer();

        //입력정보 셋팅
        customer.setCustomerId(customerId);
        customer.setAddress(address);
        customer.setTelNo(telNo);
        customer.setName(name);
        customer.setTelNo(juminNo);
        customer.setStatus("1");
        System.out.println("#########Customer Service : Customer object#######"+customer);

        //DB저장
        customerRepository.save(customer);

        //이벤트 발행
        CustomerRegistered createcust = new CustomerRegistered();
        //이벤트 발행 값 셋팅
        createcust.setCustomerId(customerId);
        createcust.setStatus("1");
        //이벤트발행
        createcust.publishAfterCommit();
    }


    public void deleteCustomer(String customerId) {

    }

    public Customer getCustomer(String customerId){
        //Long id = Long.parseLong(customerId);
        System.out.println("#########Customer Service : Start Get Customer#######");
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        System.out.println("#########Get Customer obj############"+customerOptional);
        Customer customer = customerOptional.get();

        return customer;
    }


    public Customer save(String data){
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = null;
        try {
            customer = mapper.readValue(data, Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /*
        List<CustomerOption> customerOptions = customer.getCustomerOptions();
        for(CustomerOption c : customerOptions){
            c.setCustomerId(customer);
        }
        
         */
        return customerRepository.save(customer);

    }

}
    