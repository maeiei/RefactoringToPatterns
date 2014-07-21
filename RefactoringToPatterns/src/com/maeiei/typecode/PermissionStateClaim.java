package com.maeiei.typecode;

public class PermissionStateClaim extends PermissionState {

	public PermissionStateClaim() {
		super("CLAIMED");
	}

	@Override
	public void denied(SystemPermission systemPermission) {
		if (systemPermission.getState().equals(CLAIMED)) {
			systemPermission.setState(DENIED);
		}
	}

	@Override
	public void granted(SystemPermission systemPermission) {
		if(!systemPermission.getState().equals(CLAIMED)){
			return;
		}
		systemPermission.setState(GRANTED);
		systemPermission.setGranted(true);
	}
}