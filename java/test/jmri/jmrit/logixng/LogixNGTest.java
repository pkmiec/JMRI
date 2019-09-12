package jmri.jmrit.logixng;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import jmri.InstanceManager;
import jmri.JmriException;
import jmri.NamedBean;
import jmri.jmrit.logixng.Base.Lock;
import jmri.jmrit.logixng.implementation.DefaultLogixNG;
import jmri.jmrit.logixng.implementation.DefaultConditionalNG;
import jmri.jmrit.logixng.digital.actions.ActionTurnout;
import jmri.jmrit.logixng.digital.actions.IfThenElse;
import jmri.jmrit.logixng.digital.expressions.And;
import jmri.jmrit.logixng.digital.expressions.ExpressionTurnout;
import jmri.util.JUnitAppender;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test LogixNG
 * 
 * @author Daniel Bergqvist 2018
 */
public class LogixNGTest {
    
    @Test
    public void testGetNewObjectBasedOnTemplate() {
        // The method getNewObjectBasedOnTemplate() returns null for now. Fix later.
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        Assert.assertNull("getNewObjectBasedOnTemplate() returns null", logixNG.getNewObjectBasedOnTemplate());
    }
    
    @Test
    public void testSetParent() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        boolean hasThrown = false;
        try {
            logixNG.setParent(null);
        } catch (UnsupportedOperationException e) {
            hasThrown = true;
        }
        Assert.assertTrue("exception thrown", hasThrown);
    }
    
    @Test
    public void testGetParent() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        Assert.assertNull("getParent() returns null", logixNG.getParent());
    }
    
    @Test
    public void testState() throws JmriException {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        Assert.assertTrue("getState() returns UNKNOWN", logixNG.getState() == LogixNG.UNKNOWN);
        JUnitAppender.assertWarnMessage("Unexpected call to getState in DefaultLogixNG.");
        logixNG.setState(LogixNG.INCONSISTENT);
        JUnitAppender.assertWarnMessage("Unexpected call to setState in DefaultLogixNG.");
        Assert.assertTrue("getState() returns UNKNOWN", logixNG.getState() == LogixNG.UNKNOWN);
        JUnitAppender.assertWarnMessage("Unexpected call to getState in DefaultLogixNG.");
    }
    
    @Test
    public void testShortDescription() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        Assert.assertEquals("getShortDescription() returns correct value",
                "LogixNG", logixNG.getShortDescription(Locale.US));
    }
    
    @Test
    public void testLongDescription() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        Assert.assertEquals("getLongDescription() returns correct value",
                "LogixNG: A new logix for test", logixNG.getLongDescription(Locale.US));
    }
    
    @Test
    public void testGetChild() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        boolean hasThrown = false;
        try {
            logixNG.getChild(0);
        } catch (UnsupportedOperationException e) {
            hasThrown = true;
        }
        Assert.assertTrue("exception thrown", hasThrown);
    }
    
    @Test
    public void testGetChildCount() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        boolean hasThrown = false;
        try {
            logixNG.getChildCount();
        } catch (UnsupportedOperationException e) {
            hasThrown = true;
        }
        Assert.assertTrue("exception thrown", hasThrown);
    }
    
    @Test
    public void testGetCategory() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        boolean hasThrown = false;
        try {
            logixNG.getCategory();
        } catch (UnsupportedOperationException e) {
            hasThrown = true;
        }
        Assert.assertTrue("exception thrown", hasThrown);
    }
    
    @Test
    public void testIsExternal() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        boolean hasThrown = false;
        try {
            logixNG.isExternal();
        } catch (UnsupportedOperationException e) {
            hasThrown = true;
        }
        Assert.assertTrue("exception thrown", hasThrown);
    }
    
    @Test
    public void testGetLock() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        boolean hasThrown = false;
        try {
            logixNG.getLock();
        } catch (UnsupportedOperationException e) {
            hasThrown = true;
        }
        Assert.assertTrue("exception thrown", hasThrown);
    }
    
    @Test
    public void testSetLock() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        boolean hasThrown = false;
        try {
            logixNG.setLock(Lock.NONE);
        } catch (UnsupportedOperationException e) {
            hasThrown = true;
        }
        Assert.assertTrue("exception thrown", hasThrown);
    }
    
    @Test
    public void testSwapConditionalNG() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        ConditionalNG conditionalNG_1 = new DefaultConditionalNG(logixNG.getSystemName()+":1", null);
        logixNG.addConditionalNG(conditionalNG_1);
        ConditionalNG conditionalNG_2 = new DefaultConditionalNG(logixNG.getSystemName()+":2", null);
        logixNG.addConditionalNG(conditionalNG_2);
        ConditionalNG conditionalNG_3 = new DefaultConditionalNG(logixNG.getSystemName()+":3", null);
        logixNG.addConditionalNG(conditionalNG_3);
        ConditionalNG conditionalNG_4 = new DefaultConditionalNG(logixNG.getSystemName()+":4", null);
        logixNG.addConditionalNG(conditionalNG_4);
        
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_1 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_3 == logixNG.getConditionalNG(2));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(3));
        
        logixNG.swapConditionalNG(0, 0);
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_1 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_3 == logixNG.getConditionalNG(2));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(3));
        
        logixNG.swapConditionalNG(1, 0);
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_1 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_3 == logixNG.getConditionalNG(2));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(3));
        
        logixNG.swapConditionalNG(0, 1);
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_1 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_3 == logixNG.getConditionalNG(2));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(3));
        
        logixNG.swapConditionalNG(0, 2);
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_3 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_1 == logixNG.getConditionalNG(2));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(3));
        
        logixNG.swapConditionalNG(2, 3);
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_3 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(2));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_1 == logixNG.getConditionalNG(3));
    }
    
    @Test
    public void testGetConditionalNG() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        ConditionalNG conditionalNG_1 = new DefaultConditionalNG(logixNG.getSystemName()+":1", null);
        logixNG.addConditionalNG(conditionalNG_1);
        ConditionalNG conditionalNG_2 = new DefaultConditionalNG(logixNG.getSystemName()+":2", null);
        logixNG.addConditionalNG(conditionalNG_2);
        ConditionalNG conditionalNG_3 = new DefaultConditionalNG(logixNG.getSystemName()+":3", null);
        logixNG.addConditionalNG(conditionalNG_3);
        ConditionalNG conditionalNG_4 = new DefaultConditionalNG(logixNG.getSystemName()+":4", null);
        logixNG.addConditionalNG(conditionalNG_4);
        
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_1 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_3 == logixNG.getConditionalNG(2));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(3));
        Assert.assertTrue("ConditionalNG is correct", null == logixNG.getConditionalNG(-1));
        Assert.assertTrue("ConditionalNG is correct", null == logixNG.getConditionalNG(4));
    }
    
    @Test
    public void testAddConditionalNG() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        ConditionalNG conditionalNG_1 = new DefaultConditionalNG(logixNG.getSystemName()+":1", null);
        Assert.assertTrue("conditionalNG added", logixNG.addConditionalNG(conditionalNG_1));
        ConditionalNG conditionalNG_2 = new DefaultConditionalNG(logixNG.getSystemName()+":1", null);
        Assert.assertFalse("conditionalNG not added", logixNG.addConditionalNG(conditionalNG_2));
        JUnitAppender.assertWarnMessage("ConditionalNG 'IQ:0001:1' has already been added to LogixNG 'IQ:0001'");
        ConditionalNG conditionalNG_3 = new DefaultConditionalNG(logixNG.getSystemName()+":3", null);
        Assert.assertTrue("conditionalNG added", logixNG.addConditionalNG(conditionalNG_3));
    }
    
    @Test
    public void testGetConditionalNGByUserName() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        ConditionalNG conditionalNG_1 = new DefaultConditionalNG(logixNG.getSystemName()+":1", "Abc");
        logixNG.addConditionalNG(conditionalNG_1);
        ConditionalNG conditionalNG_2 = new DefaultConditionalNG(logixNG.getSystemName()+":2", "Def");
        logixNG.addConditionalNG(conditionalNG_2);
        ConditionalNG conditionalNG_3 = new DefaultConditionalNG(logixNG.getSystemName()+":3", "Ghi");
        logixNG.addConditionalNG(conditionalNG_3);
        ConditionalNG conditionalNG_4 = new DefaultConditionalNG(logixNG.getSystemName()+":4", "Jkl");
        logixNG.addConditionalNG(conditionalNG_4);
        
        Assert.assertTrue("ConditionalNG is correct",
                conditionalNG_1 == logixNG.getConditionalNGByUserName("Abc"));
        Assert.assertTrue("ConditionalNG is correct",
                conditionalNG_2 == logixNG.getConditionalNGByUserName("Def"));
        Assert.assertTrue("ConditionalNG is correct",
                conditionalNG_3 == logixNG.getConditionalNGByUserName("Ghi"));
        Assert.assertTrue("ConditionalNG is correct",
                conditionalNG_4 == logixNG.getConditionalNGByUserName("Jkl"));
    }
    
    @Test
    public void testDeleteConditionalNG() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        ConditionalNG conditionalNG_1 = new DefaultConditionalNG(logixNG.getSystemName()+":1", null);
        logixNG.addConditionalNG(conditionalNG_1);
        ConditionalNG conditionalNG_2 = new DefaultConditionalNG(logixNG.getSystemName()+":2", null);
        logixNG.addConditionalNG(conditionalNG_2);
        ConditionalNG conditionalNG_3 = new DefaultConditionalNG(logixNG.getSystemName()+":3", null);
        logixNG.addConditionalNG(conditionalNG_3);
        ConditionalNG conditionalNG_4 = new DefaultConditionalNG(logixNG.getSystemName()+":4", null);
        logixNG.addConditionalNG(conditionalNG_4);
        ConditionalNG conditionalNG_5 = new DefaultConditionalNG(logixNG.getSystemName()+":5", null);
        logixNG.addConditionalNG(conditionalNG_5);
        ConditionalNG conditionalNG_6 = new DefaultConditionalNG(logixNG.getSystemName()+":6", null);
        logixNG.addConditionalNG(conditionalNG_6);
        
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_1 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_3 == logixNG.getConditionalNG(2));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(3));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_5 == logixNG.getConditionalNG(4));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_6 == logixNG.getConditionalNG(5));
        
        logixNG.deleteConditionalNG(conditionalNG_1);
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_3 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(2));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_5 == logixNG.getConditionalNG(3));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_6 == logixNG.getConditionalNG(4));
        
        logixNG.deleteConditionalNG(conditionalNG_1);
        JUnitAppender.assertErrorMessage("attempt to delete ConditionalNG not in LogixNG: IQ:0001:1");
        
        logixNG.deleteConditionalNG(conditionalNG_6);
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_3 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(2));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_5 == logixNG.getConditionalNG(3));
        
        logixNG.deleteConditionalNG(conditionalNG_3);
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_4 == logixNG.getConditionalNG(1));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_5 == logixNG.getConditionalNG(2));
        
        logixNG.deleteConditionalNG(conditionalNG_4);
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_2 == logixNG.getConditionalNG(0));
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_5 == logixNG.getConditionalNG(1));
        
        logixNG.deleteConditionalNG(conditionalNG_2);
        Assert.assertTrue("ConditionalNG is correct", conditionalNG_5 == logixNG.getConditionalNG(0));
        
        logixNG.deleteConditionalNG(conditionalNG_5);
        Assert.assertTrue("LogixNG has no more conditionalNGs", 0 == logixNG.getNumConditionalNGs());
    }
    
    @Test
    public void testActivateLogixNG() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        MyConditionalNG conditionalNG_1 = new MyConditionalNG(logixNG.getSystemName()+":1", null);
        logixNG.addConditionalNG(conditionalNG_1);
        conditionalNG_1.setEnabled(false);
        MyConditionalNG conditionalNG_2 = new MyConditionalNG(logixNG.getSystemName()+":2", null);
        logixNG.addConditionalNG(conditionalNG_2);
        conditionalNG_1.setEnabled(true);
        MyConditionalNG conditionalNG_3 = new MyConditionalNG(logixNG.getSystemName()+":3", null);
        logixNG.addConditionalNG(conditionalNG_3);
        conditionalNG_1.setEnabled(false);
        
        Assert.assertFalse("listeners for conditionalNG_1 are not registered", conditionalNG_1.listenersAreRegistered);
        Assert.assertFalse("listeners for conditionalNG_2 are not registered", conditionalNG_2.listenersAreRegistered);
        Assert.assertFalse("listeners for conditionalNG_3 are not registered", conditionalNG_3.listenersAreRegistered);
        
        logixNG.activateLogixNG();
        Assert.assertTrue("listeners for conditionalNG_1 are registered", conditionalNG_1.listenersAreRegistered);
        Assert.assertTrue("listeners for conditionalNG_2 are registered", conditionalNG_2.listenersAreRegistered);
        Assert.assertTrue("listeners for conditionalNG_3 are registered", conditionalNG_3.listenersAreRegistered);
        
        logixNG.deActivateLogixNG();
        Assert.assertFalse("listeners for conditionalNG_1 are registered", conditionalNG_1.listenersAreRegistered);
        Assert.assertFalse("listeners for conditionalNG_2 are registered", conditionalNG_2.listenersAreRegistered);
        Assert.assertFalse("listeners for conditionalNG_3 are registered", conditionalNG_3.listenersAreRegistered);
    }
    
    @Test
    public void testGetConditionalNG_WithoutParameters() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        boolean hasThrown = false;
        try {
            logixNG.getConditionalNG();
        } catch (UnsupportedOperationException e) {
            hasThrown = true;
        }
        Assert.assertTrue("exception thrown", hasThrown);
    }
    
    @Test
    public void testGetLogixNG() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        Assert.assertTrue("logixNG is correct", logixNG == logixNG.getLogixNG());
    }
    
    @Test
    public void testGetRoot() {
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        Assert.assertTrue("root is correct", logixNG == logixNG.getRoot());
    }
    
    @Test
    public void testPrintTree() {
        final String newLine = System.lineSeparator();
        StringBuilder expectedResult = new StringBuilder();
        expectedResult
                .append("LogixNG: A new logix for test").append(newLine)
                .append("...ConditionalNG").append(newLine)
                .append("......! ").append(newLine)
                .append(".........Many").append(newLine)
                .append("............! A1").append(newLine)
                .append("...............Hold anything").append(newLine)
                .append("..................? A1").append(newLine)
                .append("..................! A1").append(newLine)
                .append("..................! A1").append(newLine)
                .append("............! A2").append(newLine)
                .append("...............If E then A1 else A2").append(newLine)
                .append("..................? E").append(newLine)
                .append("..................! A1").append(newLine)
                .append("..................! A2").append(newLine)
                .append("............! A3").append(newLine);
        
        StringWriter writer = new StringWriter();
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        ConditionalNG conditionalNG = new DefaultConditionalNG(logixNG.getSystemName()+":1", null);
        logixNG.addConditionalNG(conditionalNG);
        InstanceManager.getDefault(LogixNG_Manager.class).setupInitialConditionalNGTree(conditionalNG);
        logixNG.printTree(new PrintWriter(writer), "...");
        String resultStr = writer.toString();
        
        Assert.assertEquals("Strings matches", expectedResult.toString(), resultStr);
    }
    
    @Test
    public void testBaseLock() {
        Assert.assertTrue("isChangeableByUser is correct", Base.Lock.NONE.isChangeableByUser());
        Assert.assertTrue("isChangeableByUser is correct", Base.Lock.USER_LOCK.isChangeableByUser());
        Assert.assertFalse("isChangeableByUser is correct", Base.Lock.HARD_LOCK.isChangeableByUser());
        Assert.assertFalse("isChangeableByUser is correct", Base.Lock.TEMPLATE_LOCK.isChangeableByUser());
    }
    
    @Test
    public void testBundleClass() {
        Assert.assertTrue("bundle is correct", "Test Bundle bb aa cc".equals(Bundle.getMessage("TestBundle", "aa", "bb", "cc")));
        Assert.assertTrue("bundle is correct", "Generic".equals(Bundle.getMessage(Locale.US, "SocketTypeGeneric")));
        Assert.assertTrue("bundle is correct", "Test Bundle bb aa cc".equals(Bundle.getMessage(Locale.US, "TestBundle", "aa", "bb", "cc")));
    }
    
    @Test
    public void testCategory() {
        Assert.assertTrue("isChangeableByUser is correct", "Item".equals(Category.ITEM.toString()));
        Assert.assertTrue("isChangeableByUser is correct", "Common".equals(Category.COMMON.toString()));
        Assert.assertTrue("isChangeableByUser is correct", "Other".equals(Category.OTHER.toString()));
        Assert.assertTrue("isChangeableByUser is correct", "Extravaganza".equals(Category.EXRAVAGANZA.toString()));
    }
    
    @Test
    public void testManagers() throws SocketAlreadyConnectedException {
        String systemName;
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        ConditionalNG conditionalNG = new DefaultConditionalNG(logixNG.getSystemName()+":1", null);
        logixNG.addConditionalNG(conditionalNG);
        InstanceManager.getDefault(LogixNG_Manager.class).setupInitialConditionalNGTree(conditionalNG);
        MaleSocket many = conditionalNG.getChild(0).getConnectedSocket();
//        System.err.format("aa: %s%n", many.getLongDescription());
        Assert.assertTrue("description is correct", "Many".equals(many.getLongDescription()));
        MaleSocket ifThen = many.getChild(1).getConnectedSocket();
//        System.err.format("aa: %s%n", ifThen.getLongDescription());
        Assert.assertTrue("description is correct", "If E then A1 else A2".equals(ifThen.getLongDescription()));
        systemName = InstanceManager.getDefault(DigitalExpressionManager.class).getNewSystemName();
        DigitalExpressionBean expression = new ExpressionTurnout(systemName, "An expression for test");  // NOI18N
        MaleSocket digitalExpressionBean = InstanceManager.getDefault(DigitalExpressionManager.class).registerExpression(expression);
        ifThen.getChild(0).connect(digitalExpressionBean);
//        InstanceManager.getDefault(jmri.DigitalExpressionManager.class).addExpression(new ExpressionTurnout(systemName, "LogixNG 102, DigitalExpressionBean 26"));  // NOI18N
        systemName = InstanceManager.getDefault(DigitalActionManager.class).getNewSystemName();
        DigitalActionBean action = new ActionTurnout(systemName, "An action for test");  // NOI18N
        MaleSocket digitalActionBean = InstanceManager.getDefault(DigitalActionManager.class).registerAction(action);
        ifThen.getChild(1).connect(digitalActionBean);
        
        logixNG.setParentForAllChildren();
        
        Assert.assertTrue("conditionalng is correct", conditionalNG == digitalActionBean.getConditionalNG());
        Assert.assertTrue("conditionalng is correct", conditionalNG == conditionalNG.getConditionalNG());
        Assert.assertTrue("logixlng is correct", logixNG == digitalActionBean.getLogixNG());
        Assert.assertTrue("logixlng is correct", logixNG == logixNG.getLogixNG());
        
        Assert.assertTrue("instance manager is correct", logixNG.getInstanceManager() == digitalActionBean.getInstanceManager());
        Assert.assertTrue("instance manager is correct", logixNG.getInstanceManager() == conditionalNG.getInstanceManager());
//        Assert.assertTrue("instance manager is correct", Base.InstanceManagerContainer.defaultInstanceManager == digitalActionBean.getInstanceManager());
//        Assert.assertTrue("instance manager is correct", Base.InstanceManagerContainer.defaultInstanceManager == conditionalNG.getInstanceManager());
//        Assert.assertTrue("instance manager is correct", Base.InstanceManagerContainer.defaultInstanceManager == logixNG.getInstanceManager());
    }
    
    @Test
    public void testSetup() throws SocketAlreadyConnectedException {
        
        LogixNG logixNG = InstanceManager.getDefault(LogixNG_Manager.class).createLogixNG("A new logix for test");  // NOI18N
        DefaultConditionalNG conditionalNG = new DefaultConditionalNG(logixNG.getSystemName()+":1", null);
        logixNG.addConditionalNG(conditionalNG);
        
        String systemName = InstanceManager.getDefault(DigitalActionManager.class).getNewSystemName();
        DigitalActionBean action = new ActionTurnout(systemName, "An action for test");  // NOI18N
        MaleSocket digitalActionBean = InstanceManager.getDefault(DigitalActionManager.class).registerAction(action);
        
        conditionalNG.setSocketSystemName(systemName);
        logixNG.setup();
        
        logixNG.setParentForAllChildren();
        
//        System.err.format("%s%n", conditionalNG.getChild(0).getConnectedSocket().getLongDescription());
        Assert.assertTrue("conditionalng child is correct",
                "Set turnout '' to Thrown"
                        .equals(conditionalNG.getChild(0).getConnectedSocket().getLongDescription()));
        Assert.assertTrue("conditionalng is correct", conditionalNG == digitalActionBean.getConditionalNG());
        Assert.assertTrue("logixlng is correct", logixNG == digitalActionBean.getLogixNG());
    }
    
    @Test
    public void testExceptions() {
        new SocketAlreadyConnectedException().getMessage();
    }
    
    @Test
    public void testBundle() {
        Assert.assertTrue("bean type is correct", "LogixNG".equals(new DefaultLogixNG("IQA55", null).getBeanType()));
        Assert.assertTrue("bean type is correct", "Digital action".equals(new IfThenElse("IQDA321", null, IfThenElse.Type.TRIGGER_ACTION).getBeanType()));
        Assert.assertTrue("bean type is correct", "Digital expression".equals(new And("IQDE321", null).getBeanType()));
    }
    
    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
        JUnitUtil.resetInstanceManager();
        JUnitUtil.initInternalSensorManager();
        JUnitUtil.initInternalTurnoutManager();
        JUnitUtil.initLogixNGManager();
        JUnitUtil.initDigitalExpressionManager();
        JUnitUtil.initDigitalActionManager();
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }
    
    
    private class MyConditionalNG extends DefaultConditionalNG {

        private boolean listenersAreRegistered;
        
        public MyConditionalNG(String sys, String user) throws NamedBean.BadUserNameException, NamedBean.BadSystemNameException {
            super(sys, user);
        }
        
        /** {@inheritDoc} */
        @Override
        public void registerListenersForThisClass() {
            listenersAreRegistered = true;
        }

        /** {@inheritDoc} */
        @Override
        public void unregisterListenersForThisClass() {
            listenersAreRegistered = false;
        }
    }
    
}
