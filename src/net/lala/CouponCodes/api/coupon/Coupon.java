package net.lala.CouponCodes.api.coupon;

import java.sql.SQLException;
import java.util.ArrayList;

import net.lala.CouponCodes.CouponCodes;
import net.lala.CouponCodes.api.events.EventHandle;

/**
 * Coupon.java - Stores generic coupon information
 * @author mike101102
 */
public abstract class Coupon {
	
	private String name;
	private int usetimes;
	private ArrayList<String> usedplayers = null;
	
	public Coupon(String name, int usetimes, ArrayList<String> usedplayers) {
		this.name = name;
		this.usetimes = usetimes;
		this.usedplayers = usedplayers;
		EventHandle.callCouponCreateEvent(this);
	}
	
	public boolean addToDatabase() throws SQLException {
		return CouponCodes.getCouponAPI().addCouponToDatabase(this);
	}
	
	public boolean removeFromDatabase() throws SQLException {
		return CouponCodes.getCouponAPI().removeCouponFromDatabase(this);
	}
	
	public boolean isInDatabase() throws SQLException {
		return CouponCodes.getCouponAPI().couponExists(this);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getUseTimes() {
		return usetimes;
	}
	
	public void setUseTimes(int usetimes) {
		this.usetimes = usetimes;
	}
	
	public ArrayList<String> getUsedPlayers() {
		return usedplayers;
	}
	
	public void setUsedPlayers(ArrayList<String> usedplayers) {
		this.usedplayers = usedplayers;
	}
	
	public String getType() {
		if (this instanceof ItemCoupon) return "Item";
		if (this instanceof EconomyCoupon) return "Economy";
		else
			return null;
	}
}