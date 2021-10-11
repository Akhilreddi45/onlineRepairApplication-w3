package com.online.repair.model;

import java.util.Date;

import com.online.repair.builder.DeviceBuilder;
import com.online.repair.state.CompleteRepairState;
import com.online.repair.state.RepairInProgressState;
import com.online.repair.state.RepairState;
import com.online.repair.state.StartRepairState;

public abstract class Device {

	protected String device;
	protected String repairType;
	protected String customerName;
	protected String contactDetails;
	protected Date transactionDate;
	protected Date estimatedDeliveryDate;

	protected DeviceBuilder builder;

	RepairState state;
	RepairState startRepairState;
	RepairState repairInProgressState;
	RepairState completeRepairState;

	public Device(DeviceBuilder builder) {
		this.device = builder.getDevice();
		this.repairType = builder.getRepairType();
		this.customerName = builder.getCustomerName();
		this.contactDetails = builder.getContactDetails();
		this.transactionDate = builder.getTransactionDate();
		this.estimatedDeliveryDate = builder.getEstimatedDeliveryDate();
		this.startRepairState = new StartRepairState(this);
		this.repairInProgressState = new RepairInProgressState(this);
		this.completeRepairState = new CompleteRepairState(this);
		this.state = startRepairState;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getRepairType() {
		return repairType;
	}

	public void setRepairType(String repairType) {
		this.repairType = repairType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Date getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}

	public RepairState getState() {
		return state;
	}

	public void setState(RepairState state) {
		this.state = state;
	}

	public RepairState getStartRepairState() {
		return startRepairState;
	}

	public void setStartRepairState(RepairState startRepairState) {
		this.startRepairState = startRepairState;
	}

	public RepairState getRepairInProgressState() {
		return repairInProgressState;
	}

	public void setRepairInProgressState(RepairState repairInProgressState) {
		this.repairInProgressState = repairInProgressState;
	}

	public RepairState getCompleteRepairState() {
		return completeRepairState;
	}

	public void setCompleteRepairState(RepairState completeRepairState) {
		this.completeRepairState = completeRepairState;
	}

	public void startRepair() {
		state.startRepair();
	}

	public void completeRepair() {
		state.repairInProgress();
		state.completeRepair();
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Device [device=");
		builder2.append(device);
		builder2.append(", repairType=");
		builder2.append(repairType);
		builder2.append(", customerName=");
		builder2.append(customerName);
		builder2.append(", contactDetails=");
		builder2.append(contactDetails);
		builder2.append(", transactionDate=");
		builder2.append(transactionDate);
		builder2.append(", estimatedDeliveryDate=");
		builder2.append(estimatedDeliveryDate);
		builder2.append(", state=");
		builder2.append(state);
		builder2.append("]");
		return builder2.toString();
	}

}
