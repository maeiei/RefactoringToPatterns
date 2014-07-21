package com.maeiei.typecode;

public class SystemPermission {
	
	private PermissionState permission;
	
	private boolean granted;
	
	public SystemPermission(){
		setState(PermissionState.REQUESTED);
		granted = false;
	}
	
	public void claimed(){
		permission.claimed(this);
	}
	public void denied(){
		permission.denied(this);
	}
	public void granted(){
		permission.granted(this);
	}
	
	public void setState(PermissionState permissionState) {
		this.permission = permissionState;
	}

	public PermissionState getState() {
		return permission;
	}

	public boolean isGranted() {
		return granted;
	}

	public void setGranted(boolean granted) {
		this.granted = granted;
	}
}
