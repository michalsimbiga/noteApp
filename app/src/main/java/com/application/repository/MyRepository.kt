package com.application.repository

import com.application.model.Joke
import com.application.model.Note
import com.application.net.Response
import com.application.net.RestApi
import java.util.Date

@Suppress("UNCHECKED_CAST")
class MyRepository(private val restApi: RestApi) : BaseRepository() {

    private val mockedNotes = listOf(
        Note(
            created = Date(1577973662000),
            title = "Mi first note",
            content = "this is first note content"
        ),
        Note(
            created = Date(1578675912000),
            title = "Mi second note",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vivamus at augue eget arcu dictum varius. Purus viverra accumsan in nisl nisi scelerisque eu ultrices. Tincidunt eget nullam non nisi est. Sed sed risus pretium quam vulputate dignissim. Arcu non sodales neque sodales ut etiam sit amet. Pellentesque sit amet porttitor eget dolor morbi non. Ut lectus arcu bibendum at varius. Pretium viverra suspendisse potenti nullam ac. Libero nunc consequat interdum varius sit amet mattis vulputate enim. Euismod lacinia at quis risus sed vulputate odio ut."
        ),
        Note(
            created = Date(1578848712000),
            title = "Mi third note",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vivamus at augue eget arcu dictum varius. Purus viverra accumsan in nisl nisi scelerisque eu ultrices. Tincidunt eget nullam non nisi est. Sed sed risus pretium quam vulputate dignissim. Arcu non sodales neque sodales ut etiam sit amet. Pellentesque sit amet porttitor eget dolor morbi non. Ut lectus arcu bibendum at varius. Pretium viverra suspendisse potenti nullam ac. Libero nunc consequat interdum varius sit amet mattis vulputate enim. Euismod lacinia at quis risus sed vulputate odio ut."
        ),
        Note(
            created = Date(1578675912000),
            title = "Mi fourth note",
            content = "this is fourth note content"
        ),
        Note(
            created = Date(1578848712000),
            title = "Mi fifth note",
            content = "this is fifth note content"
        ),
        Note(
            created = Date(1578675912000),
            title = "Mi sixth note",
            content = "this is sixth note content"
        ),
        Note(
            created = Date(1578848712000),
            title = "Mi seventh note",
            content = "this is seventh note content"
        )
    )

    suspend fun getJokes(): Response<List<Joke>> {
        val result = call { restApi.getJokes() }

        return if (result is Response.Success) {
            Response.Success(result.data.value)
        } else result as Response<List<Joke>>
    }

    suspend fun getSavedNotes(): List<Note> = mockedNotes
}
