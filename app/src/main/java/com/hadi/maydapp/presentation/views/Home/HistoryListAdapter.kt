package com.hadi.maydapp.presentation.views.Home

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hadi.maydapp.R
import com.hadi.maydapp.databinding.LinkHistoryItemBinding
import com.hadi.maydapp.presentation.models.LinkUIModel
import kotlinx.android.synthetic.main.link_history_item.view.*

class HistoryListAdapter () : RecyclerView.Adapter<HistoryListAdapter.ViewHolder>() {

    private val links: MutableList<LinkUIModel> = ArrayList()
    private var layoutInflater: LayoutInflater? = null
    private lateinit var  context: Context


    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        context = parent.context

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
        viewHolder.binding.linkCopyButton.setOnClickListener {
            it.background = context.getDrawable(R.drawable.shorten_background_btn_copied)

            it.apply {
                background = context.getDrawable(R.drawable.shorten_background_btn_copied)
                link_copy_button.text = context.getText(R.string.copied_text)
                context.copyToClipboard(links[position].short_link)
            }

        }



    }

    override fun getItemCount() = links.size


    @Suppress("unused")
    fun clear() {
        links.clear()
        notifyDataSetChanged()
    }


    fun providelinkHistoryList(newPosts: List<LinkUIModel>?) {

        newPosts?.let {
            links.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun Context.copyToClipboard(text: CharSequence){
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label",text)
        clipboard.setPrimaryClip(clip)
    }

    class ViewHolder(val binding: LinkHistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}
