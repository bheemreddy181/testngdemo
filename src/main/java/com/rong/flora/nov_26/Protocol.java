package com.rong.flora.nov_26;

/**
 * Created by rong on 2016/12/1.
 */
public class Protocol {
    private static int flag = 0;
    /**
     * flag identifies the appearance of protocol fields.
     * bit 31 ~ bit 8 are reserved.
     * bit 7 ~ bit 6 identifies protocol status
     * 00 - CLOSED
     * 01 - STARTING
     * 10 - RUNNING
     * 11 - CLOSING
     *
     * bit 5 - identifies client/server
     * 0 - client; 1 - server
     *
     * bit 4 ~ bit 1 identifies message types
     * bit 4 - video
     * bit 3 - audio
     * bit 2 - img
     * bit 1 - txt
     *
     * bit 0 - identifies charging status
     * 0 - free
     * 1 - charging
     */

    public boolean checkMessage(Message message) {
        return 1 <= message.messageType() &&
                message.messageType() <= 4 &&
                 (flag & (1 << (message.messageType())))!= 0;

    }


}
