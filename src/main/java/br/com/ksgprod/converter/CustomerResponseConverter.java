package br.com.ksgprod.converter;

import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.ksgprod.controller.response.CustomerResponse;
import br.com.ksgprod.soap.wsdl.GetCustomerDetailResponse;

@Component
public class CustomerResponseConverter implements Function<GetCustomerDetailResponse, CustomerResponse>{

	@Override
	public CustomerResponse apply(GetCustomerDetailResponse detailResponse) {
		
		if(Objects.isNull(detailResponse)) return null;
		
		CustomerResponse response = new CustomerResponse();
		
		response.setId(detailResponse.getCustomerDetail().getId());
		response.setEmail(detailResponse.getCustomerDetail().getEmail());
		response.setName(detailResponse.getCustomerDetail().getName());
		response.setPhone(detailResponse.getCustomerDetail().getPhone());
		
		return response;
	}

}
