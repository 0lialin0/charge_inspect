package cn.wtkj.charge_inspect.views.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wtkj.charge_inspect.R;
import cn.wtkj.charge_inspect.mvp.MvpBaseActivity;
import cn.wtkj.charge_inspect.mvp.presenter.BusinessInfoPresenter;
import cn.wtkj.charge_inspect.mvp.presenter.BusinessInfoPresenterImpl;
import cn.wtkj.charge_inspect.mvp.views.BusinessInfoView;

/**
 * Created by ghj on 2016/9/19.
 */
public class BusinessInfoDetailActivity extends MvpBaseActivity<BusinessInfoPresenter> implements
        BusinessInfoView, View.OnClickListener {

    @Bind(R.id.aty_toolbar)
    Toolbar mToolbar;
    @Bind(R.id.aty_tvTitle)
    TextView tvTitle;
    @Bind(R.id.iv_left)
    ImageView ivLeft;
    @Bind(R.id.iv_more)
    ImageView ivMore;
    @Bind(R.id.iv_phone)
    ImageView ivPhone;

   /* @Bind(R.id.laws_news_list)
    RecyclerView lawsNewsList;*/

    @Override
    protected BusinessInfoPresenter createPresenter() {
        return new BusinessInfoPresenterImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_info_detail);
        ButterKnife.bind(this);
        presenter.attachContextIntent(this, this.getIntent());
        presenter.startPresenter();
        initToolBar();
        initView();
    }

    private void initToolBar() {
        tvTitle.setText(R.string.information);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    public void initView() {
        ivMore.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        /*LinearLayoutManager manager = new LinearLayoutManager(this);
        lawsNewsList.setLayoutManager(manager);
        lawsNewsList.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));*/
    }


    @Override
    public void showList(String[] items, int[] imgs) {

    }

    @Override
    public void showLoding() {

    }

    @Override
    public void hideLoging() {

    }

    @Override
    public void nextView(String phone) {

    }

    @Override
    public void showMes(String msg) {

    }

    @OnClick({R.id.iv_left,R.id.iv_yewu_a})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_left:
                this.finish();
                break;
            case R.id.iv_yewu_a:

                break;
        }
    }
}