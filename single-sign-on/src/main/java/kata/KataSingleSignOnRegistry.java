package kata;

import sso.AuthenticationGateway;
import sso.SSOToken;
import sso.SingleSignOnRegistry;

import java.util.ArrayList;
import java.util.List;

public class KataSingleSignOnRegistry implements SingleSignOnRegistry {

    private AuthenticationGateway authenticationGateway;

    private List<SSOToken> validTokens;

    public KataSingleSignOnRegistry(AuthenticationGateway authenticationGateway) {
        this.authenticationGateway = authenticationGateway;
        this.validTokens = new ArrayList();
    }

    @Override
    public SSOToken register_new_session(String userName, String password) {
        if (!authenticationGateway.credentialsAreValid(userName, password)) {
            return new SSOToken();
        }
        SSOToken validToken = new SSOToken();
        this.validTokens.add(validToken);
        return validToken;
    }

    @Override
    public boolean is_valid(SSOToken token) {
        return validTokens.contains(token);
    }

    @Override
    public void unregister(SSOToken token) {
        this.validTokens.remove(token);
    }
}
