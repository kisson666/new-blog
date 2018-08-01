package filter;

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

import com.wang.model.User;

/**
 * Servlet Filter implementation class Filter1
 */
public class Filter1 implements Filter {

  /**
   * Default constructor.
   */
  public Filter1() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see Filter#destroy()
   */
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");
    if (user.i == 1) {
      chain.doFilter(request, response);
    } else {
      System.out.println("非管理员用户想进入管理员页面");
      session.setAttribute("info", "你没有访问管理员页面的权限");
      res.sendRedirect("../myblog.jsp");    //这样跳转，可以保证login页面和servlet的check在同一级目录
      //RequestDispatcher rd=request.getRequestDispatcher("../login.jsp");       若这样跳转页面，url不会变，所以login的表单提交到view/login，没有这个页面
      //rd.forward(request, response);
    }
  }

  /**
   * @see Filter#init(FilterConfig)
   */
  public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
  }

}
