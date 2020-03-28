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
        if (request.getSSOToken() == null) {
            return new Response("sso token is not defined");
        }
        boolean isRegistryValid = this.registry.is_valid(request.getSSOToken());
        if (!isRegistryValid) {
            return new Response("sso token is invalid");
        }
        return new Response("hello " + request.getName() + "!");
    }
}
