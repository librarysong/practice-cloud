package cn.swf.practice.practicehystrix.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by 宋维飞
 * 2019/7/2 15:55
 */
@Slf4j
public class RequestLoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = null;
        try {
            response = execution.execute(request, body);
        } finally {
            String path = "to be resolved";
            if (true) {
                path = request.getURI().getPath();
                if (response != null) {
                    BufferingClientHttpResponseWrapper responseWrapper = new BufferingClientHttpResponseWrapper(response);
                    log.info("request method: {}, request URI: {}, request headers: {}, request body: {}, response status code: {}, response headers: {}, response body: {}",
                            request.getMethod(),
                            request.getURI(),
                            request.getHeaders(),
                            new String(body, Charset.forName("UTF-8")),
                            response.getStatusCode(),
                            response.getHeaders(),
                            new String(StreamUtils.copyToByteArray(responseWrapper.getBody()), Charset.forName("UTF-8")));
                    return responseWrapper;
                } else {
                    log.debug("won't logging http request, consider add {} to http.request.logging.paths if  required", path);
                }
            } else {
                log.debug("won't logging http request, consider set http.request.logging.enabled to true if required");
            }
        }

        return response;
    }
}
