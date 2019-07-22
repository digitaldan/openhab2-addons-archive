package org.openhab.binding.hydrawise.internal.api.model;

import java.util.LinkedList;
import java.util.List;

public class LocalScheduleResponse extends Response {

    private List<Running> running = new LinkedList<Running>();

    private List<Relay> relays = new LinkedList<Relay>();

    private String name;

    private Integer time;

    /**
     * @return
     */
    public List<Running> getRunning() {
        return running;
    }

    /**
     * @param running
     */
    public void setRunning(List<Running> running) {
        this.running = running;
    }

    /**
     * @return
     */
    public List<Relay> getRelays() {
        return relays;
    }

    /**
     * @param relays
     */
    public void setRelays(List<Relay> relays) {
        this.relays = relays;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public Integer getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(Integer time) {
        this.time = time;
    }
}
