package com.github.drepic26.couponcodes.api;

import com.github.drepic26.couponcodes.api.command.CommandHandler;
import com.github.drepic26.couponcodes.api.config.ConfigHandler;
import com.github.drepic26.couponcodes.api.coupon.CouponHandler;
import com.github.drepic26.couponcodes.api.database.DatabaseHandler;
import com.github.drepic26.couponcodes.api.economy.EconomyHandler;
import com.github.drepic26.couponcodes.api.event.EventHandler;
import com.github.drepic26.couponcodes.api.permission.PermissionHandler;

public class CouponCodes {

	private static ModTransformer modTransformer;
	private static PermissionHandler permissionHandler;
	private static EconomyHandler economyHandler;
	private static CouponHandler couponHandler;
	private static ConfigHandler configHandler;
	private static EventHandler eventHandler;
	private static CommandHandler commandHandler;
	private static DatabaseHandler databaseHandler;

	public static ModTransformer getModTransformer() { 
		return modTransformer;
	}

	public static PermissionHandler getPermissionHandler() {
		return permissionHandler;
	}

	public static EconomyHandler getEconomyHandler() {
		return economyHandler;
	}

	public static CouponHandler getCouponHandler() {
		return couponHandler;
	}

	public static ConfigHandler getConfigHandler() {
		return configHandler;
	}

	public static EventHandler getEventHandler() {
		return eventHandler;
	}

	public static CommandHandler getCommandHandler() {
		return commandHandler;
	}

	public static DatabaseHandler getDatabaseHandler() {
		return databaseHandler;
	}

	public static void setModTransformer(ModTransformer mt) {
		modTransformer = mt;
	}

	public static void setPermissionHandler(PermissionHandler ph) {
		permissionHandler = ph;
	}

	public static void setEconomyHandler(EconomyHandler eh) {
		economyHandler = eh;
	}

	public static void setCouponHandler(CouponHandler ch) {
		couponHandler = ch;
	}

	public static void setConfigHandler(ConfigHandler ch) {
		configHandler = ch;
	}

	public static void setEventHandler(EventHandler eh) {
		eventHandler = eh;
	}

	public static void setCommandHandler(CommandHandler ch) {
		commandHandler = ch;
	}

	public static void setDatabaseHandler(DatabaseHandler dh) {
		databaseHandler = dh;
	}

}
