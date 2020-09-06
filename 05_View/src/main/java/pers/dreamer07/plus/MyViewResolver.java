package pers.dreamer07.plus;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * 自定义视图解析器
 * @author shkstart
 * @create 2020-09-05 18:34
 */
public class MyViewResolver implements ViewResolver, Ordered {

    private Integer order;

    @Override //通过该方法创建 View 视图对象
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if(viewName.startsWith("emt:")){
            return new MyView(); //得到自定义的视图对象
        }else{
            return null;
        }
    }

    @Override //返回视图的优先级
    public int getOrder() {
        return 0;
    }

    public void setOrder(Integer orderId){
        this.order = orderId;
    }
}
