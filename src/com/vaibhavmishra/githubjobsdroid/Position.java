package com.vaibhavmishra.githubjobsdroid;

import java.util.Date;


public class Position {
	public String company;
	public String company_logo;
	public String company_url;
	public String created_at;
	public String description;
	public String how_to_apply;
	public String id;
	public String location;
	public String title;
	public String type;
	public String url;

	public String getReadableTime() {
		return Utils.getReadableTimeDifference(new Date(created_at), new Date());
	}
}
