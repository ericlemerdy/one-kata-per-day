package myservice;

import static org.junit.Assert.*;

import org.junit.Test;

import sso.Request;
import sso.Response;
import sso.SingleSignOnRegistry;

public class MyServiceTest {

    @Test
    public void invalidSSOTokenIsRejected() {
        MyService service = new MyService(null);
        Response response = service.handleRequest(new Request("Foo", null));
        assertNotEquals("hello Foo!", response.getText());
    }
}
