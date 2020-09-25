package com.wondernect.demo.stars.demo.context;

import com.wondernect.elements.authorize.context.impl.AbstractWondernectAuthorizeContext;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2017-2019, wondernect.com
 * FileName: UserAuthorizeContext
 * Author: chenxun
 * Date: 2019/4/4 11:40
 * Description:
 */
@Component
public class AuthorizeUserRoleContext extends AbstractWondernectAuthorizeContext {

    @Override
    public boolean authorizeAppSecret(String appId, String encryptSecret) {
        return true;
    }
}
