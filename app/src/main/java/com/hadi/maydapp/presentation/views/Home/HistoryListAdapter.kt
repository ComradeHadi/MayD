package com.hadi.maydapp.presentation.views.Home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hadi.maydapp.R
import com.hadi.maydapp.databinding.LinkHistoryItemBinding
import com.hadi.maydapp.presentation.models.LinkUIModel

class HistoryListAdapter () : RecyclerView.Adapter<HistoryListAdapter.ViewHolder>() {

    private val links: MutableList<LinkUIModel> = ArrayList()
    private var layoutInflater: LayoutInflater? = null


    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }


        val binding: LinkHistoryItemBinding = DataBindingUtil.inflate(layoutInflater!!, R.layout.link_history_item, parent, false)

        return ViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.binding.fullLink.text = links[position].original_link
        viewHolder.binding.shortLink.text = links[position].full_short_link



    }

    override fun getItemCount() = links.size


    @Suppress("unused")
    fun clear() {
        links.clear()
        notifyDataSetChanged()
    }


    fun providelinkHistoryList(newPosts: List<LinkUIModel>?) {
        newPosts?.forEach(){
            Log.e("111111 test x",  it.toString())

        }
        newPosts?.let {
            //links.clear()
            links.addAll(it)
            notifyDataSetChanged()
        }
    }

    class ViewHolder(val binding: LinkHistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}
