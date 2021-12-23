package myservice;

import kata.KataSingleSignOnRegistry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sso.Request;
import sso.Response;
import sso.SSOToken;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @InjectMocks
    private MyService myService;

    @Mock
    private KataSingleSignOnRegistry kataSingleSignOnRegistry;

    @Test
    public void undefinedSSOTokenIsRejected() {
        Response response = myService.handleRequest(new Request("Foo", null));

        assertThat(response.getText()).isEqualTo("sso token is not defined");
    }

    @Test
    public void invalidSSOTokenIsRejected() {
        Response response = myService.handleRequest(new Request("Foo", new SSOToken()));

        assertThat(response.getText()).isEqualTo("sso token is invalid");
    }

    @Test
    public void validSSOTokenIsAccepted() {
        SSOToken ssoToken = new SSOToken();
        Mockito.doReturn(true).when(kataSingleSignOnRegistry).is_valid(ssoToken);

        Response response = myService.handleRequest(new Request("Foo", ssoToken));

        assertThat(response.getText()).isEqualTo("hello Foo!");
    }
}
