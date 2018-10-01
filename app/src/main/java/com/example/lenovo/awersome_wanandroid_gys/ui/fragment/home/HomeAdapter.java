package com.example.lenovo.awersome_wanandroid_gys.ui.fragment.home;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lenovo.awersome_wanandroid_gys.R;
import com.example.lenovo.awersome_wanandroid_gys.bean.Datas;

import java.util.ArrayList;

class HomeAdapter extends BaseQuickAdapter<Datas,BaseViewHolder> {

    public HomeAdapter(ArrayList<Datas> list) {
        super(R.layout.home_item,list);

    }

    @Override
    protected void convert(BaseViewHolder helper, Datas item) {
        helper.setText(R.id.author,item.getAuthor());
        helper.setText(R.id.chapterName,item.getSuperChapterName()+"/"+item.getChapterName());
        helper.setText(R.id.desc,item.getTitle());
        helper.setText(R.id.niceDate,item.getNiceDate());


    }
}
