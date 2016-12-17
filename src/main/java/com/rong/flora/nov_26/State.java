package com.rong.flora.nov_26;

import java.util.stream.StreamSupport;

/**
 * Created by rongwf1 on 2016/11/27.
 */
public enum State {
    C_CLOSED{
        @Override
        State next(){
            return C_RUNNING;
        }
    },
    C_RUNNING{
        @Override
        State next(){
            return C_RUNNING;
        }
    },
    C_CLOSING{
        @Override
        State next(){
            return C_CLOSED;
        }
    },
    S_CLOSED{
        @Override
        State next(){
            return S_STARTING;
        }
    },
    S_RUNNING{
        @Override
        State next(){
            return S_CLOSING;
        }
    },
    S_STARTING{
        @Override
        State next(){
            return S_RUNNING;
        }
    },
    S_CLOSING{
        @Override
        State next(){
            return S_CLOSED;
        }
    },
    TERMIANL;


    State next(){
        System.out.println(" default state is terminal state");
        return TERMIANL;
    }
}
