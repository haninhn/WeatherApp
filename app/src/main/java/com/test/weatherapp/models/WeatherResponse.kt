package com.test.weatherapp.models

import java.io.Serializable

data class WeatherResponse(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
): Serializable  //fil storage ( in different form) in fame as a  string  for exmpl so we need to put Serializable
//for example we want to storage  weatherResponse in form string in the phone so we need to make it Serializable