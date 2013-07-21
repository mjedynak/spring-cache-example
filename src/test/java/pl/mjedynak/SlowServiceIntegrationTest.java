package pl.mjedynak;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SlowServiceIntegrationTest {

    @Autowired
    private SlowService slowService;

    @Test
    public void shouldUseCacheWhenCallingCachedMethodWithTheSameParameter() {
        // given
        String clientName = "WakaWaka";

        // when
        slowService.isVipClient(clientName);
        slowService.isVipClient(clientName);

        // then
        verify(slowService).isVipClient(clientName);
    }
}
