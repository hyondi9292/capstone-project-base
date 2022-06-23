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
        String custStatus = "1";
        customer.setStatus(custStatus);
        System.out.println("#########Customer Service : Customer object#######"+customer);

        //DB저장
        customerRepository.save(customer);

        //이벤트 발행
        CustomerRegistered createcust = new CustomerRegistered();
        //이벤트 발행 값 셋팅
        createcust.setCustomerId(customerId);
        createcust.setStatus(custStatus);
        //이벤트발행
        createcust.publishAfterCommit();
    }


    //고객해지 (고객상태변경 : 1(정상) -> 9(해지) )
    public void deleteCustomer(String customerId) {
        System.out.println("#########Customer Service : Start Delete Customer#######");
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Customer customer = customerOptional.get();

        String custStatus = "9";
        customer.setStatus(custStatus);
        System.out.println("#########Delete Customer obj############"+customer);

        //변경된 고객 상태 DB저장
        customerRepository.save(customer);

        //이벤트 발행
        CustomerCancelled deletecust = new CustomerCancelled();
        //이벤트 발행 값 셋팅
        deletecust.setCustomerId(customerId);
        deletecust.setStatus(custStatus);
        //이벤트발행
        deletecust.publishAfterCommit();
    }

    //고객조회
    public Customer getCustomer(String customerId){
        
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
    