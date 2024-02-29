package main.java.oneTomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private CustomerRepo repo;
    @Autowired
    private ProductRepo pRepo;

    @PostMapping("/insert")
    public Customer insert(@RequestBody OrderRequest request) {
        return repo.save(request.getCustomer());
    }

}