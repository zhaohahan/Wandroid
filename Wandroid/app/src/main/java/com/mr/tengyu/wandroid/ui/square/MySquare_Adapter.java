package com.mr.tengyu.wandroid.ui.square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.data.entity.SquareBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MySquare_Adapter extends RecyclerView.Adapter<MySquare_Adapter.ViewHolder> {
    private Context context;
    private ArrayList<SquareBean.DataBean.DatasBean> list;

    public void setList(ArrayList<SquareBean.DataBean.DatasBean> list) {
        this.list = list;
    }

    public MySquare_Adapter(Context context, ArrayList<SquareBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.item1_home_article , null, false );
        ViewHolder viewHolder = new ViewHolder ( inflate );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SquareBean.DataBean.DatasBean datasBean = list.get ( position );
        if (datasBean.getAuthor ().equals ( "" )){
            holder.home_author.setText ( datasBean.getShareUser () );
        }else {
            holder.home_author.setText ( datasBean.getAuthor () );
        }
        holder.home_time.setText ( datasBean.getNiceDate () );
        holder.home_type.setText ( datasBean.getSuperChapterName ()+"·"+datasBean.getChapterName () );
        holder.home_title.setText ("    "+ datasBean.getTitle () );
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView home_author;
        private TextView home_time;
        private TextView home_title;
        private TextView home_type;
        private ImageView home_connect;
        public ViewHolder(@NonNull View inflate) {
            super ( inflate );
            home_author = inflate.findViewById ( R.id.home_author );
            home_time = inflate.findViewById ( R.id.home_time );
            home_title = inflate.findViewById ( R.id.home_title );
            home_type = inflate.findViewById ( R.id.home_type );
            home_connect = inflate.findViewById ( R.id.home_connect );
        }
    }
    private OnClicklisenter onClicklisenter;

    public void setOnClicklisenter(OnClicklisenter onClicklisenter) {
        this.onClicklisenter = onClicklisenter;
    }

    interface OnClicklisenter{
        void sendURL(SquareBean.DataBean.DatasBean datasBean);
    }
}
