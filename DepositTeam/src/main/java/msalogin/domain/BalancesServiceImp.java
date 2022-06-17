package msalogin.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BalancesServiceImp implements BalanceService {

    @Autowired
    BalanceRepository balanceRepository;

    public void increasedBalance(Long accountNo, int money) {

        /**
         * 계좌 잔액을 감소시킨다.
         */
        List<Balance> balanceOptional = balanceRepository.findByaccountNo(accountNo);
        Balance balance = balanceOptional.get();
        balance.setaccountBal(balance.getaccountBal() - money);

        balanceRepository.save(balance);

    }

    public void increaseStock(Long productId, int quantity) {
        /**
         * 주문 취소시, 수량을 늘인다
         */
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = productOptional.get();
        product.setStock(product.getStock() + quantity);

        productRepository.save(product);
    }

    /**
     * 상품 조회
     */
    public Product getProductById(Long id){

        Optional<Product> productOptional = productRepository.findById(id);
        Product product = productOptional.get();

        return product;
    }

    public Product save(String data){
        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        try {
            product = mapper.readValue(data, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<ProductOption> productOptions = product.getProductOptions();
        for(ProductOption p : productOptions){
            p.setProduct(product);
        }

        return productRepository.save(product);
    }
}
