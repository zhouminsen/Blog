package org.java.deal.baseController.forground;

import javax.annotation.Resource;

import org.java.base.common.controller.BaseController;
import org.java.deal.blog.service.BlogTypeService;
import org.springframework.stereotype.Controller;

@Controller
public class BlogTypeController extends BaseController{
	
	@Resource
	private BlogTypeService blogTypeService;
	
}