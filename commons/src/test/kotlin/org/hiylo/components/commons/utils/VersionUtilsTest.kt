package org.hiylo.components.commons.utils

import org.junit.Test

class VersionUtilsTest {
    @Test
    fun testGetNewVersion() {
        print(VersionUtils.getNewVersion("1.0.1", false))
    }
}