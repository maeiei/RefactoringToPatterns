package com.maeiei.typecode.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.maeiei.typecode.PermissionState;
import com.maeiei.typecode.SystemPermission;

public class SystemPermissionTest {

	@Test
	public void denyTest() {

		SystemPermission systemPermissionDeny = new SystemPermission();
		
		assertEquals(PermissionState.REQUESTED, systemPermissionDeny.getState());
		assertEquals(false, systemPermissionDeny.isGranted());

		systemPermissionDeny.claimed();
		assertEquals(PermissionState.CLAIMED, systemPermissionDeny.getState());
		
		systemPermissionDeny.denied();
		assertEquals(PermissionState.DENIED, systemPermissionDeny.getState());
		
		systemPermissionDeny.granted();
		assertEquals(PermissionState.DENIED, systemPermissionDeny.getState());
		assertEquals(false, systemPermissionDeny.isGranted());
	}
	@Test
	public void grantTest() {

		SystemPermission systemPermissionGrant = new SystemPermission();
		
		assertEquals(PermissionState.REQUESTED, systemPermissionGrant.getState());
		assertEquals(false, systemPermissionGrant.isGranted());

		systemPermissionGrant.claimed();
		assertEquals(PermissionState.CLAIMED, systemPermissionGrant.getState());
		
		systemPermissionGrant.granted();
		assertEquals(PermissionState.GRANTED, systemPermissionGrant.getState());
		assertEquals(true, systemPermissionGrant.isGranted());
	}
}
