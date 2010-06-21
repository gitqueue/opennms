/**
 * 
 */
package org.opennms.features.poller.remote.gwt.server;

import java.util.Date;
import java.util.TimerTask;

import org.opennms.core.utils.LogUtils;

import de.novanic.eventservice.service.EventExecutorService;

final class UpdateTask extends TimerTask {
    private final EventExecutorService m_service;
    private final LocationDataManager m_locationDataManager;
    private Date m_lastUpdated;

    public UpdateTask(final EventExecutorService service, final Date lastUpdated, LocationDataManager locationDataManager) {
        m_service = service;
        m_lastUpdated = lastUpdated;
        m_locationDataManager = locationDataManager;
    }

    @Override
    public void run() {
        try {
            final Date endDate = new Date();
            m_locationDataManager.doUpdate(m_lastUpdated, endDate, m_service);
    		m_lastUpdated = endDate;
    	} catch (final Exception e) {
    		LogUtils.warnf(m_locationDataManager, e, "An error occurred while pushing monitor and application status updates.");
    	}
    }
}