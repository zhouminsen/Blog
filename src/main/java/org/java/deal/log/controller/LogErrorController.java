package org.java.deal.log.controller;

import javax.annotation.Resource;

import org.java.base.common.controller.BaseController;
import org.java.deal.log.service.LogErrorService;
import org.springframework.stereotype.Controller;

@Controller
public class LogErrorController extends BaseController{
	
	@Resource
	private LogErrorService logErrorService;
	
}