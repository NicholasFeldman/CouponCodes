package com.github.drepic26.couponcodes.core;

import java.util.HashMap;
import java.util.Map;

import com.github.drepic26.couponcodes.api.ModTransformer;
import com.github.drepic26.couponcodes.api.entity.Player;

public abstract class ServerModTransformer implements ModTransformer {

	protected final Map<String, Player> players = new HashMap<String, Player>();

	/**
	 * Gets a player. If we have not gotten them yet, we get them from the server
	 */
	public Player getPlayer(String UUID) {
		if (players.containsKey(UUID)) return players.get(UUID);
		Player player = getModPlayer(UUID);
		if (player != null) {
			players.put(UUID, player);
			return player;
		}
		return player;
	}
}
