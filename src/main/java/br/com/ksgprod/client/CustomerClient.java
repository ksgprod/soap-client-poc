package br.com.ksgprod.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import br.com.ksgprod.controller.request.CustomerRequest;
import br.com.ksgprod.soap.wsdl.CustomerDetail;
import br.com.ksgprod.soap.wsdl.DeleteCustomerRequest;
import br.com.ksgprod.soap.wsdl.DeleteCustomerResponse;
import br.com.ksgprod.soap.wsdl.GetAllCustomerDetailRequest;
import br.com.ksgprod.soap.wsdl.GetAllCustomerDetailResponse;
import br.com.ksgprod.soap.wsdl.GetCustomerDetailRequest;
import br.com.ksgprod.soap.wsdl.GetCustomerDetailResponse;
import br.com.ksgprod.soap.wsdl.InsertCustomerRequest;
import br.com.ksgprod.soap.wsdl.InsertCustomerResponse;

public class CustomerClient extends WebServiceGatewaySupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerClient.class);

	private static final String GET_CUSTOMER_DETAIL_REQUEST = "/GetCustomerDetailRequest";
	private static final String GET_ALL_CUSTOMER_DETAIL_REQUEST = "/GetAllCustomerDetailRequest";
	private static final String INSERT_CUSTOMER_REQUEST = "/InsertCustomerRequest";
	private static final String DELETE_CUSTOMER_REQUEST = "/DeleteCustomerRequest";

	@Value("${default.uri.soap}")
	private String url;

	@Value("${ws.namespace.uri}")
	private String nameSpace;

	public GetCustomerDetailResponse getById(Integer id) {

		LOGGER.info("stage=init method=CustomerClient.getById id={}", id);

		GetCustomerDetailRequest request = new GetCustomerDetailRequest();

		request.setId(id);

		GetCustomerDetailResponse response = (GetCustomerDetailResponse) getWebServiceTemplate().marshalSendAndReceive(
				url, request, new SoapActionCallback(nameSpace.concat(GET_CUSTOMER_DETAIL_REQUEST)));

		LOGGER.info("stage=end method=CustomerClient.getById id={}", id);

		return response;
	}
	
	public InsertCustomerResponse insert(CustomerRequest request) {
		
		LOGGER.info("stage=init method=CustomerClient.insert request={}", request);
		
		InsertCustomerRequest insertCustomer = new InsertCustomerRequest();
		CustomerDetail detail = new CustomerDetail();
		
		detail.setId(request.getId());
		detail.setEmail(request.getEmail());
		detail.setName(request.getName());
		detail.setPhone(request.getPhone());
		insertCustomer.setCustomerDetail(detail);
		
		InsertCustomerResponse response = (InsertCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(
				url, insertCustomer, new SoapActionCallback(nameSpace.concat(INSERT_CUSTOMER_REQUEST)));
		
		LOGGER.info("stage=end method=CustomerClient.insert status={}", response.getStatus());
		
		return response;
	}
	
	public GetAllCustomerDetailResponse findAll() {
		
		LOGGER.info("stage=init method=CustomerClient.findAll");
		
		GetAllCustomerDetailResponse response = (GetAllCustomerDetailResponse) getWebServiceTemplate().marshalSendAndReceive(
				url, new GetAllCustomerDetailRequest(), new SoapActionCallback(nameSpace.concat(GET_ALL_CUSTOMER_DETAIL_REQUEST)));
		
		LOGGER.info("stage=end method=CustomerClient.findAll");
		
		return response;
	}
	
	public DeleteCustomerResponse delete(Integer id) {
		
		LOGGER.info("stage=init method=CustomerClient.delete id={}", id);
		
		DeleteCustomerRequest request = new DeleteCustomerRequest();
		
		request.setId(id);
		
		DeleteCustomerResponse response = (DeleteCustomerResponse) getWebServiceTemplate().marshalSendAndReceive(
				url, request, new SoapActionCallback(nameSpace.concat(DELETE_CUSTOMER_REQUEST)));
		
		LOGGER.info("stage=end method=CustomerClient.delete status={}");
		
		return response;
	}

}
