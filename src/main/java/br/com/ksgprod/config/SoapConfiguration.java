package br.com.ksgprod.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import br.com.ksgprod.client.CustomerClient;

@Configuration
public class SoapConfiguration {
	
	@Value("${context.path.soap}")
    private String contextPath;

    @Value("${default.uri.soap}")
    private String defaultUri;
    
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(contextPath);
        return marshaller;
    }

    @Bean
    public CustomerClient customerClientMarshaller(Jaxb2Marshaller marshaller) {
    	CustomerClient client = new CustomerClient();
        client.setDefaultUri(defaultUri);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
