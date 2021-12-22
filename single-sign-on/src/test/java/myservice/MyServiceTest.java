package myservice;

import kata.KataSingleSignOnRegistry;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import sso.Request;
import sso.Response;
import sso.SSOToken;

import static org.junit.Assert.assertEquals;


public class MyServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private MyService myService;

    @Mock
    private KataSingleSignOnRegistry kataSingleSignOnRegistry;

    @Test
    public void undefinedSSOTokenIsRejected() {
        Response response = myService.handleRequest(new Request("Foo", null));

        assertEquals("sso token is not defined", response.getText());
    }

    @Test
    public void invalidSSOTokenIsRejected() {
        Response response = myService.handleRequest(new Request("Foo", new SSOToken()));

        assertEquals("sso token is invalid", response.getText());
    }

    @Test
    public void validSSOTokenIsAccepted() {
        SSOToken ssoToken = new SSOToken();
        Mockito.doReturn(true).when(kataSingleSignOnRegistry).is_valid(ssoToken);

        Response response = myService.handleRequest(new Request("Foo", ssoToken));

        assertEquals("hello Foo!", response.getText());
    }
}
