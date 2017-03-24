package gov.samhsa.c2s.c2suiapi;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore("Depends on config-server on bootstrap")
public class C2sUiApiApplicationTests {

    @Test
    public void contextLoads() {
    }

}
