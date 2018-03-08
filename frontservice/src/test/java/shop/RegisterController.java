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
public class RegisterController extends HttpServlet {
    @Autowired
    UserService userService;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int i = 0;
        String name = (String)req.getAttribute("name");
        String pwd = (String)req.getAttribute("password");
        Integer sex = (Integer)req.getAttribute("sex");
        Integer phone = (Integer)req.getAttribute("phone");
        String address = (String)req.getAttribute("address");
       /* if(userService.findName(name)==null){
            i = userService.regiest(name,pwd,sex,phone,address);
        }*/
        resp.getWriter().print("{\'code\':"+i+"}");
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
