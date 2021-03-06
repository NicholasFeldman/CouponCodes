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
package tech.feldman.couponcodes.api.command;

public interface CommandHandler {

    /**
     * Handles a command with arguments.
     * @param command The command to handle. This is what immediately follows the <code>/</code>
     * @param args The arguments of the command
     * @param sender The sender of the command
     * @return True if the command was handled successfully
     */
    boolean handleCommand(String command, String[] args, CommandSender sender);

    /**
     * Handles a command with no arguments.
     * @param command The command to handle. This is what immediately follows the <code>/</code>
     * @param sender The sender of the command
     * @return True if the command was handled successfully
     */
    boolean handleCommand(String command, CommandSender sender);

    /**
     * Handle a raw command message
     * @param sender The sender of the command
     * @param message The raw command message
     * @return True if the command was handled successfully
     */
    boolean handleCommandEvent(CommandSender sender, String message);
}
