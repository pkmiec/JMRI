// ConnectionConfig.java

package jmri.jmrix.loconet.locobuffer;
import javax.swing.JPanel;


/**
 * Definition of objects to handle configuring an LocoBuffer layout connection
 * via a LocoBufferAdapter object.
 *
 * @author      Bob Jacobsen   Copyright (C) 2001, 2003
 * @version	$Revision: 1.4 $
 */
public class ConnectionConfig  extends jmri.jmrix.AbstractConnectionConfig {

    /**
     * Ctor for an object being created during load process;
     * Swing init is deferred.
     */
    public ConnectionConfig(jmri.jmrix.SerialPortAdapter p){
        super(p);
    }
    /**
     * Ctor for a functional Swing object with no prexisting adapter
     */
    public ConnectionConfig() {
        super();
    }
    
    public boolean isOptList2Advanced() { return false; }

    public String name() { return "LocoNet LocoBuffer"; }

    protected void setInstance() { adapter = LocoBufferAdapter.instance(); }
}

