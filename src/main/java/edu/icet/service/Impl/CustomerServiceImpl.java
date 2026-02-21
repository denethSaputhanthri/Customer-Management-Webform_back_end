package edu.icet.service.Impl;

import lombok.RequiredArgsConstructor;
import edu.icet.model.dto.CustomerDto;
import edu.icet.model.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final private CustomerRepository repository;
    final private ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDto customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void updateCustomer(CustomerDto customer) {
        repository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        repository.deleteById(customerId);
    }

    @Override
    public CustomerDto searchById(Integer customerId) {
        return mapper.map(repository.findById(customerId).get(),CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAll() {
        List<CustomerEntity>entities=repository.findAll();
        ArrayList<CustomerDto>customerDtoArrayList=new ArrayList<>();
        entities.forEach(customerEntity -> {
            customerDtoArrayList.add(mapper.map(customerEntity,CustomerDto.class));
        });
        return customerDtoArrayList;
    }
}
