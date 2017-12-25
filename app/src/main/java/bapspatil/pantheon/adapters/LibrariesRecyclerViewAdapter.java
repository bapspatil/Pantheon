package bapspatil.pantheon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bapspatil.pantheon.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bapspatil
 */

public class LibrariesRecyclerViewAdapter extends RecyclerView.Adapter<LibrariesRecyclerViewAdapter.LibraryViewHolder> {
    private ArrayList<String> mLibrariesList;
    private Context mContext;

    public LibrariesRecyclerViewAdapter(Context context, ArrayList<String> librariesList) {
        this.mContext = context;
        this.mLibrariesList = librariesList;
    }

    @Override
    public LibraryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_library, parent, false);
        return new LibraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LibraryViewHolder holder, int position) {
        holder.libraryTextView.setText(mLibrariesList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mLibrariesList == null) return 0;
        else return mLibrariesList.size();
    }

    public class LibraryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.library_tv) TextView libraryTextView;

        public LibraryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
