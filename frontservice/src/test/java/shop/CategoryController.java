package shop;

import com.front.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by XKR on 2017/8/15.
 */
public class CategoryController extends HttpServlet {
    @Autowired
    CategoryService service;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<HashMap<String,String>> list = service.list();
        String json = "[";
            for(int i = 0;i<list.size();i++){
                json+="{";
                json+="\'id\':"+list.get(i).get("id")+ "\'name\':"+list.get(i).get("name")+ "\'flag\':"+list.get(i).get("flag");
                json+="}";
                if(i == (list.size()-2)){
                    json+=",";
                }
            }
        json += "]";
        resp.getWriter().print("{\'code\':1,\'data\':"+json+"}");
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
