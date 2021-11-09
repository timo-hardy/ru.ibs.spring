package ru.ibs.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ibs.spring.service.DieselEngineImpl;
import ru.ibs.spring.service.Engine;
import ru.ibs.spring.service.PetrolEngineImpl;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EngineConfig {
    @Bean
    public Map<String, Engine> mapService () {
        Map<String, Engine> engineMap = new HashMap<>();
        engineMap.put("petrol", new PetrolEngineImpl());
        engineMap.put("diesel", new DieselEngineImpl());

        return engineMap;
    }

}
}
