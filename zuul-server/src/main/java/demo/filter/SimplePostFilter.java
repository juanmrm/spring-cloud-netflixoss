package demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.Debug;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class SimplePostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return Debug.debugRouting();
    }

    @Override
    public Object run() {
        String debug = convertToPrettyPrintString(Debug.getRoutingDebug());
        log.info("Filter Debug Info = \n{}", debug);
        return null;
    }

    private String convertToPrettyPrintString(List<String> filterDebugList) {
        return filterDebugList.stream()
                .map(s -> s.startsWith("{") ? "\t" + s : s)
                .collect(Collectors.joining("\n"));
    }

}
