package org.hiylo.components.commons.zip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipTest {

    @Test
    void compress() {

    }

    @Test
    void uncompress() {
        new Zip().uncompress("G:/postgresql-12.3-1-windows-x64.zip", "G:/test");
    }
}