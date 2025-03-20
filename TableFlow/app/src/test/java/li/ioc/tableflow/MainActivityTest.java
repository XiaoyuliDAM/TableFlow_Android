package li.ioc.tableflow;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    @Mock
    private MainActivity mainActivity;

    @Mock
    private EditText etUsername, etPassword;

    @Mock
    private Button btnLogin;

    @Captor
    private ArgumentCaptor<Intent> intentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mainActivity = new MainActivity(); // Creem una instància real
        etUsername = mock(EditText.class);
        etPassword = mock(EditText.class);
        btnLogin = mock(Button.class);
    }

    @Test
    public void testLoginSuccess() {
        mainActivity.loginUser("Francisco", "rosa1234");

        verify(mainActivity).startActivity(intentCaptor.capture());
        Intent capturedIntent = intentCaptor.getValue();
        assertNotNull(capturedIntent);
        assertEquals(DashboardActivity.class.getName(), capturedIntent.getComponent().getClassName());
    }

    @Test
    public void testLoginWithIncorrectUsername() {
        mainActivity.loginUser("Incorrecte", "rosa1234");

        verify(mainActivity).showToast("Usuari incorrecte");
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        mainActivity.loginUser("Francisco", "incorrecta");

        verify(mainActivity).showToast("Contrasenya incorrecta");
    }
}
