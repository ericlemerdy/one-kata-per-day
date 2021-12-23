package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sso.Request;
import sso.Response;
import sso.SSOToken;
import sso.SingleSignOnRegistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class KataServiceTest {

    @InjectMocks
    private KataService kataService;

    @Mock
    private SingleSignOnRegistry singleSignOnRegistry;

    @Test
    public void with_valid_credential_and_eric_name_should_return_hello_eric() throws IllegalAccessException {
        SSOToken validCredentials = new SSOToken();
        doReturn(true).when(singleSignOnRegistry).is_valid(validCredentials);

        Response response = kataService.handleRequest(new Request("Éric", validCredentials));

        assertThat(response.getText()).isEqualTo("Hello Éric");
    }

    @Test
    public void with_invalid_credentials_should_deny_access() {
        SSOToken invalidCredentials = new SSOToken();
        doReturn(false).when(singleSignOnRegistry).is_valid(invalidCredentials);

        assertThatThrownBy(() -> kataService.handleRequest(new Request("Éric", invalidCredentials))).isExactlyInstanceOf(IllegalAccessException.class);
    }
}