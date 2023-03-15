package com.hapkiduki.lovy.common.decoder

import android.net.Uri
import javax.inject.Inject

class UriDecoder @Inject constructor() : StringDecoder {
    override fun decodeString(encodeString: String): String {
        return Uri.decode(encodeString)
    }
}