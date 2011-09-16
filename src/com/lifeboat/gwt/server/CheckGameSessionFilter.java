package com.lifeboat.gwt.server;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Twin
 * @version 1.0
 * @since 04.09.11
 */
public class CheckGameSessionFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        final String playerId = Util.getPlayerId(session);
        if (!StringUtils.isEmpty(playerId) && ActiveGames.isValidPlayer(playerId)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_FORBIDDEN);
    }

    public void destroy() {
    }
}
