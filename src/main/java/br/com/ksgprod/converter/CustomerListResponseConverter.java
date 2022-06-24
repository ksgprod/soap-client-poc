package br.com.ksgprod.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import br.com.ksgprod.controller.response.CustomerResponse;
import br.com.ksgprod.soap.wsdl.GetAllCustomerDetailResponse;

@Component
public class CustomerListResponseConverter implements Function<GetAllCustomerDetailResponse, List<CustomerResponse>>{

	@Override
	public List<CustomerResponse> apply(GetAllCustomerDetailResponse detailResponse) {
		
		if(Objects.isNull(detailResponse)) return null;
		
		List<CustomerResponse> responseList = new ArrayList<>();
		
		detailResponse.getCustomerDetail().forEach(detail -> {
			
			CustomerResponse response = new CustomerResponse();
			
			response.setId(detail.getId());
			response.setEmail(detail.getEmail());
			response.setName(detail.getName());
			response.setPhone(detail.getPhone());
			
			responseList.add(response);
		});
		
		return responseList;
	}

}
