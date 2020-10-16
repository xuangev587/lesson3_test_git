import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import servlet.CalculateServlet;
import servlet.Echarts;
import servlet.HelloServlet;
//服务器的基本配置文件
public class MiniprogramServer {

    public static void main(String[] args) {

        try {
            // 1、配置端口
            int port = 8888;
            Server server = new Server(port);

            // 2、配置服务器参数
            WebAppContext context = new WebAppContext();
            context.setContextPath("/");
            context.setResourceBase("web"); // 指定根目录
            server.setHandler(context);
            //差不多就是服务器端所部署的服务
            //也就是api接口的问题
            context.addServlet(HelloServlet.class, "/hello");
            context.addServlet(CalculateServlet.class,"/calc");
            context.addServlet(Echarts.class,"/echarts");

            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
