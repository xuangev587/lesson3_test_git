package servlet;

import bean.EchartsResult;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Echarts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");

        List<String> xData = new ArrayList<>();
        List<Integer> yData = new ArrayList<> ();

        for (int i =1; i<8;i++){
            xData.add("星期"+ i);
            yData.add(i);
        }

        //这个地方要返回数据. 弄清楚一下，那个bean文件中的result有什么作用？
        //bean文件中的result就是限定数据格式用的
//        resp.getWriter().println(result);
        EchartsResult echartsResult = new EchartsResult();
        echartsResult.setxData(xData);
        echartsResult.setyData(yData);

        JSONObject json = JSONObject.fromObject(echartsResult);
        resp.getWriter().println(json);
    }
}
