package com.example.tmsandroid.dz.dz26alt.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.tmsandroid.databinding.ItemWordBinding
import com.example.tmsandroid.dz.dz26alt.model.Word

class ListAdapter(private val deleteStrings: List<String>, private val delete: (Word) -> Unit) :
    RecyclerView.Adapter<ListAdapter.WordViewHolder>() {

    private var wordList = emptyList<Word>()

    class WordViewHolder(val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(word: Word, deleteStrings: List<String>, delete: (Word) -> Unit) {
            binding.tvWord.text = word.word
            binding.bDeleteItem.setOnClickListener {
                val title = deleteStrings[0] + word.word + "?"
                val message = deleteStrings[1] + word.word + "?"
                val yes = deleteStrings[2]
                val no = deleteStrings[3]
                val builder = AlertDialog.Builder(binding.root.context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(yes) { _, _ ->
                        delete(word)
                    }
                    .setNegativeButton(no) { _, _ -> }
                    .create()
                builder.show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding =
            ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(wordList[position], deleteStrings, delete)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    fun setData(list: List<Word>) {
        this.wordList = list
    }
}