package com.view; /**
 * Created by zty on 2018/1/1.
 */

import com.db.SqlHelper;
import java.sql.ResultSet;
import java.util.Vector;

public class Demo {
    Vector<String> paras=new Vector();
    Vector<Integer> values = new Vector<Integer>();
    SqlHelper sh=new SqlHelper();
    String sql;
    public Vector<Integer> getTurnover(String sql,Vector<String> paras)
    {
        this.sql=sql;
        this.paras=paras;
//        sql="select MONEY from turnover where dates between ? and ? group by DATES";
//        paras.add("2016-01-01");
//        paras.add("2016-01-31");
        ResultSet rs=sh.queryExecute(sql, paras);
        try {
            while(rs.next())
            {
                int a = Integer.parseInt(rs.getString("MONEY")+"");
                values.add(a);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            sh.close();
        }
        return values;
    }

    public Vector<Integer> getValues() {
        return values;
    }

    public void setValues(Vector<Integer> values) {
        this.values = values;
    }

    public static void main(String args[]){
        Demo demo=new Demo();
    }

}
