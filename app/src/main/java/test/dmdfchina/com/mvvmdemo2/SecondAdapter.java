package test.dmdfchina.com.mvvmdemo2;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by mkt on 2018/1/4.
 */

public class SecondAdapter<T> extends RecyclerView.Adapter<SecondAdapter.RecHolder> {
    private List<T> mList;
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;

    private int firstVariableId;
    private int secondVariableId;

    private int firstLayoutId;
    private int secondLayoutId;

    public SecondAdapter(List<T> mList, int firstVariableId, int secondVariableId, int firstLayoutId, int secondLayoutId) {
        this.mList = mList;
        this.firstVariableId = firstVariableId;
        this.secondVariableId = secondVariableId;
        this.firstLayoutId = firstLayoutId;
        this.secondLayoutId = secondLayoutId;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE_ONE;
        }
        return TYPE_TWO;
    }

    @Override
    public RecHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding=null;
        if (viewType == TYPE_ONE) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), firstLayoutId, parent, false);
        } else {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), secondLayoutId, parent, false);
        }
        SecondAdapter.RecHolder holder = new SecondAdapter.RecHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(SecondAdapter.RecHolder holder, int position) {
        if (getItemViewType(position) == TYPE_ONE) {
            holder.getBinding().setVariable(firstVariableId, mList.get(position));
        } else {
            holder.getBinding().setVariable(secondVariableId, mList.get(position));
        }

        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    /*内容布局器*/
    class RecHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public RecHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }
    }
}
