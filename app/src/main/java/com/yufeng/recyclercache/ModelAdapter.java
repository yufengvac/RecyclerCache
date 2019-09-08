package com.yufeng.recyclercache;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeng on 2019/8/25.
 */

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelHolder> {
    public static final int TYPE_0 = 0;
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_4 = 4;

    private List<Model> mData = new ArrayList<>();
    private Context context;

    private boolean isNight = false;

    private Model getItem(int position) {
        if (position >= 1 && position <= getData().size()) {
            return mData.get(position - 1);
        } else {
            return null;
        }
//        return mData.get(position);
    }

    public void setNight(boolean night) {
        isNight = night;
    }

    public void setData(List<Model> list) {
        mData.clear();
        if (list != null) {
            mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        if (position == 0) {
            return "head".hashCode();
        } else if (position == getItemCount() - 1) {
            return "foot".hashCode();
        } else {
            return getItem(position).getId();
        }
    }

    public List<Model> getData() {
        return mData;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_3;
        } else if (position == getItemCount() - 1) {
            return TYPE_4;
        } else if (getItem(position).getType() == Model.TYPE_0) {
            return TYPE_0;
        } else if (getItem(position).getType() == Model.TYPE_1) {
            return TYPE_1;
        } else if (getItem(position).getType() == Model.TYPE_2) {
            return TYPE_2;
        }
        return super.getItemViewType(position);
    }

    @Override
    public ModelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        if (viewType == Model.TYPE_0) {
            return new ModelHolder0(LayoutInflater.from(context).inflate(R.layout.item_type_0, parent, false));
        } else if (viewType == Model.TYPE_1) {
            return new ModelHolder1(LayoutInflater.from(context).inflate(R.layout.item_type_1, parent, false));
        } else if (viewType == Model.TYPE_2) {
            return new ModelHolder2(LayoutInflater.from(context).inflate(R.layout.item_type_2, parent, false));
        } else if (viewType == Model.TYPE_3) {
            return new ModelHolder3(LayoutInflater.from(context).inflate(R.layout.item_type_3, parent, false));
        } else {
            return new ModelHolder4(LayoutInflater.from(context).inflate(R.layout.item_type_3, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(ModelHolder holder, int position) {
        try {
            Log.e("ModelAdapter", "onBindViewHolder, position=" + position);
            Model model = getItem(position);
            if (holder instanceof ModelHolder0) {
                ModelHolder0 modelHolder0 = (ModelHolder0) holder;
                modelHolder0.gradientView.setBackgroundResource(isNight ? R.drawable.gradient_black : R.drawable.gradient);
                modelHolder0.bottomView.setBackgroundColor(isNight ? Color.BLACK : Color.WHITE);
            } else if (holder instanceof ModelHolder1) {
                ModelHolder1 modelHolder1 = (ModelHolder1) holder;
                modelHolder1.gradientView.setBackgroundResource(isNight ? R.drawable.gradient_black : R.drawable.gradient);
                modelHolder1.bottomView.setBackgroundColor(isNight ? Color.BLACK : Color.WHITE);
            } else if (holder instanceof ModelHolder2) {
                ModelHolder2 modelHolder2 = (ModelHolder2) holder;
                Glide.with(context.getApplicationContext()).load(model.getUrl()).into(modelHolder2.iv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mData.size() + 2;
    }

    class ModelHolder extends RecyclerView.ViewHolder {

        ModelHolder(View view) {
            super(view);
        }
    }

    private class ModelHolder0 extends ModelHolder {
        private View gradientView, bottomView;

        ModelHolder0(View view) {
            super(view);
            gradientView = view.findViewById(R.id.item_type_0_gradient_view);
            bottomView = view.findViewById(R.id.item_type_0_bottom_view);
        }
    }

    private class ModelHolder1 extends ModelHolder {
        private View gradientView, bottomView;

        ModelHolder1(View view) {
            super(view);
            gradientView = view.findViewById(R.id.item_type_1_gradient_view);
            bottomView = view.findViewById(R.id.item_type_1_bottom_view);
        }
    }

    private class ModelHolder2 extends ModelHolder {
        private ImageView iv;

        ModelHolder2(View view) {
            super(view);
            iv = view.findViewById(R.id.item_type_2_iv);
        }
    }

    private class ModelHolder3 extends ModelHolder {
        private ImageView iv;

        ModelHolder3(View view) {
            super(view);
            iv = view.findViewById(R.id.item_type_3_iv);
        }
    }

    private class ModelHolder4 extends ModelHolder {
        private ImageView iv;

        ModelHolder4(View view) {
            super(view);
        }
    }
}
