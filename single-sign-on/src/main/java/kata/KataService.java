package kata;

import sso.Request;
import sso.Response;
import sso.SingleSignOnRegistry;

public class KataService {

    private SingleSignOnRegistry singleSignOnRegistry;

    public KataService(SingleSignOnRegistry singleSignOnRegistry) {
        this.singleSignOnRegistry = singleSignOnRegistry;
    }

    public Response handleRequest(Request request) throws IllegalAccessException {
        if (!singleSignOnRegistry.is_valid(request.getSSOToken())) {
            throw new IllegalAccessException("SSO token is invalid");
        }
        return new Response("Hello " + request.getName());
    }
}
