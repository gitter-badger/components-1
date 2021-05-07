package org.hiylo.components.commons.utils

import lombok.extern.slf4j.Slf4j
import org.hiylo.components.exceptions.CommonsRuntimeException
import org.hiylo.components.exceptions.Constants
import java.util.*

@Slf4j
class VersionUtils {
    companion object {
        fun getNewVersion(version: String, isPrimary: Boolean): String {
            if (Objects.isNull(version) || StringUtils.isEmpty(version)) {
                throw CommonsRuntimeException.buildException(Constants.EXCEPTION_CODE_EINVAL) as CommonsRuntimeException
            }
            val versionCodes = version.split("\\.".toRegex()).toTypedArray()
            if (versionCodes.size > 1) {
                if (isPrimary) {
                    versionCodes[0] = (versionCodes[0].toInt() + 1).toString()
                } else {
                    versionCodes[versionCodes.size - 1] = (versionCodes[versionCodes.size - 1].toInt() + 1).toString()
                }
                var newVersion = ""
                for (versionCode in versionCodes) {
                    newVersion += "$versionCode."
                }
                return newVersion.substring(0, newVersion.length - 1);
            } else {
                return (versionCodes[0].toInt() + 1).toString()
            }
        }

        fun getNewVersion(version: String): String {
            return getNewVersion(version, false)
        }
    }
}