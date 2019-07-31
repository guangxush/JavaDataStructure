package knowledge.jexltest;

import org.apache.commons.jexl3.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: guangxush
 * @create: 2019/08/01
 */
public class JextProfileTest {
    private static final JexlEngine JEXL_ENGINE = new JexlBuilder().strict(true).silent(false).cache(32).create();

    // some constants
    private static final String LOWER42 = "fourty-two";
    private static final String UPPER42 = "FOURTY-TWO";
    /**
     * An Inner class.
     */
    public static class Inner {
        public double aDouble = 42.0;
        public static double NOT42 = -42.0;
    }

    /**
     * A Struct, all fields public
     */
    public static class Struct {
        public Inner inner = new Inner();
        public int anInt = 42;
        public String aString = LOWER42;
    }

    // a pub instance
    private Struct pub;
    // the JexlContext to use
    private JexlContext ctxt;

    @Before
    public void setUp() {
        pub = new Struct();
        ctxt = new MapContext();
        ctxt.set("pub", pub);
    }

    @Test
    public void testGetInt() throws Exception {
        JexlExpression get = JEXL_ENGINE.createExpression("pub.anInt");
        Assert.assertEquals(42, get.evaluate(ctxt));
        JEXL_ENGINE.setProperty(pub, "anInt", -42);
        Assert.assertEquals(-42, get.evaluate(ctxt));
    }

    @Test
    public void testSetInt() throws Exception {
        JexlExpression set = JEXL_ENGINE.createExpression("pub.anInt = value");
        ctxt.set("value", -42);
        Assert.assertEquals(-42, set.evaluate(ctxt));
        Assert.assertEquals(-42, JEXL_ENGINE.getProperty(pub, "anInt"));
        ctxt.set("value", 42);
        Assert.assertEquals(42, set.evaluate(ctxt));
        Assert.assertEquals(42, JEXL_ENGINE.getProperty(pub, "anInt"));
        try {
            ctxt.set("value", UPPER42);
            Assert.assertEquals(null, set.evaluate(ctxt));
            Assert.fail("should have thrown");
        } catch(JexlException xjexl) {}
    }

    @Test
    public void testGetString() throws Exception {
        JexlExpression get = JEXL_ENGINE.createExpression("pub.aString");
        Assert.assertEquals(LOWER42, get.evaluate(ctxt));
        JEXL_ENGINE.setProperty(pub, "aString", UPPER42);
        Assert.assertEquals(UPPER42, get.evaluate(ctxt));
    }

    @Test
    public void testSetString() throws Exception {
        JexlExpression set = JEXL_ENGINE.createExpression("pub.aString = value");
        ctxt.set("value", UPPER42);
        Assert.assertEquals(UPPER42, set.evaluate(ctxt));
        Assert.assertEquals(UPPER42, JEXL_ENGINE.getProperty(pub, "aString"));
        ctxt.set("value", LOWER42);
        Assert.assertEquals(LOWER42, set.evaluate(ctxt));
        Assert.assertEquals(LOWER42, JEXL_ENGINE.getProperty(pub, "aString"));
    }

    @Test
    public void testGetInnerDouble() throws Exception {
        JexlExpression get = JEXL_ENGINE.createExpression("pub.inner.aDouble");
        Assert.assertEquals(42.0, get.evaluate(ctxt));
        JEXL_ENGINE.setProperty(pub, "inner.aDouble", -42);
        Assert.assertEquals(-42.0, get.evaluate(ctxt));
    }

    @Test
    public void testSetInnerDouble() throws Exception {
        JexlExpression set = JEXL_ENGINE.createExpression("pub.inner.aDouble = value");
        ctxt.set("value", -42.0);
        Assert.assertEquals(-42.0, set.evaluate(ctxt));
        Assert.assertEquals(-42.0, JEXL_ENGINE.getProperty(pub, "inner.aDouble"));
        ctxt.set("value", 42.0);
        Assert.assertEquals(42.0, set.evaluate(ctxt));
        Assert.assertEquals(42.0, JEXL_ENGINE.getProperty(pub, "inner.aDouble"));
        try {
            ctxt.set("value", UPPER42);
            Assert.assertEquals(null, set.evaluate(ctxt));
            Assert.fail("should have thrown");
        } catch(JexlException xjexl) {}
    }

    public enum Gender { MALE, FEMALE };

    @Test
    public void testGetEnum() throws Exception {
        ctxt.set("com.jexl.gender", Gender.class);
        String src = "x = com.jexl.gender.FEMALE";
        JexlScript script = JEXL_ENGINE.createScript(src);
        Object result = script.execute(ctxt);
        Assert.assertEquals(Gender.FEMALE, result);
        Assert.assertEquals(Gender.FEMALE, ctxt.get("x"));
    }

    @Test
    public void testGetStaticField() throws Exception {
        ctxt.set("com.jexl", Inner.class);
        String src = "x = com.jexl.NOT42";
        JexlScript script = JEXL_ENGINE.createScript(src);
        Object result = script.execute(ctxt);
        Assert.assertEquals(Inner.NOT42, result);
        Assert.assertEquals(Inner.NOT42, ctxt.get("x"));
    }
}
