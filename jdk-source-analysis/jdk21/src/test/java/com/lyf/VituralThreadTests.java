package com.lyf;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * 虚拟线程-协程的使用
 *
 * @author liyunfei
 **/
public class VituralThreadTests {
    private static class Response{

    }
    @Test
    public void testBaseUse(){
        Response response = new Response();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var future1 = executor.submit(() -> {});
            var future2 = executor.submit(() -> {});
//            response.send(future1.get() + future2.get());
        }
    }

    String fetchURL(URL url) throws IOException {
        try (var in = url.openStream()) {
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
