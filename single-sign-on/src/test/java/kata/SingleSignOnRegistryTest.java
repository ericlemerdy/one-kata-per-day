package kata;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import sso.AuthenticationGateway;
import sso.SSOToken;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class SingleSignOnRegistryTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private KataSingleSignOnRegistry singleSignOnRegistry;

    @Mock
    private AuthenticationGateway authenticationGateway;

    @Test
    public void register_new_session_should_delegate_to_authentication_gateway() {
        singleSignOnRegistry.register_new_session("Éric", "foobar");

        verify(authenticationGateway).credentialsAreValid("Éric", "foobar");
    }

    @Test
    public void with_token_from_valid_credentials_token_should_be_valid() {
        doReturn(true).when(authenticationGateway).credentialsAreValid("Éric", "foobar");
        SSOToken ssoToken = singleSignOnRegistry.register_new_session("Éric", "foobar");

        boolean isValidSSOToken = singleSignOnRegistry.is_valid(ssoToken);

        assertThat(isValidSSOToken).isTrue();
    }

    @Test
    public void with_token_from_invalid_credentials_token_should_not_be_valid() {
        doReturn(false).when(authenticationGateway).credentialsAreValid("Éric", "foobar");
        SSOToken ssoToken = singleSignOnRegistry.register_new_session("Éric", "foobar");

        boolean isValidSSOToken = singleSignOnRegistry.is_valid(ssoToken);

        assertThat(isValidSSOToken).isFalse();
    }

    @Test
    public void with_token_from_valid_credentials_after_unregistering_token_should_not_be_valid() {
        doReturn(true).when(authenticationGateway).credentialsAreValid("Éric", "foobar");
        SSOToken ssoToken = singleSignOnRegistry.register_new_session("Éric", "foobar");
        singleSignOnRegistry.unregister(ssoToken);

        boolean isValidUnregisteredSSOToken = singleSignOnRegistry.is_valid(ssoToken);

        assertThat(isValidUnregisteredSSOToken).isFalse();
    }

    @Test
    public void unregistering_unknown_token_should_not_make_it_valid() {
        SSOToken unknownSSOToken = new SSOToken();
        singleSignOnRegistry.unregister(unknownSSOToken);

        boolean isValidUnknownSSOToken = singleSignOnRegistry.is_valid(unknownSSOToken);

        assertThat(isValidUnknownSSOToken).isFalse();
    }
}