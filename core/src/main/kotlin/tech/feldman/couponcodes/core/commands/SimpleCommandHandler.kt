/**
 * The MIT License
 * Copyright (c) 2015 Nicholas Feldman (AngrySoundTech)
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tech.feldman.couponcodes.core.commands

import tech.feldman.couponcodes.api.CouponCodes
import tech.feldman.couponcodes.api.command.CommandHandler
import tech.feldman.couponcodes.api.command.CommandSender
import tech.feldman.couponcodes.core.commands.runnables.*
import tech.feldman.couponcodes.core.util.LocaleHandler

class SimpleCommandHandler : CommandHandler {

    override fun handleCommand(command: String, args: Array<String>, sender: CommandSender): Boolean {
        if (command.equals("coupon", ignoreCase = true)) {
            if (args[0].equals("help", ignoreCase = true)) {
                help(sender)
                return true
            } else if (args[0].equals("add", ignoreCase = true)) {
                if (sender.hasPermission("cc.add")) {
                    CouponCodes.getModTransformer().scheduleRunnable(AddCommand(sender, args))
                    return true
                } else {
                    sender.sendMessage(LocaleHandler.getString("Command.NoPermission"))
                    return true
                }
            } else if (args[0].equals("time", ignoreCase = true)) {
                if (sender.hasPermission("cc.time")) {
                    CouponCodes.getModTransformer().scheduleRunnable(TimeCommand(sender, args))
                    return true
                } else {
                    sender.sendMessage(LocaleHandler.getString("Command.NoPermission"))
                    return true
                }
            } else if (args[0].equals("uses", ignoreCase = true)) {
                if (sender.hasPermission("cc.uses")) {
                    CouponCodes.getModTransformer().scheduleRunnable(UsesCommand(sender, args))
                    return true
                } else {
                    sender.sendMessage(LocaleHandler.getString("Command.NoPermission"))
                    return true
                }
            }
            if (args[0].equals("remove", ignoreCase = true)) {
                if (sender.hasPermission("cc.remove")) {
                    CouponCodes.getModTransformer().scheduleRunnable(RemoveCommand(sender, args))
                    return true
                } else {
                    sender.sendMessage(LocaleHandler.getString("Command.NoPermission"))
                    return true
                }
            } else if (args[0].equals("redeem", ignoreCase = true)) {
                if (sender.hasPermission("cc.redeem")) {
                    CouponCodes.getModTransformer().scheduleRunnable(RedeemCommand(sender, args))
                    return true
                } else {
                    sender.sendMessage(LocaleHandler.getString("Command.NoPermission"))
                    return true
                }
            } else if (args[0].equals("list", ignoreCase = true)) {
                if (sender.hasPermission("cc.list")) {
                    CouponCodes.getModTransformer().scheduleRunnable(ListCommand(sender, args))
                    return true
                } else {
                    sender.sendMessage(LocaleHandler.getString("Command.NoPermission"))
                    return true
                }
            } else if (args[0].equals("info", ignoreCase = true)) {
                if (sender.hasPermission("cc.info")) {
                    CouponCodes.getModTransformer().scheduleRunnable(InfoCommand(sender, args))
                    return true
                } else {
                    sender.sendMessage(LocaleHandler.getString("Command.NoPermission"))
                    return true
                }
            } else
                return false
        } else
            return false
    }

    override fun handleCommand(command: String, sender: CommandSender): Boolean {
        if (command.equals("coupon", ignoreCase = true)) {
            help(sender)
            return true
        } else
            return false
    }

    override fun handleCommandEvent(sender: CommandSender, message: String): Boolean {
        var message = message
        message = trimCommand(message)
        val indexOfSpace = message.indexOf(" ")

        if (indexOfSpace != -1) {
            val command = message.substring(0, indexOfSpace)
            val args = message.substring(indexOfSpace + 1).split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return handleCommand(command, args, sender)
        } else {
            return handleCommand(message, sender)
        }
    }

    private fun trimCommand(command: String): String {
        var command = command
        if (command.startsWith("/")) {
            if (command.length == 1) {
                return ""
            } else {
                command = command.substring(1)
            }
        }
        return command.trim { it <= ' ' }
    }

    private fun help(sender: CommandSender) {
        sender.sendMessage(LocaleHandler.getString("Command.Help.Header"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.Instructions"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.AddItem"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.AddEcon"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.AddRank"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.AddXp"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.AddCmd"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.Time"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.Uses"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.Redeem"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.Remove"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.List"))
        sender.sendMessage(LocaleHandler.getString("Command.Help.Info"))
    }

}