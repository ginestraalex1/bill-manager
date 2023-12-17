package Tydek.billmanager.controllers;

import Tydek.billmanager.domains.customerFofolder.CustomerFolder;
import Tydek.billmanager.services.CustomerFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer-folder")
public class CustomerFolderController {

    @Autowired
    private CustomerFolderService customerFolderService;

    @PostMapping()
    public ResponseEntity<CustomerFolder> createCustomerFolder() {
        return ResponseEntity.ok(customerFolderService.createCustomerFolder());
    }

    @GetMapping()
    public ResponseEntity<List<CustomerFolder>> getAllCustomerFolders() {
        return ResponseEntity.ok(customerFolderService.getAllCustomerFolders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerFolder> getCustomerFolder(@PathVariable long id) {
        return ResponseEntity.ok(customerFolderService.getCustomerFolder(id));
    }

    @GetMapping("/test")
    public ResponseEntity<String> testSlash() {
        return ResponseEntity.ok().body("testOk/");
    }
}
