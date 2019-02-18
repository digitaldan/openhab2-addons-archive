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
package org.openhab.binding.enocean.internal.eep.Base;

import org.openhab.binding.enocean.internal.eep.EEP;
import org.openhab.binding.enocean.internal.messages.ERP1Message;

/**
 *
 * @author Daniel Weber - Initial contribution
 */
public abstract class _VLDMessage extends EEP {

    public _VLDMessage() {
        super();
    }

    public _VLDMessage(ERP1Message packet) {
        super(packet);
    }

    @Override
    protected int getDataLength() {
        if (packet != null) {
            return packet.getPayload().length - SenderIdLength - RORGLength - StatusLength;
        } else {
            return bytes.length;
        }
    }

    @Override
    protected boolean validateData(byte[] bytes) {
        return true;
    }

}
