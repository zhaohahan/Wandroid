package com.mr.tengyu.wandroid.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.data.entity.HomeArticleBean;
import com.mr.tengyu.wandroid.data.entity.HomeBannerBean;
import com.mr.tengyu.wandroid.ui.main.WebActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRV_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<HomeArticleBean.DataBean.DatasBean> list;
    private ArrayList<HomeBannerBean.DataBean> bannerList;

    public MyRV_adapter(Context context, ArrayList<HomeArticleBean.DataBean.DatasBean> list, ArrayList<HomeBannerBean.DataBean> bannerList) {
        this.context = context;
        this.list = list;
        this.bannerList = bannerList;
    }
    public void setList(ArrayList<HomeArticleBean.DataBean.DatasBean> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 2){

            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.layout_homebanner , null, false );
            viewHolder  = new ViewHolderC( inflate );
            return viewHolder;

        }else if (viewType == 1) {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.item1_home_article , null, false );
            viewHolder  = new ViewHolderA ( inflate );
            return  viewHolder;
        }else {
            View inflate = LayoutInflater.from ( context ).inflate ( R.layout.item1_home_article2 , null, false );
            viewHolder  = new ViewHolderB ( inflate );
            return  viewHolder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final HomeArticleBean.DataBean.DatasBean datasBean = list.get ( position );
        if(holder instanceof ViewHolderA){
            ViewHolderA viewHolderA = (ViewHolderA) holder;
            if (datasBean.getAuthor ().equals ( "" )){
                viewHolderA.home_author.setText ( datasBean.getShareUser () );
            }else {
                viewHolderA.home_author.setText ( datasBean.getAuthor () );
            }

            viewHolderA.home_time.setText ( datasBean.getNiceDate () );
            viewHolderA.home_type.setText ( "<font color=#FF3C46>"+datasBean.getSuperChapterName ()+"<front>"+"·"+datasBean.getChapterName () );
            viewHolderA.home_title.setText ("    "+ datasBean.getTitle () );
        }if (holder instanceof  ViewHolderB){
            ViewHolderB viewHolderb = (ViewHolderB) holder;
            viewHolderb.home_author2.setText ( datasBean.getAuthor () );
            viewHolderb.home_time2.setText ( datasBean.getNiceDate () );
            viewHolderb.home_desc2.setText ( datasBean.getNiceDate () );
            viewHolderb.home_type2.setText ( datasBean.getSuperChapterName ()+"·"+datasBean.getChapterName () );
            viewHolderb.home_title2.setText ( datasBean.getTitle () );
            Glide.with ( context ).load ( datasBean.getEnvelopePic () ).into ( viewHolderb.home_article_img2 );
        }
        if(holder instanceof ViewHolderC){
            ViewHolderC viewHolderC = (ViewHolderC) holder;
            viewHolderC.banner.setImages (  bannerList )
                      .setImageLoader ( new ImageLoader ( ) {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            HomeBannerBean.DataBean dataBean = (HomeBannerBean.DataBean) path;
                            Glide.with ( context ).load ( dataBean.getImagePath ( ) ).into ( imageView );
                        }
                    } ).setOnBannerListener ( new OnBannerListener ( ) {
                @Override
                public void OnBannerClick(int position) {
                     onBannerClicklisenter.sendURL ( position );
                }
            } ).start ( );
        }

        holder.itemView.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                onClicklisenter.sendURL ( datasBean );
            }
        } );

    }


    @Override
    public int getItemCount() {
        return list.size ();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 2;
        }
        if (list.get ( position ).getEnvelopePic ().equals ( "" )){
            return 1;
        }else {
            return 0;
        }
     }


    private class ViewHolderA extends RecyclerView.ViewHolder {
        private TextView home_author;
        private TextView home_time;
        private TextView home_title;
        private TextView home_type;
        private ImageView home_connect;
        public ViewHolderA(View inflate) {
            super ( inflate );
            home_author = inflate.findViewById ( R.id.home_author );
            home_time = inflate.findViewById ( R.id.home_time );
            home_title = inflate.findViewById ( R.id.home_title );
            home_type = inflate.findViewById ( R.id.home_type );
            home_connect = inflate.findViewById ( R.id.home_connect );
        }
    }

    private class ViewHolderB extends RecyclerView.ViewHolder {
        private TextView home_author2;
        private TextView home_time2;
        private TextView home_title2;
        private TextView home_type2;
        private ImageView home_connect2;
        private ImageView home_article_img2;
        private TextView home_desc2;
        public ViewHolderB(View inflate) {
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
    private class ViewHolderC extends RecyclerView.ViewHolder {
        private Banner banner;
        public ViewHolderC(View inflate) {
            super ( inflate );
            banner = inflate.findViewById ( R.id.home_banner );

        }
    }
    private OnClicklisenter onClicklisenter;

    public void setOnClicklisenter(OnClicklisenter onClicklisenter) {
        this.onClicklisenter = onClicklisenter;
    }

    interface OnClicklisenter{
        void  sendURL(HomeArticleBean.DataBean.DatasBean datasBean);
    }

    private OnBannerClicklisenter onBannerClicklisenter;

    public void setOnBannerClicklisenter(OnBannerClicklisenter onBannerClicklisenter) {
        this.onBannerClicklisenter = onBannerClicklisenter;
    }

    interface OnBannerClicklisenter{
        void  sendURL(int position);
    }



}
