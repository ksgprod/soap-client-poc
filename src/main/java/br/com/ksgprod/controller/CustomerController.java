package br.com.ksgprod.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ksgprod.client.CustomerClient;
import br.com.ksgprod.controller.request.CustomerRequest;
import br.com.ksgprod.controller.response.CustomerResponse;
import br.com.ksgprod.converter.CustomerListResponseConverter;
import br.com.ksgprod.converter.CustomerResponseConverter;
import br.com.ksgprod.soap.wsdl.DeleteCustomerResponse;
import br.com.ksgprod.soap.wsdl.GetAllCustomerDetailResponse;
import br.com.ksgprod.soap.wsdl.GetCustomerDetailResponse;
import br.com.ksgprod.soap.wsdl.InsertCustomerResponse;
import br.com.ksgprod.soap.wsdl.Status;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@SuppressWarnings("deprecation")
	public static final String APPLICATION_JSON = MediaType.APPLICATION_JSON_UTF8_VALUE;
	
	private CustomerResponseConverter responseConverter;
	
	private CustomerListResponseConverter responseListConverter;
	
	private CustomerClient client;
	
	public CustomerController(CustomerResponseConverter responseConverter, CustomerClient client, CustomerListResponseConverter responseListConverter) {
		this.responseConverter = responseConverter;
		this.responseListConverter = responseListConverter;
		this.client = client;
	}

	@GetMapping(value = "/{id}", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public CustomerResponse getById(@PathVariable(value = "id") Integer id) {

		GetCustomerDetailResponse customerDetailResponse = this.client.getById(id);

        return this.responseConverter.apply(customerDetailResponse);
    }
	
	@GetMapping(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public List<CustomerResponse> findAll() {
		
		GetAllCustomerDetailResponse responseList = this.client.findAll();
		
		return this.responseListConverter.apply(responseList);
	}
	
	@PostMapping(consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Status insert(@RequestBody CustomerRequest request) {
		
		InsertCustomerResponse insert = this.client.insert(request);
		
		return insert.getStatus();
	}
	
	@DeleteMapping(value = "/{id}", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Status delete(@PathVariable(value = "id") Integer id) {
		
		DeleteCustomerResponse delete = this.client.delete(id);
		
		return delete.getStatus();
	}

}
