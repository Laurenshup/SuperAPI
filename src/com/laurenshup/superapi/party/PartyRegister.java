package com.laurenshup.superapi.party;

import java.util.HashSet;
import java.util.Set;

public class PartyRegister {
	
	protected static Set<Party> parties = new HashSet<>();
	
	public static Set<Party> getParties() {
		return parties;
	}

}
