package pers.dreamer07.plus;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 自定义视图
 * @author shkstart
 * @create 2020-09-05 18:36
 */
public class MyView implements View {

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override //自定义实现页面渲染
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html");
        response.getWriter().write("芜湖，起飞！！"); //这里向页面输出数据
    }
}
