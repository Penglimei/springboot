package com.plm.config;

import com.plm.pojo.User;
import com.plm.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权 doGetAuthorizationInfo");

        // 当前用户
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        // 用于记录当前用户已有的授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 当前用户的权限
        info.addStringPermission(currentUser.getPerms());
        // 将当前用户的已有权限与当前用户要访问页面所需的权限对比
        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证 doGetAuthenticationInfo");
        // 数据库中认证用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 用户名认证
        User user = userService.queryUserByName(token.getUsername());
        System.out.println(user);
        if(user == null){
            return null;
        }
        // 密码认证，shiro自行处理，加密了
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
