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
public class RegisterActivityTest {

    @Mock
    private RegisterActivity registerActivity;

    @Mock
    private EditText etUsername, etEmail, etPassword;

    @Mock
    private Button btnRegister;

    @Captor
    private ArgumentCaptor<Intent> intentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        registerActivity = mock(RegisterActivity.class);
        etUsername = mock(EditText.class);
        etEmail = mock(EditText.class);
        etPassword = mock(EditText.class);
        btnRegister = mock(Button.class);
    }

    @Test
    public void testRegisterSuccess() {
        when(etUsername.getText().toString()).thenReturn("Francisco");
        when(etEmail.getText().toString()).thenReturn("francisco@example.com");
        when(etPassword.getText().toString()).thenReturn("rosa1234");

        registerActivity.registerUser("Francisco", "francisco@example.com", "rosa1234");

        verify(registerActivity).startActivity(intentCaptor.capture());
        Intent capturedIntent = intentCaptor.getValue();
        assertEquals(MainActivity.class.getName(), capturedIntent.getComponent().getClassName());
    }

    @Test
    public void testRegisterWithEmptyUsername() {
        when(etUsername.getText().toString()).thenReturn("");
        when(etEmail.getText().toString()).thenReturn("francisco@example.com");
        when(etPassword.getText().toString()).thenReturn("rosa1234");

        registerActivity.registerUser("", "francisco@example.com", "rosa1234");

        verify(registerActivity).showToast("El camp d'usuari no pot estar buit");
    }

    @Test
    public void testRegisterWithInvalidEmail() {
        when(etUsername.getText().toString()).thenReturn("Francisco");
        when(etEmail.getText().toString()).thenReturn("francisco.com");
        when(etPassword.getText().toString()).thenReturn("rosa1234");

        registerActivity.registerUser("Francisco", "francisco.com", "rosa1234");

        verify(registerActivity).showToast("Introdueix un email vàlid");
    }

    @Test
    public void testRegisterWithShortPassword() {
        when(etUsername.getText().toString()).thenReturn("Francisco");
        when(etEmail.getText().toString()).thenReturn("francisco@example.com");
        when(etPassword.getText().toString()).thenReturn("abc");

        registerActivity.registerUser("Francisco", "francisco@example.com", "abc");

        verify(registerActivity).showToast("La contrasenya ha de tenir almenys 6 caràcters");
    }
}
