/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chtijbug.drools.entity.history.process;

import org.chtijbug.drools.entity.DroolsProcessInstanceObject;

/**
 * 
 * @author nheron
 */
public class ProcessStartHistoryEvent extends ProcessHistoryEvent {

	private static final long serialVersionUID = -9002244608850950935L;
	protected DroolsProcessInstanceObject processInstance;

	/**
	 * 
	 */
	public ProcessStartHistoryEvent() {
	}

	public ProcessStartHistoryEvent(DroolsProcessInstanceObject processInstance) {
		this.processInstance = processInstance;
	}

	public DroolsProcessInstanceObject getProcessInstance() {
		return processInstance;
	}

}