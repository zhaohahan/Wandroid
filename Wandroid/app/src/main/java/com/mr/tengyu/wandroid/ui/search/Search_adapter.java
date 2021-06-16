package com.mr.tengyu.wandroid.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mr.tengyu.wandroid.R;
import com.mr.tengyu.wandroid.data.entity.SearchAuthorBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Search_adapter extends RecyclerView.Adapter<Search_adapter.ViewHolder> {
    private Context context;
    private ArrayList<SearchAuthorBean.DataBean.DatasBean> list;

    public void setList(ArrayList<SearchAuthorBean.DataBean.DatasBean> list) {
        this.list = list;
    }

    public Search_adapter(Context context, ArrayList<SearchAuthorBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.layout_search_author, null );
        ViewHolder viewHolder = new ViewHolder ( inflate );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SearchAuthorBean.DataBean.DatasBean datasBean = list.get ( position );
        holder.author.setText ( datasBean.getAuthor () );
        holder.title.setText ( datasBean.getTitle () );
        holder.time.setText ( datasBean.getNiceDate ());
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView author;
        TextView time;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            time = itemView.findViewById ( R.id.search_time );
            title = itemView.findViewById ( R.id.search_text );
            author = itemView.findViewById ( R.id.search_author );

        }
    }
}
