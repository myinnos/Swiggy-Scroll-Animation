package in.myinnos.swiggyanimation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<DataModel> foodList;
    private DataModel food;

    RecyclerAdapter(Context context, List<DataModel> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        food = foodList.get(i);
        holder.txCategory.setText(food.getCategory());
        holder.tvTitle.setText(food.getTitle());
        holder.txOffer.setText(food.getOffer());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imOffer)
        ImageView imOffer;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.txCategory)
        TextView txCategory;
        @BindView(R.id.txOffer)
        TextView txOffer;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    void recyclerViewScrolled(RecyclerView recyclerView, int scrollAmount) {

        RecyclerAdapter.ViewHolder holder = null;

        int starPos = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int lastPos = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();

        if (starPos <= lastPos) {
            while (true) {
                holder = (RecyclerAdapter.ViewHolder) recyclerView.findViewHolderForLayoutPosition(starPos);
                if (holder != null) {
                    holder.imOffer.setRotation(holder.imOffer.getRotation() + (float) scrollAmount);
                }
                if (starPos == lastPos) {
                    break;
                }
                ++starPos;
            }
        }
    }
}
