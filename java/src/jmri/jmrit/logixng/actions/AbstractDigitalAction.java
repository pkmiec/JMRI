package jmri.jmrit.logixng.actions;

import jmri.InstanceManager;
import jmri.JmriException;
import jmri.Manager;
import jmri.jmrit.logixng.implementation.AbstractBase;
import jmri.jmrit.logixng.Base;
import jmri.jmrit.logixng.DigitalActionBean;
import jmri.jmrit.logixng.DigitalActionManager;

/**
 * The base class for LogixNG Actions
 * 
 * @author Daniel Bergqvist Copyright 2018
 */
public abstract class AbstractDigitalAction extends AbstractBase
        implements DigitalActionBean {

    private Base _parent = null;
    private Lock _lock = Lock.NONE;
    private int _state = DigitalActionBean.UNKNOWN;
    
    
    public AbstractDigitalAction(String sys, String user)
            throws BadUserNameException, BadSystemNameException {
        super(sys, user);
        
        // Do this test here to ensure all the tests are using correct system names
        Manager.NameValidity isNameValid = InstanceManager.getDefault(DigitalActionManager.class).validSystemNameFormat(mSystemName);
        if (isNameValid != Manager.NameValidity.VALID) {
            throw new IllegalArgumentException("system name is not valid: "+mSystemName);
        }
    }
    
    /** {@inheritDoc} */
    @Override
    public Base getParent() {
        return _parent;
    }

    /** {@inheritDoc} */
    @Override
    public void setParent(Base parent) {
        _parent = parent;
    }

    /** {@inheritDoc} */
    @Override
    public Lock getLock() {
        return _lock;
    }
    
    /** {@inheritDoc} */
    @Override
    public void setLock(Lock lock) {
        _lock = lock;
    }
    
    public String getNewSocketName() {
        String[] names = new String[getChildCount()];
        for (int i=0; i < getChildCount(); i++) {
            names[i] = getChild(i).getName();
        }
        return getNewSocketName(names);
    }
    
    public static String getNewSocketName(String[] names) {
        int x = 1;
        while (x < 10000) {     // Protect from infinite loop
            boolean validName = true;
            for (int i=0; i < names.length; i++) {
                String name = "A" + Integer.toString(x);
                if (name.equals(names[i])) {
                    validName = false;
                    break;
                }
            }
            if (validName) {
                return "A" + Integer.toString(x);
            }
            x++;
        }
        throw new RuntimeException("Unable to find a new socket name");
    }

    @Override
    public String getBeanType() {
        return Bundle.getMessage("BeanNameDigitalAction");
    }

    @Override
    public void setState(int s) throws JmriException {
        log.warn("Unexpected call to setState in AbstractDigitalAction.");  // NOI18N
        _state = s;
    }

    @Override
    public int getState() {
        log.warn("Unexpected call to getState in AbstractDigitalAction.");  // NOI18N
        return _state;
    }
    
    
    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AbstractDigitalAction.class);
}
