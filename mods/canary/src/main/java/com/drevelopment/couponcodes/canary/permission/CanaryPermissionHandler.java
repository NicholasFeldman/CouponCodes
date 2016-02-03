/**
 * The MIT License
 * Copyright (c) 2015 Nicholas Feldman (AngrySoundTech)
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.drevelopment.couponcodes.canary.permission;

import java.util.Set;
import java.util.TreeSet;

import net.canarymod.Canary;

import com.drevelopment.couponcodes.api.entity.Player;
import com.drevelopment.couponcodes.api.permission.PermissionHandler;

public class CanaryPermissionHandler implements PermissionHandler {

    @Override
    public String getName() {
        return "Canary";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean hasPermission(Player player, String node) {
        return Canary.getServer().getPlayerFromUUID(player.getUUID()).hasPermission(node);
    }

    @Override
    public Set<String> getGroups(Player player) {
        Set<String> groups = new TreeSet<>();
        groups.add(Canary.getServer().getPlayerFromUUID(player.getUUID()).getGroup().getName());
        return groups;
    }

    @Override
    public void setPlayerGroup(Player player, String group) {
        Canary.getServer().getPlayerFromUUID(player.getUUID()).setGroup(Canary.usersAndGroups().getGroup(group));
    }

    @Override
    public boolean groupSupport() {
        return true;
    }

}
