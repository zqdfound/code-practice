package com.zqdfound.practice.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * jdk11 httpclient
 * @Author: zhuangqingdian
 * @Data:2023/1/3
 */
public class NewHttpUtil {

    private static String URL = "https://XXXXXXXX.com";

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(5))
//            .followRedirects(HttpClient.Redirect.ALWAYS)
//            .proxy(ProxySelector.of(new InetSocketAddress("your-company-proxy.com", 8080)))
            .build();

    public void sendGetSync() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print response headers
        HttpHeaders headers = response.headers();
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
        // print status code
        System.out.println(response.statusCode());
        // print response body
        System.out.println(response.body());
    }

    public void sendGetAsync() throws ExecutionException, InterruptedException, TimeoutException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);

        System.out.println(result);
    }

    public void sendGetByExecutor() throws URISyntaxException, ExecutionException, InterruptedException {
         HttpClient executorClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(5))
                 .executor(Executors.newFixedThreadPool(5))
                .build();
        List<URI> targets = Arrays.asList(
                new URI("https://httpbin.org/get?name=mkyong1"),
                new URI("https://httpbin.org/get?name=mkyong2"),
                new URI("https://httpbin.org/get?name=mkyong3"));

        List<CompletableFuture<String>> result = targets.stream().map(url->{
            return executorClient.sendAsync(
                    HttpRequest.newBuilder(url)
                            .GET()
                            .setHeader("User-Agent", "Java 11 HttpClient Bot")
                            .build(),
                    HttpResponse.BodyHandlers.ofString()
            ).thenApply(response->response.body());
        }).collect(Collectors.toList());

        for (CompletableFuture<String> future : result) {
            System.out.println(future.get());
        }

    }
    public void sendPostFormSync() throws IOException, InterruptedException {
        // form参数
        Map<Object, Object> data = new HashMap<>();
        data.put("username", "abc");
        data.put("password", "123");
        data.put("custom", "secret");
        data.put("ts", System.currentTimeMillis());

        HttpRequest request = HttpRequest.newBuilder()
                .POST(ofFormData(data))
                .uri(URI.create("https://httpbin.org/post"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());

    }

    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

    public void sendPostJsonSync() throws IOException, InterruptedException {
        String json = new StringBuilder()
                .append("{")
                .append("\"name\":\"mkyong\",")
                .append("\"notes\":\"hello\"")
                .append("}").toString();

        // add json header
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("https://httpbin.org/post"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
//JSON的请求头
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());
    }


}
