package com.xgq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:CommonController
 * Package: com.xgq.controller
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/23 18:00
 * @Version 1.0
 */
@Controller
@RequestMapping("/common")
public class CommonController {
    @RequestMapping("/permissionerror")
    public void permisserror(){

    }
}
