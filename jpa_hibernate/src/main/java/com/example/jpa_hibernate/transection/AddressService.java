package com.example.jpa_hibernate.transection;

import com.example.jpa_hibernate.MySqlConnect.Address;
import com.example.jpa_hibernate.MySqlConnect.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addrRepo;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWithRequired(Address addr) {
        addrRepo.save(addr);
        if ("FAIL".equals(addr.getCity())) {
            throw new RuntimeException("Forced failure in Address");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveWithRequiresNew(Address addr) {
        addrRepo.save(addr);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void saveWithNested(Address addr) {
        addrRepo.save(addr);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveWithSupports(Address addr) {
        addrRepo.save(addr);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void saveWithNever(Address addr) {
        addrRepo.save(addr);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void saveWithNotSupported(Address addr) {
        addrRepo.save(addr);
    }

}
