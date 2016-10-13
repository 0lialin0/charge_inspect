package cn.wtkj.charge_inspect.views.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.wtkj.charge_inspect.R;
import cn.wtkj.charge_inspect.data.bean.ArticleDetail;
import cn.wtkj.charge_inspect.data.bean.ArticleListData;

/**
 * Created by lcl on 2016/9/30.
 */
public class ArticleAttachmentListAdapter extends RecyclerView.Adapter<ArticleAttachmentListAdapter.ShedViewHolder> {
    private Context context;
    private List<ArticleDetail.MData.info.files> fileList;
    private OnItemClickListener3 onItemClickListener;

    public ArticleAttachmentListAdapter(Context context, List<ArticleDetail.MData.info.files> fileList) {
        this.context = context;
        this.fileList = fileList;
    }

    public void setOnItemClickListener(OnItemClickListener3 onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ShedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_article_attachment_list, parent, false);
        return new ArticleAttachmentListAdapter.ShedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShedViewHolder holder, final int position) {
        holder.title.setText(fileList.get(position).getFileName());
        //holder.fileSize.setText(fileList.get(position).getFileSize());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(fileList.get(position).getFileName(),position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
       return fileList.size();
    }

    public class ShedViewHolder extends RecyclerView.ViewHolder {


        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.fileSize)
        TextView fileSize;

        public ShedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
