package com.front;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XKR on 2017/8/15.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Override
    public List<HashMap<String, String>> list() {
        List list = new ArrayList();
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn = JDBCConnect.getConn();
            String sql = "select id,name,flag from category";
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap<String,String>();
                hm.put("id",rs.getInt("id"));
                hm.put("name",rs.getString("name"));
                hm.put("flag",rs.getInt("flag"));
                list.add(hm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(pstmt!=null)
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return list;
    }

    @Override
    public Integer update(Map<String, String> obj) {
        Integer i=0;
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn = JDBCConnect.getConn();
            String sql = "UPDATE category set name=?, flag=? where id=?";
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            pstmt.setInt(3, Integer.valueOf(obj.get("id")));
            pstmt.setString(1, obj.get("name"));
            pstmt.setInt(2,Integer.valueOf(obj.get("flag")));
            pstmt.execute();
            i = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(pstmt!=null)
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return i;
    }
}
