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
package org.openhab.binding.somfytahoma.internal.model;

/**
 * The {@link SomfyTahomaLoginResponse} holds information about login
 * response to your TahomaLink account.
 *
 * @author Ondrej Pecta - Initial contribution
 */
public class SomfyTahomaLoginResponse {

    private boolean success;
    private String version;

    public boolean isSuccess() {
        return success;
    }

    public String getVersion() {
        return version;
    }
}
