package com.rong.flora.practice;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

import static com.rong.flora.practice.CaseStatus.*;

/**
 * Created by lafengnan on 16/7/12.
 */
public class TestCaseStatus {
    private CaseStatus caseStatus = STOPPED;

    public void status(){
        System.out.println(caseStatus);
        caseStatus = RUNNING;
        System.out.println(caseStatus);
        caseStatus = new Random().nextInt() > 0 ? SUCCESS : FAIL;
        System.out.println(caseStatus);

        switch (caseStatus){
            case STOPPED:
                break;
            case RUNNING:
                break;
            case SUCCESS:
                break;
            case FAIL:
                break;
            default:
                break;
        }
    }

    public static void main(String[] args){
        TestCaseStatus testCaseStatus = new TestCaseStatus();
        testCaseStatus.status();
        System.out.println(CaseStatus.valueOf(0));
        System.out.println(CaseStatus.valueOf(1));
        System.out.println(CaseStatus.valueOf(2));
        System.out.println(CaseStatus.valueOf(3));
        System.out.println(CaseStatus.valueOf(4));
    }
}
