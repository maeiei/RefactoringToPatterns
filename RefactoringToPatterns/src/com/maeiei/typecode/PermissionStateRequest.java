package com.maeiei.typecode;

public class PermissionStateRequest extends PermissionState {

	public PermissionStateRequest() {
		super("REQUESTED");
	}

	public void claimed(SystemPermission systemPermission) {
		if(systemPermission.getState().equals(REQUESTED)){
			systemPermission.setState(CLAIMED);
		}
	}
}