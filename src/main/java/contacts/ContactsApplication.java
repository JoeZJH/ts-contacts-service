package contacts;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
@IntegrationComponentScan
public class ContactsApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ContactsApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
	SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	requestFactory.setConnectTimeout(3*1000);
	requestFactory.setReadTimeout(3*1000);
	return new RestTemplate(requestFactory);
        // return builder.build();
    }
}
