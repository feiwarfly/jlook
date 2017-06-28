package com.crowd.web.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by luis on 2017/6/29.
 */
@FeignClient("apiuser")
public interface UserClient {

    @RequestMapping(value="index", method= RequestMethod.GET)
    public String getIndex();
}
