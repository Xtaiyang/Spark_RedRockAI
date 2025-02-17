package com.example.redrockai.module.schoolroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.redrockai.lib.utils.formatNumberToTime
import com.example.redrockai.module.schoolroom.R
import com.example.redrockai.module.schoolroom.bean.RelatedCategoryBean

class RelatedIntroduceAdapter :
    ListAdapter<RelatedCategoryBean.Item, RelatedIntroduceAdapter.ViewHolder>(object :
        DiffUtil.ItemCallback<RelatedCategoryBean.Item>() {
        override fun areItemsTheSame(
            oldItem: RelatedCategoryBean.Item, newItem: RelatedCategoryBean.Item
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RelatedCategoryBean.Item,
            newItem: RelatedCategoryBean.Item
        ): Boolean {
            return oldItem == newItem
        }
    }
    ) {

    private var mItemClick: ((RelatedCategoryBean.Item) -> Unit)? = null

    fun setOnClassItemClickListener(cl: ((RelatedCategoryBean.Item) -> Unit)) {
        mItemClick = cl
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_course_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = getItem(position)
        holder.bind(itemData)

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        init {
            view.setOnClickListener {
                mItemClick?.invoke(getItem(adapterPosition))
            }
        }

        private val playImage: ImageView = view.findViewById(R.id.banner_image)
        private val itemTitle: TextView = view.findViewById(R.id.course_item_title)
        private val itemDesc: TextView = view.findViewById(R.id.course_item_descr)
        private val itemTime: TextView = view.findViewById(R.id.course_item_time)


        fun bind(itemData: RelatedCategoryBean.Item) {

            itemTitle.text = itemData.data.content.data.title
            itemDesc.text = itemData.data.content.data.description
            itemTime.text=formatNumberToTime(itemData.data.content.data.duration)
            Glide.with(itemView).load(itemData.data.content.data.cover.detail).into(playImage)
        }


    }
}
