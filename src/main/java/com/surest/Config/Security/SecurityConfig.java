package com.surest.Config.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by pachevjoseph on 4/21/16.
 */
public class SecurityConfig {
    //// TODO: 4/21/16  Add Better security configuration to follow best practices
    @Configuration
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        public void configure(WebSecurity web) throws Exception {
             web.ignoring().antMatchers("/**");
        }
    }
}
