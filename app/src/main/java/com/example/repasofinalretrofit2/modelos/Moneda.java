package com.example.repasofinalretrofit2.modelos;

import java.util.List;

public class Moneda{
	private List<Coin> data;
	private long timestamp;

	public void setData(List<Coin> data){
		this.data = data;
	}

	public List<Coin> getData(){
		return data;
	}

	public void setTimestamp(long timestamp){
		this.timestamp = timestamp;
	}

	public long getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"Moneda{" + 
			"data = '" + data + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}