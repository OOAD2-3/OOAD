package com.ooad.demo.config;

import com.ooad.demo.security.*;
import com.ooad.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: 17Wang
 * @Date: 16:01 2018/12/5
 * Description:
 * 1.在configure(HttpSecurity http)方法中，通过withObjectPostProcessor将刚刚创建的UrlFilterInvocationSecurityMetadataSource和UrlAccessDecisionManager注入进来。到时候，请求都会经过刚才的过滤器（除了configure(WebSecurity web)方法忽略的请求）。
 *
 * 2.successHandler中配置登录成功时返回的JSON，登录成功时返回当前用户的信息。
 *
 * 3.failureHandler表示登录失败，登录失败的原因可能有多种，我们根据不同的异常输出不同的错误提示即可。
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;
    @Autowired
    UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;

    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;
    @Autowired
    AuthenticationAccessSuccessHandler authenticationAccessSuccessHandler;
    @Autowired
    AuthenticationAccessFailureHandler authenticationAccessFailureHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //下面这个语句有问题
        web.ignoring().antMatchers("/index.html", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin().loginPage("/login_p").loginProcessingUrl("/users/login")
                .usernameParameter("username").passwordParameter("password")
                .failureHandler(authenticationAccessFailureHandler)
                .successHandler(authenticationAccessSuccessHandler)
                .permitAll()
                .and()
                .logout().permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);*/

        http.authorizeRequests()
                .antMatchers("/**/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .csrf().disable();
    }


}