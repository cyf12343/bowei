package com.cdhxqh.bowei.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cdhxqh.bowei.R;
import com.cdhxqh.bowei.bean.MaterialInfo;
import com.cdhxqh.bowei.ui.adapter.RealMaterialConsumeAdapter;

import java.util.ArrayList;

/**
 * Created by think on 2015/8/25.
 */
public class RealMaterialConsunmeFragment extends Fragment {
    private RecyclerView recyclerView;
    private RealMaterialConsumeAdapter materialConsumeAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_5, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView = (RecyclerView) view.findViewById(R.id.material_consume_list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        materialConsumeAdapter = new RealMaterialConsumeAdapter(getActivity());
        recyclerView.setAdapter(materialConsumeAdapter);
        addData();
        return view;
    }

    private void addData() {
        ArrayList<MaterialInfo> list = new ArrayList<MaterialInfo>();
        for (int i = 0; i < 6; i++) {
            MaterialInfo materialInfo = new MaterialInfo();
            materialInfo.setNumber("LSD888"+i);
            materialInfo.setName("螺丝刀");
            materialInfo.setSize(50+i);
            materialInfo.setWarehouse("仓库"+i);
            list.add(i,materialInfo);
        }
        materialConsumeAdapter.update(list, true);
    }
    public void adddata(MaterialInfo materialInfo){
        ArrayList<MaterialInfo> list = new ArrayList<MaterialInfo>();
        list.add(0,materialInfo);
        materialConsumeAdapter.update(list, true);
    }
}
