
package com.v2h.core.search;
import com.sundear.base.model.SearchBase;

public class InverterInfoSearch extends SearchBase {
	private int limitSize;
	public int getLimitSize(){
		return this.limitSize;
	}
	public void setLimitSize(int limitSize){
		this.limitSize=limitSize;
	}
}