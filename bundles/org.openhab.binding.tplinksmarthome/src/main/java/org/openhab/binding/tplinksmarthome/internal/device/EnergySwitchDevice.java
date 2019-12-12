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
package org.openhab.binding.tplinksmarthome.internal.device;

import static org.openhab.binding.tplinksmarthome.internal.TPLinkSmartHomeBindingConstants.*;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.smarthome.core.library.types.QuantityType;
import org.eclipse.smarthome.core.library.unit.SmartHomeUnits;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.types.State;
import org.eclipse.smarthome.core.types.UnDefType;
import org.openhab.binding.tplinksmarthome.internal.Commands;
import org.openhab.binding.tplinksmarthome.internal.model.Realtime;

/**
 * TP-Link Smart Home Switch device that also can measure energy usage.
 *
 * @author Hilbrand Bouwkamp - Initial contribution
 */
@NonNullByDefault
public class EnergySwitchDevice extends SwitchDevice {

    @Override
    public String getUpdateCommand() {
        return Commands.getRealtimeAndSysinfo();
    }

    @Override
    public State updateChannel(ChannelUID channelUid, DeviceState deviceState) {
        final State state;
        final String matchChannelId = channelUid.isInGroup() ? channelUid.getIdWithoutGroup() : channelUid.getId();

        if (CHANNELS_ENERGY.contains(matchChannelId)) {
            state = updateEnergyChannel(matchChannelId, deviceState.getRealtime());
        } else {
            state = super.updateChannel(channelUid, deviceState);
        }
        return state;
    }

    /**
     * Gets the state for an energy channel.
     *
     * @param channelId Id of the energy channel to get the state
     * @param realtime data object containing the data from the device
     * @return state object for the given channel
     */
    protected State updateEnergyChannel(String channelId, Realtime realtime) {
        final State value;

        switch (channelId) {
            case CHANNEL_ENERGY_CURRENT:
                value = new QuantityType<>(realtime.getCurrent(), SmartHomeUnits.AMPERE);
                break;
            case CHANNEL_ENERGY_TOTAL:
                value = new QuantityType<>(realtime.getTotal(), SmartHomeUnits.KILOWATT_HOUR);
                break;
            case CHANNEL_ENERGY_VOLTAGE:
                value = new QuantityType<>(realtime.getVoltage(), SmartHomeUnits.VOLT);
                break;
            case CHANNEL_ENERGY_POWER:
                value = new QuantityType<>(realtime.getPower(), SmartHomeUnits.WATT);
                break;
            default:
                value = UnDefType.UNDEF;
                break;
        }
        return value;
    }
}
