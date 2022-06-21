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

    //고객신규
    public void createCustomer(String customerId, String Address, String Telno, String Name, String JuminNo) {
        System.out.println("#########고객등록시작#######");
        Customer customer = new Customer();

        //입력정보 셋팅
        customer.setCustomerId(customerId);
        customer.setAddress(Address);
        customer.setTelno(Telno);
        customer.setName(Name);
        customer.setJumin_no(JuminNo);
        customer.setStatus("1");
        System.out.println("#########customer#######"+customer);
        customerRepository.save(customer);

        //이벤트 발행
        CustomerRegistered createcust = new CustomerRegistered();
        //이벤트 발행 값 셋팅
        createcust.setCustomerId(customerId);
        createcust.setStatus("1");
        //이벤트발행
        createcust.publishAfterCommit();
    }


    //고객해지
    public void deleteCustomer(String customerId) {
        System.out.println("#########Start Delete#######");
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        System.out.println("#########balanceOptional#######"+customerOptional);
        Customer customer = customerOptional.get();
        customerRepository.delete(customer);

        //이벤트 발행
        CustomerCancelled deletecust = new CustomerCancelled();
        //이벤트 발행 값 셋팅
        deletecust.setCustomerId(customerId);
        deletecust.setStatus("9");
        //이벤트발행
        deletecust.publishAfterCommit();
    }

    public Customer getCustomer(String customerId){
        //Long id = Long.parseLong(customerId);
        System.out.println("#########CustomerServiceImp#######"+customerId);
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        System.out.println("#########balanceOptional#######"+customerOptional);
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
        List<BalanceOption> balanceOptions = balance.getBalanceOptions();
        for(BalanceOption b : balanceOptions){
            b.setBalance(balance);
        }
        */

        return customerRepository.save(customer);
    }

}
    