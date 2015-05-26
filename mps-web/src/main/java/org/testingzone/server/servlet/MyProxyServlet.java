package org.testingzone.server.servlet;

import javax.servlet.ServletConfig;

public class MyProxyServlet extends ProxyServlet {

    @Override
    public void init(ServletConfig servletConfig) {
        setFollowRedirects(true);
        setRemovePrefix(false);
        setProxyPort(8080);
    }
}
