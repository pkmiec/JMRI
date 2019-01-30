package jmri.managers;

import javax.annotation.Nonnull;

import jmri.IdTag;
import jmri.IdTagManager;
import jmri.Manager;
import jmri.Reporter;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementation of a IdTagManager that can serve as a proxy for multiple
 * system-specific implementations.
 *
 * @author	Bob Jacobsen Copyright (C) 2010, 2018
 * @author	Dave Duchamp Copyright (C) 2004
 * @author	Paul Bender Copyright (C) 2019
 */
public class ProxyIdTagManager extends AbstractProxyManager<IdTag>
        implements IdTagManager {

    public ProxyIdTagManager() {
        super();
    }

    @Override
    public int getXMLOrder() {
        return jmri.Manager.IDTAGS;
    }

    @Override
    public void init() {
        if(!isInitialised()){
           getDefaultManager();
        }
    }

    @Override
    public boolean isInitialised() {
        return (jmri.InstanceManager.getDefault(IdTagManager.class) != null);
    }

    @Override
    protected AbstractManager<IdTag> makeInternalManager() {
        // since this really is an internal tracking mechanisim,
        // build the new manager and add it here.
        DefaultIdTagManager tagMan = new DefaultIdTagManager();
        jmri.InstanceManager.setIdTagManager(tagMan);
        return tagMan;
    }

    @Override
    public Manager<IdTag> getDefaultManager() {
        return getInternalManager();
    }

    /**
     * Locate via user name, then system name if needed.
     *
     * @return Null if nothing by that name exists
     */
    @Override
    public IdTag getIdTag(String name) {
        return super.getNamedBean(name);
    }

    @Override
    protected IdTag makeBean(int i, String systemName, String userName) {
        return ((IdTagManager) getMgr(i)).newIdTag(systemName, userName);
    }

    @Override
    /** {@inheritDoc} */
    public IdTag provide(@Nonnull String name) throws IllegalArgumentException { return provideIdTag(name); }

    /**
     * Locate via user name, then system name if needed. If that fails, create a
     * new IdTag: If the name is a valid system name, it will be used for the
     * new IdTag. Otherwise, the makeSystemName method will attempt to turn it
     * into a valid system name.
     *
     * @return Never null under normal circumstances
     */
    @Override
    public IdTag provideIdTag(String name) throws IllegalArgumentException {
        return super.provideNamedBean(name);
    }

    /**
     * Locate an instance based on a system name. Returns null if no instance
     * already exists.
     *
     * @return requested IdTag object or null if none exists
     */
    @Override
    public IdTag getBySystemName(String systemName) {
        return super.getBeanBySystemName(systemName);
    }

    /**
     * Locate an instance based on a user name. Returns null if no instance
     * already exists.
     *
     * @return requested Turnout object or null if none exists
     */
    @Override
    public IdTag getByUserName(String userName) {
        return super.getBeanByUserName(userName);
    }

    /**
     * Return an instance with the specified system and user names. Note that
     * two calls with the same arguments will get the same instance; there is
     * only one IdTag object representing a given physical light and therefore
     * only one with a specific system or user name.
     * <P>
     * This will always return a valid object reference for a valid request; a
     * new object will be created if necessary. In that case:
     * <UL>
     * <LI>If a null reference is given for user name, no user name will be
     * associated with the IdTag object created; a valid system name must be
     * provided
     * <LI>If a null reference is given for the system name, a system name will
     * _somehow_ be inferred from the user name. How this is done is system
     * specific. Note: a future extension of this interface will add an
     * exception to signal that this was not possible.
     * <LI>If both names are provided, the system name defines the hardware
     * access of the desired turnout, and the user address is associated with
     * it.
     * </UL>
     * Note that it is possible to make an inconsistent request if both
     * addresses are provided, but the given values are associated with
     * different objects. This is a problem, and we don't have a good solution
     * except to issue warnings. This will mostly happen if you're creating
     * IdTags when you should be looking them up.
     *
     * @return requested IdTag object (never null)
     */
    @Override
    public IdTag newIdTag(String systemName, String userName) {
        return newNamedBean(systemName, userName);
    }

    @Override
    public IdTag getByTagID(String tagID) {
        return getBySystemName(makeSystemName(tagID));
    }

    /**
     * Validate system name format. Locate a system specfic IdTagManager based on
     * a system name.
     *
     * @return if a manager is found, return its determination of validity of
     * system name format. Return INVALID if no manager exists.
     */
    @Override
    public NameValidity validSystemNameFormat(String systemName) {
        int i = matchTentative(systemName);
        if (i >= 0) {
            return ((IdTagManager) getMgr(i)).validSystemNameFormat(systemName);
        }
        return NameValidity.INVALID;
    }

    /**
     * Normalize a system name Locate a system specfic IdTagManager based on a
     * system name. Returns "" if no manager exists. If a manager is found,
     * return its determination of a normalized system name
     */
    @Override
    public String normalizeSystemName(String systemName) {
        int i = matchTentative(systemName);
        if (i >= 0) {
            return ((IdTagManager) getMgr(i)).normalizeSystemName(systemName);
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEntryToolTip() {
        String entryToolTip = "Enter a number from 1 to 9999"; // Basic number format help
        return entryToolTip;
    }

    @Override
    public String getBeanTypeHandled() {
        return Bundle.getMessage("BeanNameIdTag");
    }

    @Override
    public void setStateStored(boolean state) {
    }

    @Override
    public boolean isStateStored() {
        return false;
    }

    @Override
    public void setFastClockUsed(boolean fastClock) {
    }

    @Override
    public boolean isFastClockUsed() {
        return false;
    }

    @Override
    public List<IdTag> getTagsForReporter(Reporter reporter, long threshold) {
        List<IdTag> out = new ArrayList<>();
        return out;
    }

}
