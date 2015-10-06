package com.zoulux.eventbusdemo;

/**
 * �¼���Ϣʵ����
 * @author mmxs
 *
 */
public class MainSendEvent {
	protected String mstrMsg;
	
	public MainSendEvent(String msg) {
	    mstrMsg = msg;
	}

	public String getStringMsgData(){
		return mstrMsg;
	}
}
