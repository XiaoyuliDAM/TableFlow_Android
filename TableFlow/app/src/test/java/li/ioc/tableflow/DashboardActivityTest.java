package li.ioc.tableflow;

import android.content.Intent;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 28)
public class DashboardActivityTest {

    private DashboardActivity dashboardActivity;

    @Mock
    private Button btnLogout;

    @Captor
    private ArgumentCaptor<Intent> intentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        dashboardActivity = spy(new DashboardActivity()); // Ús de spy() en comptes de mock()
        doNothing().when(dashboardActivity).startActivity(any(Intent.class)); // Simular startActivity()
    }

    @Test
    public void testLogout() {
        dashboardActivity.logout();

        verify(dashboardActivity).startActivity(intentCaptor.capture());
        Intent capturedIntent = intentCaptor.getValue();
        assertNotNull(capturedIntent);
        assertEquals(MainActivity.class.getName(), capturedIntent.getComponent().getClassName());
    }
}
