package org.hiylo.components.commons.utils

open class OsUtils {

    companion object {
        private val OS = System.getProperty("os.name").toLowerCase()

        private val _instance: OsUtils = OsUtils()

        fun isLinux(): Boolean {
            return OS.indexOf("linux") >= 0
        }

        fun isMacOS(): Boolean {
            return OS.indexOf("mac") >= 0 && OS.indexOf("os") > 0 && OS.indexOf("x") < 0
        }

        fun isMacOSX(): Boolean {
            return OS.indexOf("mac") >= 0 && OS.indexOf("os") > 0 && OS.indexOf("x") > 0
        }

        fun isWindows(): Boolean {
            return OS.indexOf("windows") >= 0
        }

        fun isOS2(): Boolean {
            return OS.indexOf("os/2") >= 0
        }

        fun isSolaris(): Boolean {
            return OS.indexOf("solaris") >= 0
        }

        fun isSunOS(): Boolean {
            return OS.indexOf("sunos") >= 0
        }

        fun isMPEiX(): Boolean {
            return OS.indexOf("mpe/ix") >= 0
        }

        fun isHPUX(): Boolean {
            return OS.indexOf("hp-ux") >= 0
        }

        fun isAix(): Boolean {
            return OS.indexOf("aix") >= 0
        }

        fun isOS390(): Boolean {
            return OS.indexOf("os/390") >= 0
        }

        fun isFreeBSD(): Boolean {
            return OS.indexOf("freebsd") >= 0
        }

        fun isIrix(): Boolean {
            return OS.indexOf("irix") >= 0
        }

        fun isDigitalUnix(): Boolean {
            return OS.indexOf("digital") >= 0 && OS.indexOf("unix") > 0
        }

        fun isNetWare(): Boolean {
            return OS.indexOf("netware") >= 0
        }

        fun isOSF1(): Boolean {
            return OS.indexOf("osf1") >= 0
        }

        fun isOpenVMS(): Boolean {
            return OS.indexOf("openvms") >= 0
        }
    }
}