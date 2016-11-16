package myservice;

import sso.Request;
import sso.Response;
import sso.SingleSignOnRegistry;

public class MyService {
    
    private SingleSignOnRegistry registry;
    
    public MyService(SingleSignOnRegistry registry) {
        this.registry = registry;
    }
    
    public Response handleRequest(Request request) {
        // TODO: check request has a valid SSOToken
        return new Response("hello " + request.getName() + "!");
    }
}
