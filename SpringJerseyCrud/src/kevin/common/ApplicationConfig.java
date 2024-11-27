package kevin.common;

import kevin.resource.CustomerResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.RequestContextFilter;

@Configuration
@ComponentScan({
        "kevin.resource"
})
public class ApplicationConfig extends ResourceConfig {
//    class ini untuk inisiasi aplikasi
    public ApplicationConfig() {
        register(RequestContextFilter.class);
        register(CustomerResource.class);
        register(CustomExceptionMapper.class);
    }
}
