package com.mr.tengyu.wandroid.ui.project.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.data.entity.ProjectArticleBean;
import com.mr.tengyu.wandroid.ui.publicer.adapter.MyPublicRV_adapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyProjectArticleRV_adapter extends RecyclerView.Adapter<MyProjectArticleRV_adapter.ViewHolder> {
    private ArrayList<ProjectArticleBean.DataBean.DatasBean> list;
    private Context context;

    public void setList(ArrayList<ProjectArticleBean.DataBean.DatasBean> list) {
        this.list = list;
    }

    public MyProjectArticleRV_adapter(ArrayList<ProjectArticleBean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.item1_home_article2, null );
        ViewHolder viewHolder = new ViewHolder ( inflate );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ProjectArticleBean.DataBean.DatasBean datasBean = list.get ( position );
        holder.home_author2.setText ( datasBean.getAuthor () );
        holder.home_time2.setText ( datasBean.getNiceDate () );
        holder.home_desc2.setText ( datasBean.getNiceDate () );
        holder.home_type2.setText ( datasBean.getSuperChapterName ()+"·"+datasBean.getChapterName () );
        holder.home_title2.setText ( datasBean.getTitle () );
        Glide.with ( context ).load ( datasBean.getEnvelopePic () ).into ( holder.home_article_img2 );
        holder.itemView.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                onClicklisenter.sendURl ( datasBean );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView home_author2;
        private TextView home_time2;
        private TextView home_title2;
        private TextView home_type2;
        private ImageView home_connect2;
        private ImageView home_article_img2;
        private TextView home_desc2;
        public ViewHolder(@NonNull View inflate) {
            super ( inflate );
            home_author2 = inflate.findViewById ( R.id.home_author2 );
            home_time2 = inflate.findViewById ( R.id.home_time2 );
            home_article_img2 = inflate.findViewById ( R.id.home_article_img2 );
            home_title2 = inflate.findViewById ( R.id.home_title2 );
            home_desc2 = inflate.findViewById ( R.id.home_desc2 );
            home_type2 = inflate.findViewById ( R.id.home_type2 );
            home_connect2 = inflate.findViewById ( R.id.home_connect2 );
        }
    }
    private OnClicklisenter onClicklisenter;

    public void setOnClicklisenter(OnClicklisenter onClicklisenter) {
        this.onClicklisenter = onClicklisenter;
    }

    public interface OnClicklisenter{
        void sendURl(ProjectArticleBean.DataBean.DatasBean datasBean);
    }

}
