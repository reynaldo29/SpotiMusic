package com.contreras.spotimusic

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.contreras.spotimusic.databinding.ActivityMainBinding
import com.contreras.spotimusic.databinding.ItemMusicBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var musicListRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        setRecyclerView()
    }
    private fun setRecyclerView(){
        musicListRecyclerView = binding.musicsList
        musicListRecyclerView.layoutManager=LinearLayoutManager(this)
        val musics=MusicRepository()
        val musicAdapter=MusicAdapter(musics.musics)
        musicListRecyclerView.adapter=musicAdapter
    }

}