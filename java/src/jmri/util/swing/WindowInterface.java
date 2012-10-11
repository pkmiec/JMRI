// WindowInterface.java

package jmri.util.swing;

import java.awt.Frame;

/**
 * Interface for an object that can arrange for a 
 * {@link JmriPanel} to be displayed.
 * <p>
 * Typically used by some component that wants to display
 * a pane (e.g. in an independent JmriJFrame
 * or as part of a paned interface) to do some more stuff.
 * Rather than have the component build it's own window, etc
 * it invokes one of these, so that the position and 
 * display of that component can controlled.
 * <p>
 * Any {@link JmriAbstractAction} that uses the show() method
 * will have its dispose() invoked when the associated frame
 * goes away.  It should dispose() any cached panes at that time.
 *
 * @author Bob Jacobsen  Copyright 2010
 * @since 2.9.4
 * @version $Revision$
 */

public interface WindowInterface {

    /**
     * Show, in whatever way is appropriate, 
     * a specific JmriPanel
     * @param child new JmriPanel to show
     * @param action JmriAbstractAction making the request
     */
    public void show(jmri.util.swing.JmriPanel child, JmriAbstractAction action );
    
    /**
     * Show, in whatever way is appropriate, 
     * a specific JmriPanel
     * @param child new JmriPanel to show
     * @param action JmriAbstractAction making the request
     * @param hint suggestion on where to put the content
     */
    public void show(jmri.util.swing.JmriPanel child, JmriAbstractAction action, Hint hint );
    
    /**
     * Should 2nd and subsequent requests
     * for a panel (e.g. in an Action) create a
     * new instance, or provide the 1st one
     * for reuse? 
     *
     * This would be true e.g. if separate windows
     * were being provided, or false if there
     * was only one window which is being populated
     * with one pane after another.
     *
     *@return true if multiple instances should be provided,
     *         false if only one should be provided.
     */
    public boolean multipleInstances();

    public void dispose();
    
    //public void runMethod(String method, Object args[]);

    /**
     * Returns the WindowInterface as a Frame or null.
     * 
     * @return a Frame or null
     */
    public Frame getFrame();
    
    /**
     * Suggested location for subsequent panels
     */
    public enum Hint {
        DEFAULT,   // let the interface pick
        REPLACE,   // replace the current content with new
        EXTEND     // place nearby
    }
}