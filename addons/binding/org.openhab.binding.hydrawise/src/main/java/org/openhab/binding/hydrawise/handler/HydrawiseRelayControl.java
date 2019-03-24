package org.openhab.binding.hydrawise.handler;

import org.eclipse.jdt.annotation.NonNull;
import org.openhab.binding.hydrawise.config.HydrawiseRelayConfiguration;

public interface HydrawiseRelayControl {
    /**
     * @param config
     */
    public void runRelay(@NonNull HydrawiseRelayConfiguration config);

    /**
     * @param duration
     * @param config
     */
    public void runRelay(int duration, @NonNull HydrawiseRelayConfiguration config);

    /**
     * @param config
     */
    public void stopRelay(@NonNull HydrawiseRelayConfiguration config);
}
