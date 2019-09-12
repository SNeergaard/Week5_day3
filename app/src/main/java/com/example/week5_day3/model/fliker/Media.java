package com.example.week5_day3.model.fliker;


import com.google.gson.annotations.SerializedName;

public class Media {

	@SerializedName("m")
	private String M;

	public void setM(String M){
		this.M = M;
	}

	public String getM(){
		return M;
	}

	@Override
 	public String toString(){
		return 
			"Media{" + 
			"m = '" + M + '\'' + 
			"}";
		}
}