package sso;

public class Request {

    private String name;
    private SSOToken token;

    public Request(String name, SSOToken token) {
        this.name = name;
        this.token = token;
    }
    
    public SSOToken getSSOToken() {
        return this.token;
    }
    
    public String getName() {
        return this.name;
    }
}
