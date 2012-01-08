package com.vaibhavmishra.githubjobsdroid;

import java.util.Date;

public class Utils {
	public static String getReadableTimeDifference(Date oldTime, Date newTime) {
		long ldiff = (newTime.getTime() - oldTime.getTime())/1000;
		if (ldiff < 60 * 10) {

			return "just now";
		} else if (ldiff < 60 * 60) {
			return "less than 1 hour ago";
		} else if (ldiff < 60 * 60 * 24) {
			return ldiff / (60 * 60) + " hour"
					+ (ldiff < 2 * 60 * 60 ? "" : "s") + " ago";
		} else {
			return ldiff / (60 * 60 * 24) + " day"
					+ (ldiff < 2 * 60 * 60 * 24 ? "" : "s") + " ago";
		}
	}
}
