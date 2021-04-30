package jmri.jmrit.throttle;

import java.awt.GraphicsEnvironment;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.jupiter.api.*;

/**
 * Test simple functioning of ThrottlesPreferencesWindow
 *
 * @author Lionel Jeanson
 */
public class ThrottlesPreferencesWindowTest {
    @Test
    public void testCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        ThrottlesPreferencesWindow w = new ThrottlesPreferencesWindow("ThrottlesPreferencesWindowTest");
        Assert.assertNotNull("exists", w);
    }

    @BeforeEach
    public void setUp() throws Exception {
        jmri.util.JUnitUtil.setUp();

    }

    @AfterEach
    public void tearDown() throws Exception {
        jmri.util.JUnitUtil.tearDown();

    }
}

