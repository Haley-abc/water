package com.example.water11.ui.dashboard.progress;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.water11.R;

public class ProgressFragment extends Fragment {

    private ProgressViewModel mViewModel;
    private ListView mListView;
    private  String[] names={"用户16","用户95","用户32","用户95","用户33","用户15","用户12","用户16","用户95","用户32","用户95","用户33","用户15","用户12"};
    private int[] icons={R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2,R.drawable.head2};

    public static ProgressFragment newInstance() {
        return new ProgressFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.progress_fragment, container, false);
        mListView=root.findViewById(R.id.progress_list);
        mListView.setAdapter(new MyBaseAdapter());
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProgressViewModel.class);
        // TODO: Use the ViewModel
    }

    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names [position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//组装数据
            View view=View.inflate(getActivity(),R.layout.list_item,null);//在list_item中有两个id,现在要把他们拿过来
            TextView mTextView=(TextView) view.findViewById(R.id.tv_list);
            ImageView imageView=(ImageView)view.findViewById(R.id.image);
            //组件一拿到，开始组装
            mTextView.setText(names[position]);
            imageView.setBackgroundResource(icons[position]);
            //组装玩开始返回
            return view;
        }
    }
}
