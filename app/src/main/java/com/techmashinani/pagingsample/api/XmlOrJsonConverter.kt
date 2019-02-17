package com.techmashinani.datasourcesample.api

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.lang.reflect.Type

class XmlOrJsonConverter : Converter.Factory() {
    private val xml: Converter.Factory = SimpleXmlConverterFactory.create()
    private val json: Converter.Factory = GsonConverterFactory.create()

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        var converter:  Converter<ResponseBody, *>? = null
        annotations.forEach { annotation ->
            when(annotation.annotationClass) {
                Xml::class ->  {
                    converter = xml.responseBodyConverter(type, annotations, retrofit)
                }
                Json::class -> {
                    converter = json.responseBodyConverter(type, annotations, retrofit)
                }
            }
        }
        return converter!!
    }
}