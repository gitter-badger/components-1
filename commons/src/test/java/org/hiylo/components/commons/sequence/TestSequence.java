/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : TestSequence.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.sequence;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.hiylo.components.commons.SequenceUtils;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSequence {
    @Rule
    public ContiPerfRule i = new ContiPerfRule();
    SequenceUtils sequence = new SequenceUtils();
    List<String> idsStr = new ArrayList<String>(20000000);
    List<String> ids = new ArrayList<String>(20000000);
    @Test
    @PerfTest(invocations = 200000000, threads = 1)
    public void testNextId() {
        String id = sequence.getSequence() + "";
        if (ids.contains(id)) {
            System.err.println("error");
            System.exit(0);
        } else {
//            log.debug(id);
        }
    }

    @Test
//    @PerfTest(invocations = 200000000, threads = 1)
    public void testNextIdStr() {
        String id = sequence.getSequence() + "";
        System.out.println(id);
    }

}
