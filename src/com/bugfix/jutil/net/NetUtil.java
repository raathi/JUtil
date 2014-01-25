package com.bugfix.jutil.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.bugfix.jutil.constant.IConstants;
import com.bugfix.jutil.validation.Validator;

public class NetUtil {
	public static String getHostName() {
		try {
			return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		}
		return IConstants.UKNOWN_HOST;
	}

	public static String getHostAddress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		}
		return IConstants.UKNOWN_HOST;
	}

	public static String[] getAvailableHostAddresses() {
		try {
			InetAddress[] inetAddresses = InetAddress
					.getAllByName(getHostName());
			if (!Validator.isEmpty(inetAddresses)) {
				String[] availableIPs = new String[inetAddresses.length];
				for (int i = 0; i < inetAddresses.length; i++) {
					availableIPs[i] = inetAddresses[i].getHostAddress();
				}
			}
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static boolean isHostAddressAvailable(String hostAddress) {
		if (Validator.isEmpty(hostAddress)) {
			return false;
		}
		for (String availableHostAddress : NetUtil.getAvailableHostAddresses()) {
			if (hostAddress.equals(availableHostAddress)) {
				return true;
			}
		}
		return false;
	}

	public static InetAddress getInetAddress(String hostAddress) {
		try {
			if (!NetUtil.isHostAddressAvailable(hostAddress)) {
				String localHostAddress = InetAddress.getLocalHost()
						.getHostAddress();
				System.err.println("Host Address \""+hostAddress+"\" unavailable, assigning localhost Address:"
								+ localHostAddress);
				hostAddress = localHostAddress;
			}
			for (InetAddress availableInetAddress : InetAddress.getAllByName(NetUtil
					.getHostName())) {
				if (hostAddress.equals(availableInetAddress.getHostAddress())) {
					return availableInetAddress;
				}
			}
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
