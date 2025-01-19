package com.json.jandroid.activity.main


import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.json.base.BaseActivity
import com.json.base.adapter.AdapterItemListener
import com.json.jandroid.databinding.ActivityMainBinding
import com.json.jandroid.R
import com.json.jandroid.BR
import com.json.jandroid.activity.view.SecondActivity
import com.json.jandroid.adapter.AdapterFirstList
import com.json.jandroid.repository.data.FirstListData


class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>()  {
    private val adapter = AdapterFirstList()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModelId(): Int {
       return BR.mainVM
    }

    override fun initViewData() {
         val firstListData = listOf(
            FirstListData(
                icon = R.drawable.first_title_item_1, // 通过资源 ID 引用
                title = "5 min/day",
                subTitle = "Casual",
                isSelect = false
            ),
            FirstListData(
                icon = R.drawable.first_title_item_2,
                title = "10 min/day",
                subTitle = "Regular",
                isSelect = false
            ),
            FirstListData(
                icon = R.drawable.first_title_item_3,
                title = "15 min/day",
                subTitle = "Serious",
                isSelect = false
            ),
             FirstListData(
                 icon = R.drawable.first_title_item_4,
                 title = "20 min/day",
                 subTitle = "Intense",
                 isSelect = false
             )
        )
        binding?.firstTitleList?.layoutManager = LinearLayoutManager(this)
        binding?.firstTitleList?.adapter = adapter
        adapter.setDataList(firstListData)
        adapter.setItemListener(object: AdapterItemListener<FirstListData>(){
            override fun itemClick(item: FirstListData?, position: Int) {
            }
        })

        binding?.firstBtnId?.setOnClickListener{

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


    }





}
