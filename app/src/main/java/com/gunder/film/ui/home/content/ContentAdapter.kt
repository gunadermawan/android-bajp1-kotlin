package com.gunder.film.ui.home.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gunder.film.R
import com.gunder.film.model.DataEntity
import kotlinx.android.synthetic.main.list_item.view.*

class ContentAdapter(private val callBack: ContentCallBack) :
    RecyclerView.Adapter<ContentAdapter.ListViewHolder>() {

    private val listData = ArrayList<DataEntity>()
    fun setData(data: List<DataEntity>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item, parent, false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: DataEntity) {
            with(itemView) {
                tv_title.text = data.title
                Glide.with(itemView.context)
                    .load(data.imgPoster)
                    .into(iv_item_photo)
                item_cv.setOnClickListener {
                    callBack.onItemClicked(data)
                }
            }
        }
    }
}