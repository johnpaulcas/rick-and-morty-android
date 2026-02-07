package com.johnpaulcas.rickandmorty.features.character.domain

sealed class Gender(val name: String) {
    object Male: Gender("Male")
    object Female: Gender("Female")
    object GenderLess: Gender("No gender")
    object Unknown: Gender("Not specified")
}