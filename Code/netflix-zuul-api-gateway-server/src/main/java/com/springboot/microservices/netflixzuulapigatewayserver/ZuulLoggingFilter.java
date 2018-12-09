package com.springboot.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
			
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = 
				RequestContext.getCurrentContext().getRequest();
		LOGGER.info("************************* request -> {}", request);
		LOGGER.info("*************************  request URI -> {}", request.getRequestURI());
		return null;
	}

	@Override
	/*
	 * This method will decide whether this Filter(ZuulLoggingFilter) needs to excute or Not.
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	public boolean shouldFilter() {
		return true;
	}

	@Override
	/*
	 * If We have More than one filter like ZuulLoggingFilter,ZuulFilterr and ....more
	 * and if we want to set priority that which filter need to call first we can 
	 * set priority of filter via this method.
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 */
	public int filterOrder() {
		return 1;
	}

	@Override
	/*
	 * This will indicate when should be filtering happen means filter is happening before request is executed(pre)
	 * or after the request is happen (post) or we want to filter only error request that cause exception
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 * I
	 */
	public String filterType() {
		return "pre";
	}

}
