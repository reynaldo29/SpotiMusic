package com.contreras.spotimusic

class MusicRepository (val musics:MutableList<Music> = ArrayList()){
    init{
        getDataMusics()
    }
    fun getDataMusics():List<Music>{
        musics.add(Music(1,"Thunder","AC/DC","Rock","ic_artist1"))
        musics.add(Music(2,"Tres","Libido","Rock","ic_artist2"))
        musics.add(Music(3,"Chachachá","Jósean Log","Bachata","ic_artist3"))
        musics.add(Music(4,"Soy guapo","faraón","Rap","ic_artist4"))
        musics.add(Music(5,"What's up","4 Non Blondes","Rock","ic_artist5"))
        musics.add(Music(6,"Me Vas a Extrañar","N'samble","Salsa","ic_artist6"))
        musics.add(Music(7,"Somebody Else ","The 1975","Pop","ic_artist7"))
        return musics
    }
}