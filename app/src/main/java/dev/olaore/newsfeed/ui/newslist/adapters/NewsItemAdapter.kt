package dev.olaore.newsfeed.ui.newslist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.olaore.newsfeed.R
import dev.olaore.newsfeed.data.models.newslist.domain.DomainNewsItem
import dev.olaore.newsfeed.data.models.newslist.remote.NewsItem
import dev.olaore.newsfeed.databinding.ItemNewsBinding
import dev.olaore.newsfeed.util.launchInBrowser

class NewsItemAdapter(
    private val items: List<DomainNewsItem>
) : RecyclerView.Adapter<NewsItemAdapter.NewsItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        return NewsItemViewHolder.from(parent);
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val newsItem = items[position]
        holder.bind(newsItem)
    }

    override fun getItemCount() = items.size

    class NewsItemViewHolder(
        private val binding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DomainNewsItem) {

            binding.newsItem = item;
            binding.root.setOnClickListener {
                if (item.url.isNotEmpty()) {
                    item.url.launchInBrowser(itemView.context)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): NewsItemViewHolder {
                return NewsItemViewHolder(
                    ItemNewsBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }

    }

}