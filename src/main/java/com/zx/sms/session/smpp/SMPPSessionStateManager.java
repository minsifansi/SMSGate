package com.zx.sms.session.smpp;

import java.util.Map;

import com.zx.sms.codec.cmpp.msg.Message;
import com.zx.sms.codec.smpp.msg.Pdu;
import com.zx.sms.common.storedMap.VersionObject;
import com.zx.sms.connect.manager.EndpointEntity;
import com.zx.sms.session.AbstractSessionStateManager;

public class SMPPSessionStateManager extends AbstractSessionStateManager<Integer, Pdu> {

	public SMPPSessionStateManager(EndpointEntity entity, Map<Integer, VersionObject<Pdu>> storeMap, boolean preSend) {
		super(entity, storeMap, preSend);
	}

	@Override
	protected Integer getSequenceId(Pdu msg) {
		
		return msg.getSequenceNumber();
	}

	@Override
	protected boolean needSendAgainByResponse(Pdu req, Pdu res) {
		return false;
	}

}
