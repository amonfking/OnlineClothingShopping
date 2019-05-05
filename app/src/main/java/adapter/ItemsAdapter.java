package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onlineclothingshopping.R;

import java.util.List;

import modal.Items;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {
    Context mContext;
    List<Items> itemLists;


    public ItemsAdapter(Context mContext, List<Items> itemLists) {
        this.mContext = mContext;
        this.itemLists = itemLists;
    }

    @NonNull
    @Override
    public ItemsAdapter.ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_add_item, viewGroup, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemsViewHolder itemsViewHolder, int i) {
        final Items item = itemLists.get(i);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
