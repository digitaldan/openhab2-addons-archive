/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.max.internal.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openhab.binding.max.internal.command.SConfigCommand.ConfigCommandType;

/**
 * Tests cases for {@link SConfigCommand}.
 *
 * @author Marcel Verpaalen - Initial contribution
 */
public class SConfigCommandTest {

    private static final String RF_TEST_ADDRESS = "0e15cc";
    private static final int TEST_ROOM = 2;

    private CubeCommand cubeCommand;

    @Before
    public void before() {
        cubeCommand = new SConfigCommand(RF_TEST_ADDRESS, TEST_ROOM, ConfigCommandType.SetRoom);
    }

    @Test
    public void setRoomTest() {
        cubeCommand = new SConfigCommand(RF_TEST_ADDRESS, TEST_ROOM, ConfigCommandType.SetRoom);
        String commandString = cubeCommand.getCommandString();
        assertEquals("s:AAAiAAAADhXMAAI=\r\n", commandString);
    }

    @Test
    public void removeRoomTest() {
        cubeCommand = new SConfigCommand(RF_TEST_ADDRESS, 1, ConfigCommandType.RemoveRoom);
        String commandString = cubeCommand.getCommandString();
        assertEquals("s:AAAjAAAADhXMAAE=\r\n", commandString);
    }
}
