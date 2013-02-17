package com.studentProfile.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();

		String url = request.getRequestURL().toString();
		String queryString = request.getQueryString();
		String excludePagesParam = request.getParameter("excludePages");
		LogMessage.log("Init param for excludePages:" + excludePagesParam);
		if (excludePagesParam != null) {
			String[] excludePages = excludePagesParam.split(",");
			checkPage(url, excludePages);
		}
		LogMessage.log("In LoginFilter " + req.getServerName()
				+ " page being accessed:" + url + "querystring:" + queryString);

		if ((session.getAttribute("student") == null)
				&& (session.getAttribute("admin") == null)) {
			response.sendRedirect("login.jsp");
		} else {

			chain.doFilter(req, resp);
		}

	}

	private boolean checkPage(String pageURL, String[] pages) {
		boolean found = false;
		LogMessage.log("pageURL is:" + pageURL);
		for (int i = 0; i < pages.length; i++) {
			LogMessage.log("page is: " + pages[i]);
			if (pages[i].equals(pageURL))
				found = true;
		}
		return found;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}