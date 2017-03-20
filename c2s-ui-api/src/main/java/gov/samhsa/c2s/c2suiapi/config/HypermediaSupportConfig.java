package gov.samhsa.c2s.c2suiapi.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@Configuration
public class HypermediaSupportConfig {
    private static final String SPRING_HATEOAS_OBJECT_MAPPER = "_halObjectMapper";

    @Autowired
    @Qualifier(SPRING_HATEOAS_OBJECT_MAPPER)
    private ObjectMapper springHateoasObjectMapper;

    @Bean(name = "objectMapper")
    ObjectMapper objectMapper() {
        springHateoasObjectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        springHateoasObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        springHateoasObjectMapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        springHateoasObjectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        springHateoasObjectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        springHateoasObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        springHateoasObjectMapper.registerModules(new JavaTimeModule());
        return springHateoasObjectMapper;
    }
}