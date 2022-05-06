package com.contreras.spotimusic

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.contreras.spotimusic.databinding.ItemMusicBinding

class MusicAdapter(public val dataSet: List<Music>): RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    /**
     * Proporciona una referencia al tipo de vistas que está utilizando
     * (custom ViewHolder).
     */
    class ViewHolder(public val binding: ItemMusicBinding) : RecyclerView.ViewHolder(binding.root) {
        var picture: ImageView = binding.pictureImage
        var song: TextView = binding.songText
        var author: TextView = binding.authorText
        var additionalText: TextView = binding.aditionalText
        var btnViewDetail: Button = binding.btnGoTeacher
        var gender:TextView = binding.gender
        var sharebuttom:ImageButton=binding.compartir
        var playbuttom:ImageButton=binding.playbuttom
        var stopbuttom:ImageButton=binding.stopbuttom
        var starbuttom:ImageView=binding.starbuttom

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Crear una nueva vista, que define la interfaz de usuario del elemento de la lista
        val itemBinding = ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    // Reemplazar el contenido de una vista (invocado por el administrador de diseño)
    override fun onBindViewHolder(binding: ViewHolder, position: Int) {

        // Obtenga el elemento de su conjunto de datos en esta posición y reemplace el contenido de la vista con ese elemento

        val music: Music = this.dataSet[position]

        val context = binding.itemView.context

        val idRes = context.resources.getIdentifier(music.picture, "drawable", context.packageName)

        binding.song.text = music.song
        binding.author.text = music.author
        binding.picture.setImageResource(idRes)
        binding.gender.text=music.gender
        binding.picture.setOnClickListener {
            Toast.makeText(context, "Click Picture $position", Toast.LENGTH_SHORT).show()

        }

        binding.playbuttom.setOnClickListener{
            Toast.makeText(context,music.song,Toast.LENGTH_SHORT).show()
        }
        binding.stopbuttom.setOnClickListener{
            Toast.makeText(context,music.song,Toast.LENGTH_SHORT).show()
        }
        

        binding.sharebuttom.setOnClickListener{
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://api.whatsapp.com/send?text=${music.song}")
                context.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        if (music.gender =="Rock" ) {
            binding.starbuttom.visibility=View.VISIBLE
        }
    }
    //Devuelve el tamaño de tu conjunto de datos (invocado por el administrador de diseño)
    override fun getItemCount(): Int = dataSet.size



}
