package com.ooad.demo.config;

import com.ooad.demo.dao.MenuDao;
import com.ooad.demo.entity.security.Menu;
import com.ooad.demo.entity.security.Role;
import com.ooad.demo.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @Author: 17Wang
 * @Date: 17:46 2018/12/5
 * Description:
 * 1.一开始注入了MenuService，MenuService的作用是用来查询数据库中url pattern和role的对应关系，查询结果是一个List集合，集合中是Menu类，Menu类有两个核心属性，一个是url pattern，即匹配规则(比如/admin/**)，还有一个是List,即这种规则的路径需要哪些角色才能访问。
 *
 * 2.我们可以从getAttributes(Object o)方法的参数o中提取出当前的请求url，然后将这个请求url和数据库中查询出来的所有url pattern一一对照，看符合哪一个url pattern，然后就获取到该url pattern所对应的角色，当然这个角色可能有多个，所以遍历角色，最后利用SecurityConfig.createList方法来创建一个角色集合。
 *
 * 3.第二步的操作中，涉及到一个优先级问题，比如我的地址是/employee/basic/hello,这个地址既能被/employee/**匹配，也能被/employee/basic/**匹配，这就要求我们从数据库查询的时候对数据进行排序，将/employee/basic/**类型的url pattern放在集合的前面去比较。
 *
 * 4.如果getAttributes(Object o)方法返回null的话，意味着当前这个请求不需要任何角色就能访问，甚至不需要登录。但是在我的整个业务中，并不存在这样的请求，我这里的要求是，所有未匹配到的路径，都是认证(登录)后可访问，因此我在这里返回一个ROLE_LOGIN的角色，这种角色在我的角色数据库中并不存在，因此我将在下一步的角色比对过程中特殊处理这种角色。
 *
 * 5.如果地址是/login_p，这个是登录页，不需要任何角色即可访问，直接返回null。
 *
 * 6.getAttributes(Object o)方法返回的集合最终会来到AccessDecisionManager类中，接下来我们再来看AccessDecisionManager类。
 */
@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuDao menuDao;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //这个if判断怕是有点问题...
        if ("/users/login".equals(requestUrl)) {
            return null;
        }
        List<Menu> menus = menuDao.listAll();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl) && menu.getRoles().size() > 0) {
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
