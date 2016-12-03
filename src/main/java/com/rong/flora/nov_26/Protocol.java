package com.rong.flora.nov_26;

import org.apache.log4j.Logger;

import java.util.Date;

/**
 * Created by rong on 2016/12/1.
 */
public class Protocol {
    private static final Logger logger = Logger.getLogger(Protocol.class);
    private Integer life;
    private Integer src;
    private Integer dst;
    private String ts;
    private  int options;

    public Protocol(){
        this.life = 10;
        this.ts = new Date().toString();
        // original version is 1
        options |= 1<<4;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getSrc() {
        return src;
    }

    public void setSrc(Integer src) {
        this.src = src;
    }

    public Integer getDst() {
        return dst;
    }

    public void setDst(Integer dst) {
        this.dst = dst;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }


    /**
     * options identifies the appearance of protocol fields.
     * bit 31 ~ bit 8 are reserved.
     *
     * bit 4 ~ bit 7 - identifies protocol version
     * bit 4 lst
     * bit 7 hst
     *
     * bit 0 ~ bit 3 identifies message types
     * bit 3 - video
     * bit 2 - audio
     * bit 1 - img
     * bit 0 - txt
     *
     */

    public void setType(String type){
        switch (type){
            case "txt":
                this.options |= 1<<0;
                break;

            case "img":
                this.options |= 1<<1;
                break;
            case "audio":
                this.options |= 1<<2;
                break;

            case "video":
                this.options |= 1<<3;
                break;
            default:

                logger.debug(" no such type");
                break;
        }
    }
}
