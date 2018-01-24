package com.front;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XKR on 2017/8/15.
 */
public interface CategoryService {
    List<HashMap<String,String>> list();
    Integer update(Map<String,String> obj);
}
