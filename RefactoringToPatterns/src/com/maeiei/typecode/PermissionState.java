package com.maeiei.typecode;

public abstract class PermissionState {

	public String name;

	public final static PermissionState REQUESTED = new PermissionStateRequest();
	public final static PermissionState CLAIMED = new PermissionStateClaim();
	public final static PermissionState DENIED = new PermissionStateDeny();
	public final static PermissionState GRANTED = new PermissionStateGrant();

	public PermissionState(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public void claimed(SystemPermission systemPermission) {

	}

	public void denied(SystemPermission systemPermission) {

	}

	public void granted(SystemPermission systemPermission) {

	}
}
