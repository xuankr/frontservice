package shop;

import com.front.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by XKR on 2017/8/14.
 */
public class LoginController extends HttpServlet{
    @Autowired
    UserService userService;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int i = 0;
        String name = (String)req.getAttribute("name");
        String pwd = (String)req.getAttribute("password");
        if(req.getSession().getAttribute("name").equals(name))
        {
            i = 1;
        }else{
            i = userService.login(name,pwd);
            if(i == 1)
            {
                req.getSession().setAttribute("name",name);
            }
        }
        resp.getWriter().print("{\'code\':"+i+"}");
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
