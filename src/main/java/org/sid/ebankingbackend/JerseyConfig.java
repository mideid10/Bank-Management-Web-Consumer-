package org.sid.ebankingbackend;

import org.glassfish.jersey.server.ResourceConfig;
import org.sid.ebankingbackend.resources.BankAccountResource;
import org.sid.ebankingbackend.resources.CustomerResource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

        public JerseyConfig(){
            register(CustomerResource.class);
            register(BankAccountResource.class);
            register(CorsFilter.class);

        }
    }

