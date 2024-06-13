package e_commerce_application.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> getAddressById(Long addressId) {
        return addressRepository.findById(addressId);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long addressId, Address addressDetails) {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new IllegalArgumentException("Address not found for this id :: " + addressId));
        address.setUnitNo(addressDetails.getUnitNo());
        address.setStreetName(addressDetails.getStreetName());
        address.setLandmark(addressDetails.getLandmark());
        address.setPostalCode(addressDetails.getPostalCode());
        return addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}

