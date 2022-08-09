package com.example.ejerciciotcnicorappi.testutils

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.net.URLDecoder

object ResourceLoader {

    private const val COLON_SPACE = ":\\s"
    private const val COLON = ":"

    fun loadContentFromFile(fileName: String? = null): String {
        if (fileName.isNullOrEmpty()) {
            return ""
        }

        val inputStream = this::class.java.classLoader?.getResourceAsStream(fileName)
        BufferedReader(InputStreamReader(inputStream) as Reader?).use { br ->
            val sb = StringBuilder()
            var line = br.readLine()

            while (line != null) {
                sb.append(line.trim().replace(COLON_SPACE.toRegex(), COLON))
                line = br.readLine()
            }
            return sb.toString()
        }
    }

    fun getResourcePath(fileName: String): String =
        URLDecoder.decode(this::class.java.classLoader?.getResource(fileName)?.file, "UTF-8")
}