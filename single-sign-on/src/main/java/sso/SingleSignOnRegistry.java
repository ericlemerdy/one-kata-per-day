package sso;

public interface SingleSignOnRegistry {

    SSOToken register_new_session(String userName, String password);
    boolean is_valid(SSOToken token);
    void unregister(SSOToken token);
    
}