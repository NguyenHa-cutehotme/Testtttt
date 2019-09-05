package com.t3h.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {
    private Activity activity;
    private ArrayList<Article> listAticle;
    private NewItemListener listener;
    public ArticleAdapter(Activity activity, ArrayList<Article> listAticle) {
        this.activity = activity;
        this.listAticle = listAticle;
    }

    public void setListener(NewItemListener listener) {
        this.listener = listener;
    }

    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item,parent,false);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArticleHolder holder, final int position) {
        final Article article = listAticle.get(position);
        holder.tvTitle.setText(article.getTitle()+"\n"+article.getDecription());
        Glide.with(activity)
                .load(article.getThumnail())
                .into(holder.imgThumnal);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (listener != null) {
                    listener.onLongClick(position);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAticle.size();
    }

    class ArticleHolder extends RecyclerView.ViewHolder{

        private ImageView imgThumnal;
        private TextView tvTitle;
        public ArticleHolder(View itemView) {
            super(itemView);
            imgThumnal = (ImageView) itemView.findViewById(R.id.img_thumb);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);

        }
    }
    public interface NewItemListener {
        void onClick(int position);

        void onLongClick(int postition);
    }

}

